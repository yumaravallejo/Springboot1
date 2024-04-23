package org.example.springboot2.servicio;

import org.example.springboot2.Entity.*;
import org.example.springboot2.Respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceGet {
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

    public String getPelicula(long idPelicula, String nombre) {
        Optional<Peliculas> p1;
        if (nombre != null) {
            List<Peliculas> lista = peliculasRepository.findByNombrePeli(nombre);
            return lista.toString();
        } else {
            p1 = peliculasRepository.findById(idPelicula);
            if (p1.isPresent()) {
                return "Pelicula encontrada" + p1;
            } else {
                return "Pelicula no encontrada";
            }
        }
    }

    /* OBTENER PELICULA POR ID */
    public Peliculas getPeliculaId(long idPelicula) {
        Optional<Peliculas> opt = peliculasRepository.findById(idPelicula);
        return opt.orElse(null);
    }

    public Actores getActor(long idActor) {
        Optional<Actores> opt = actoresRepository.findById(idActor);
        return opt.orElse(null);
    }

    public Caratulas getCaratula(long idCaratula) {
        Optional<Caratulas> opt = caratulasRepository.findById(idCaratula);
        return opt.orElse(null);
    }

    public Directores getDirector(long idDirector) {
        Optional<Directores> opt = directorRepository.findById(idDirector);
        return opt.orElse(null);
    }

    public Ventas getVentas(long idVentas) {
        Optional<Ventas> opt = ventasRepository.findById(idVentas);
        return opt.orElse(null);
    }
}
