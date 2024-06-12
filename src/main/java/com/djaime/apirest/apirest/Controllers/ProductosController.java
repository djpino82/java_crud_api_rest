package com.djaime.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RestController;
import com.djaime.apirest.apirest.Repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.djaime.apirest.apirest.Entities.Producto;


@RestController
@RequestMapping("/productos") // aqui va la Url donde van a acceder los clientes
public class ProductosController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping // se usa para traer/CONSEGUIR información
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();  // Me trae todos los productos
    }

    @GetMapping("/{id}")
    public Producto getProductobyId(@PathVariable Long id){
        return productoRepository.findById(id) // Devuelve el producto tal cual lo encontró
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));// Si no lo encuentra, lanzamos un error
    }


    @PostMapping // Para agregar/CREAR un nuevo Producto
    public Producto createProducto(@RequestBody Producto producto){ // Recibimos un body que es lo que dice la entidad, un nombre y un precio
        return productoRepository.save(producto); // Con esto nos devuelve un producto y guardamos el producto en la Base de Datos. y va a tener el ID autoincremental que se genero.
    }

    @PutMapping("/{id}") //Actualizar producto
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetaills){ // Por la Url vamos a recibir el Id del producto que se quiere modificar
        Producto producto =  productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));// Si no lo encuentra, lanzamos un error

        producto.setNombre(productoDetaills.getNombre());
        producto.setPrecio(productoDetaills.getPrecio());

        return productoRepository.save(producto); // Nos guarda el producto actualizado
    }  

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id){
        Producto producto =  productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));// Si no lo encuentra, lanzamos un error

        productoRepository.delete(producto);
        return "El producto con el ID: " + id + " fue eliminado correctamente";

    }
    
    


}