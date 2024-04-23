package org.example.springboot2.servicio;

import org.example.springboot2.Entity.Peliculas;
import org.example.springboot2.Respositories.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceGet {
    @Autowired
    private PeliculasRepository peliculasRepository;

    public Peliculas getPelicula (long idPelicula) {
        Optional<Peliculas> opt = peliculasRepository.findById(idPelicula);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
}
