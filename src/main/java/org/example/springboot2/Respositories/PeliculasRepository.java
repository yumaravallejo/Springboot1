package org.example.springboot2.Respositories;

import org.example.springboot2.Entity.Peliculas;
import org.springframework.data.repository.CrudRepository; //Un map que contiene la clase y el tipo de id

import java.util.List;

public interface PeliculasRepository extends CrudRepository<Peliculas, Long> {
    List<Peliculas> findByNombrePeli(String nombrePeli); //Un select por nombres --> nombre igual que Java
}
