package org.example.springboot2.servicio;

import org.example.springboot2.Entity.*;
import org.example.springboot2.Respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDelete {
    @Autowired
    private PeliculasRepository peliculasRepository;
    @Autowired
    private ActoresRepository actoresRepository;
    @Autowired
    private CaratulasRepository caratulasRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private VentasRepository ventasRepository;

    public String deletePelicula(long idPelicula) {
        Optional<Peliculas> opt = peliculasRepository.findById(idPelicula);
        if (opt.isPresent()) {
            peliculasRepository.deleteById(idPelicula);
            return "Pelicula eliminada";
        } else {
            return "Pelicula no encontrada";
        }
    }

    public String deleteActor(long idActor) {
        Optional<Actores> opt = actoresRepository.findById(idActor);
        if (opt.isPresent()) {
            actoresRepository.deleteById(idActor);
            return "Actor eliminado";
        } else {
            return "Actor no encontrado";
        }
    }

    public String deleteDirector(long idDirector) {
        Optional<Directores> opt = directorRepository.findById(idDirector);
        if (opt.isPresent()) {
            directorRepository.deleteById(idDirector);
            return "Director eliminado";
        } else {
            return "Director no encontrado";
        }
    }

    public String deleteCaratulas(long idCaratula) {
        Optional<Caratulas> opt = caratulasRepository.findById(idCaratula);
        if (opt.isPresent()) {
            caratulasRepository.deleteById(idCaratula);
            return "Carátula eliminada";
        } else {
            return "Carátula no encontrada";
        }
    }

    public String deleteVentas(long idVentas) {
        Optional<Ventas> opt = ventasRepository.findById(idVentas);
        if (opt.isPresent()) {
            ventasRepository.deleteById(idVentas);
            return "Venta eliminada";
        } else {
            return "Venta no encontrada";
        }

    }

}
