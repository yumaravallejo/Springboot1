package org.example.springboot2.controller;

import org.example.springboot2.Entity.Peliculas;
import org.example.springboot2.servicio.ServiceGet;
import org.example.springboot2.servicio.SpringServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringControllerGet {
    @Autowired //Da automáticamente las dependencias
    private SpringServices springServices; //El nombre es orientativo
    @Autowired
    private ServiceGet serviceGet;

    @GetMapping("/verPelicula/{idPelicula}")
    public String verSerie (@PathVariable (value = "idPelicula") long idPelicula) {

    Peliculas p1 = serviceGet.getPelicula(idPelicula);
    if (p1 == null) {
        return "Pelicula no encontrada";
    } else {
        return "Pelicula encontrada" + p1.toString();
    }
    }
}
