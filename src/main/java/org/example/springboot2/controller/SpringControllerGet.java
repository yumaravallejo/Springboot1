package org.example.springboot2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2.Entity.*;
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
    public String verSerie(@PathVariable(value = "idPelicula") long idPelicula, @RequestParam(value = "nombre", required = false) String nombre) {
        return serviceGet.getPelicula(idPelicula, nombre);
    }

    @GetMapping("/verActor/{idActor}")
    public String verActor(@PathVariable(value = "idActor") long idActor) {
        Actores a1 = serviceGet.getActor(idActor);
        if (a1 == null) {
            return "Actor no encontrado";
        } else {
            return "Actor encontrado" + a1.toString();
        }
    }

    //Generamos el json
    @GetMapping("/verDirector/{idDirector}")
    public String verDirector(@PathVariable(value = "idDirector") long idDirector) {
        Directores d1 = serviceGet.getDirector(idDirector);
        try {
            return objectMapper.writeValueAsString(d1);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/verCaratula/{idCaratula}")
    public String verCaratula(@PathVariable(value = "idCaratula") long idCaratula) {
        Caratulas c1 = serviceGet.getCaratula(idCaratula);
        if (c1 == null) {
            return "Actor no encontrado";
        } else {
            return "Actor encontrado" + c1.toString();
        }
    }

    @GetMapping("/verVenta/{idVentas}")
    public String verVenta(@PathVariable(value = "idVentas") long idVentas) {
        Ventas v1 = serviceGet.getVentas(idVentas);
        if (v1 == null) {
            return "Venta no encontrada";
        } else {
            return "Venta encontrada" + v1.toString();
        }
    }

}
