package org.example.springboot2.Respositories;

import org.example.springboot2.Entity.Actores;
import org.springframework.data.repository.CrudRepository; //Un map que contiene la clase y el tipo de id

public interface ActoresRepository extends CrudRepository<Actores, Long> {

}
