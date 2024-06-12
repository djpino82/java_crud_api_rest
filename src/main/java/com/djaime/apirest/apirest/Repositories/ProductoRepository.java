package com.djaime.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djaime.apirest.apirest.Entities.Producto;

                                            //JPA tiene todas las herramientas para conectar con una Base de Datos
public interface ProductoRepository extends JpaRepository<Producto, Long>{ //Producto viene del Entities y el Long es lo que pusimos delante de ID

}
