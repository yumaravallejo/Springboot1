package org.example.springboot2.Respositories;

import org.example.springboot2.Entity.Peliculas;
import org.springframework.data.repository.CrudRepository; //Un map que contiene la clase y el tipo de id

public interface PeliculasRepository extends CrudRepository<Peliculas, Long> {

}
