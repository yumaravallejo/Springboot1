package org.example.springboot2.Respositories;

import org.example.springboot2.Entity.Ventas;
import org.springframework.data.repository.CrudRepository; //Un map que contiene la clase y el tipo de id

public interface VentasRepository extends CrudRepository<Ventas, Long> {

}