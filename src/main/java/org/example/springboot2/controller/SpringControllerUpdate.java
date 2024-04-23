package org.example.springboot2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2.servicio.ServiceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringControllerUpdate {
    //@Autowired //Da automáticamente las dependencias
    //private SpringServices springServices; //El nombre es orientativo
    @Autowired
    private ServiceUpdate serviceUpdate;
    @Autowired
    private ObjectMapper objectMapper;

    @PutMapping("/updatePelicula/{idPelicula}")
    public String updatePelicula(@PathVariable("idPelicula") long idPelicula,
                                 @RequestBody String json) {

        return serviceUpdate.updatePelicula(idPelicula, json);
    }

    @PutMapping("/updateActor/{idActor}")
    public String updateActor(@PathVariable("idActor") long idActor,
                              @RequestBody String json) {
        return serviceUpdate.updateActor(idActor, json);
    }

    @PutMapping("/updateDirector/{idDirector}")
    public String updateDirector(@PathVariable("idDirector") long idDirector,
                              @RequestBody String json) {
        return serviceUpdate.updateDirector(idDirector, json);
    }

    @PutMapping("/updateCaratula/{idCaratula}")
    public String updateCaratula(@PathVariable("idCaratula") long idCaratula,
                              @RequestBody String json) {
        return serviceUpdate.updateCaratula(idCaratula, json);
    }

    @PutMapping("/updateVenta/{idVenta}")
    public String updateVenta(@PathVariable("idVenta") long idVenta,
                                 @RequestBody String json) {
        return serviceUpdate.updateVenta(idVenta, json);
    }


}
