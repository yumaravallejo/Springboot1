package org.example.springboot2.Respositories;

import org.example.springboot2.Entity.Directores;
import org.springframework.data.repository.CrudRepository; //Un map que contiene la clase y el tipo de id

import java.util.Optional;

public interface DirectorRepository extends CrudRepository<Directores, Long> {

}
