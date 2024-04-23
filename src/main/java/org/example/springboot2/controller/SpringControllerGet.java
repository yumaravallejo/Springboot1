package org.example.springboot2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2.Entity.Actores;
import org.example.springboot2.Entity.Caratulas;
import org.example.springboot2.Entity.Directores;
import org.example.springboot2.Entity.Peliculas;
import org.example.springboot2.servicio.ServiceGet;
import org.example.springboot2.servicio.SpringServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringControllerGet {
    //@Autowired //Da automáticamente las dependencias
    //private SpringServices springServices; //El nombre es orientativo
    @Autowired
    private ServiceGet serviceGet;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/verPelicula/{idPelicula}")
    public String verSerie (@PathVariable (value = "idPelicula") long idPelicula) {
        Peliculas p1 = serviceGet.getPelicula(idPelicula);
        if (p1 == null) {
            return "Pelicula no encontrada";
        } else {
            return "Pelicula encontrada" + p1.toString();
        }
    }

    @GetMapping("/verActor/{idActor}")
    public String verActor (@PathVariable (value = "idActor") long idActor) {
        Actores a1 = serviceGet.getActor(idActor);
        if (a1 == null) {
            return "Actor no encontrado";
        } else {
            return "Actor encontrado" + a1.toString();
        }
    }

    //Generamos el json
    @GetMapping("/verDirector/{idDirector}")
    public String verDirector (@PathVariable (value = "idDirector") long idDirector) {
        Directores d1 = serviceGet.getDirector(idDirector);
        try {
            return objectMapper.writeValueAsString(d1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/verCaratula/{idCaratula}")
    public String verCaratula (@PathVariable (value = "idCaratula") long idCaratula) {
        Caratulas c1 = serviceGet.getCaratula(idCaratula);
        if (c1 == null) {
            return "Actor no encontrado";
        } else {
            return "Actor encontrado" + c1.toString();
        }
    }

}
