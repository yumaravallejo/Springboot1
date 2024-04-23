package org.example.springboot2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2.Entity.Actores;
import org.example.springboot2.Entity.Caratulas;
import org.example.springboot2.Entity.Directores;
import org.example.springboot2.Entity.Peliculas;
import org.example.springboot2.servicio.ServiceDelete;
import org.example.springboot2.servicio.ServiceGet;
import org.example.springboot2.servicio.SpringServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class SpringControllerDelete {
    @Autowired
    private ServiceDelete serviceDelete;

    @DeleteMapping("/deletePelicula/{idPelicula}")
    public String deletePelicula(@PathVariable(value = "idPelicula") long idPelicula) {
        return serviceDelete.deletePelicula(idPelicula);
    }

    @DeleteMapping("/deleteActor/{idActor}")
    public String deleteActor(@PathVariable(value = "idActor") long idActor) {
        return serviceDelete.deleteActor(idActor);
    }

    @DeleteMapping("/deleteDirector/{idDirector}")
    public String deleteDirector(@PathVariable(value = "idDirector") long idDirector) {
        return serviceDelete.deleteDirector(idDirector);
    }

    @DeleteMapping("/deleteVenta/{idVentas}")
    public String deleteVentas(@PathVariable(value = "idVentas") long idVentas) {
        return serviceDelete.deleteVentas(idVentas);
    }

    @DeleteMapping("/deleteCaratula/{idCaratula}")
    public String deleteCaratula(@PathVariable(value = "idCaratula") long idCaratula) {
        return serviceDelete.deleteCaratulas(idCaratula);
    }

}
