package org.example.springboot2.servicio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2.Dto.DirectorDto;
import org.example.springboot2.Entity.*;
import org.example.springboot2.Respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/*En los servicios crearemos a los métodos*/

@Service
public class SpringServices {
    @Autowired
    private PeliculasRepository peliculasRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ActoresRespository actoresRespository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private CaratulasRepository caratulasRepository;
    @Autowired
    private VentasRepository ventasRepository;

    public String insertarPelicula (String nombre, Integer duracion, String tipoPelicula) {
        Peliculas p1 = new Peliculas();
        p1.setNombrePeli(nombre);
        p1.setDuracion(duracion);
        p1.setTipoPelicula(tipoPelicula);

        peliculasRepository.save(p1); //Java lo guarda directamente en la base de datos --> Hace un insert dentro de la función

        return "Se ha insertado correctamente";

    }
    public String insertarActor (long idPelicula, String nombreActor, String apellidosAct, LocalDate nacimientoAct, int edadActor ) {

        Actores a1 = new Actores();
        a1.setIdPelicula(idPelicula);
        a1.setNombreActor(nombreActor);
        a1.setApellidosAct(apellidosAct);
        a1.setNacimientoAct(nacimientoAct);
        a1.setEdadActor(edadActor);
        actoresRespository.save(a1);
        return "Se ha insertado correctamente";
    }

    public String insertarDir (String json) {
        DirectorDto dir;
        try {
            dir = objectMapper.readValue(json, DirectorDto.class);
            Directores d1 = new Directores();
            d1.setNombreDir(dir.getNombreDir());
            d1.setApellidoDir(dir.getApellidoDir());
            d1.setNacimientoDir(dir.getNacimientoDir());
            d1.setEdadDir(dir.getEdadDir());
            directorRepository.save(d1);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "Se ha insertado correctamente";
    }

    public String insertarCaratula (String imagen) {
        Caratulas c1 = new Caratulas();
        c1.setImagen(imagen);
        caratulasRepository.save(c1);
        return "Se ha insertado correctamente";
    }

    public String insertarVenta(long idPelicula, String nombreVenta) {
        Ventas v1 = new Ventas();
        v1.setIdPelicula(idPelicula);
        v1.setNomVenta(nombreVenta);
        ventasRepository.save(v1);
        return "Se ha insertado correctamente";
    }

}
