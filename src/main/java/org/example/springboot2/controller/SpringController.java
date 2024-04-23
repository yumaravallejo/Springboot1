package org.example.springboot2.controller;

import org.example.springboot2.servicio.SpringServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
//Controller es el papa de restcontroller --> en @controller tienes que especificar lo que devuelve con @body
                   //RestController --> un controlador que da respuestas de por si (Respond body)
public class SpringController {
    @Autowired //Da automáticamente las dependencias
    private SpringServices springServices;
    @GetMapping("/insertarPelicula")
    public String insertarPeli(@PathVariable (value = "idDirector") long idDirector,
                            @RequestParam (value="nombre") String nombre,
                           @RequestParam (value="duracion") Integer duracion,
                           @RequestParam (value="tipoPelicula") String tipoPelicula) {

        return springServices.insertarPelicula(nombre, duracion, tipoPelicula);

    }

    @GetMapping("/insertarActor/{idPelicula}")
    public String insertarAct (@PathVariable (value = "idPelicula") long idPelicula,
                               @RequestParam (value = "nombreActor") String nombreActor,
                               @RequestParam (value = "apellidosAct") String apellidosAct,
                               @RequestParam (value = "nacimientoAct") LocalDate nacimientoAct,
                               @RequestParam (value = "edadActor") int edadActor) {

        return springServices.insertarActor(idPelicula, nombreActor, apellidosAct, nacimientoAct, edadActor);

    }

    @PostMapping("/insertarDirec")
    public String insertarDirec (@RequestBody String json) {
        return springServices.insertarDir(json);
    }

    @GetMapping("/insertarCaratula")
    public String insertarCarat (@PathVariable (value = "idPelicula") long idPelicula,
                                 @RequestParam (value = "imagen") String imagen) {
        return springServices.insertarCaratula(imagen);

    }



}
