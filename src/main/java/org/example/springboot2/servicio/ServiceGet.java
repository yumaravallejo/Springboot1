package org.example.springboot2.servicio;

import org.example.springboot2.Entity.Actores;
import org.example.springboot2.Entity.Caratulas;
import org.example.springboot2.Entity.Directores;
import org.example.springboot2.Entity.Peliculas;
import org.example.springboot2.Respositories.ActoresRespository;
import org.example.springboot2.Respositories.CaratulasRepository;
import org.example.springboot2.Respositories.DirectorRepository;
import org.example.springboot2.Respositories.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceGet {
    @Autowired
    private PeliculasRepository peliculasRepository;
    @Autowired
    private ActoresRespository actoresRespository;
    @Autowired
    private CaratulasRepository caratulasRepository;
    @Autowired
    private DirectorRepository directorRepository;

    public Peliculas getPelicula (long idPelicula) {
        Optional<Peliculas> opt = peliculasRepository.findById(idPelicula);
        return opt.orElse(null);
    }

    public Actores getActor(long idActor) {
        Optional<Actores> opt = actoresRespository.findById(idActor);
        return opt.orElse(null);
    }

    public Caratulas getCaratula (long idCaratula) {
        Optional<Caratulas> opt = caratulasRepository.findById(idCaratula);
        return opt.orElse(null);
    }

    public Directores getDirector(long idDirector) {
        Optional<Directores> opt = directorRepository.findById(idDirector);
        return opt.orElse(null);
    }
}
