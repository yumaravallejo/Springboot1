package org.example.springboot2.Respositories;

import org.example.springboot2.Entity.Caratulas;
import org.example.springboot2.Entity.Directores;
import org.springframework.data.repository.CrudRepository; //Un map que contiene la clase y el tipo de id

public interface CaratulasRepository extends CrudRepository<Caratulas, Long> {

}