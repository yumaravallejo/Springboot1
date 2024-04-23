package org.example.springboot2.servicio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springboot2.Dto.*;
import org.example.springboot2.Entity.*;
import org.example.springboot2.Respositories.ActoresRepository;
import org.example.springboot2.Respositories.CaratulasRepository;
import org.example.springboot2.Respositories.DirectorRepository;
import org.example.springboot2.Respositories.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServiceUpdate {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PeliculasRepository peliculasRepository;
    @Autowired
    private ActoresRepository actoresRepository;
    @Autowired
    private CaratulasRepository caratulasRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private ServiceGet serviceGet;

    public String updatePelicula(long idPelicula, String json) {
        Peliculas p1 = serviceGet.getPeliculaId(idPelicula);
        PeliculasDto edit;
        if (p1 != null) {
            try {
                edit = objectMapper.readValue(json, PeliculasDto.class);
                Directores d1 = new Directores();
                p1.setNombrePeli(edit.getNombrePeli());
                p1.setDuracion(edit.getDuracion());
                p1.setTipoPelicula(edit.getTipoPelicula());
                peliculasRepository.save(p1);
                return "Película editada correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado la película";
        }
    }

    public String updateActor(long idActor, String json) {
        Actores a1 = serviceGet.getActor(idActor);
        ActoresDto edit;
        if (a1 != null) {
            try {
                edit = objectMapper.readValue(json, ActoresDto.class);
                a1.setNombreActor(edit.getNombreActor());
                a1.setApellidosAct(edit.getApellidosAct());
                a1.setNacimientoAct(edit.getNacimientoAct());
                a1.setEdadActor(edit.getEdadActor());
                actoresRepository.save(a1);
                return "Actor editado correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado el actor";
        }
    }

    public String updateDirector(long idDirector, String json) {
        Directores d1 = serviceGet.getDirector(idDirector);
        DirectorDto edit;
        if (d1 != null) {
            try {
                edit = objectMapper.readValue(json, DirectorDto.class);
                d1.setNombreDir(edit.getNombreDir());
                d1.setApellidoDir(edit.getApellidoDir());
                d1.setNacimientoDir(edit.getNacimientoDir());
                d1.setEdadDir(edit.getEdadDir());
                directorRepository.save(d1);
                return "Director editado correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado el director";
        }
    }

    public String updateCaratula(long idCaratula, String json) {
        Caratulas c1 = serviceGet.getCaratula(idCaratula);
        CaratulasDto edit;
        if (c1 != null) {
            try {
                edit = objectMapper.readValue(json, CaratulasDto.class);
                c1.setImagen(edit.getImagen());
                caratulasRepository.save(c1);
                return "Carátula editada correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado la carátula";
        }
    }

    public String updateVenta(long idVentas, String json) {
        Ventas v1 = serviceGet.getVentas(idVentas);
        VentasDto edit;
        if (v1 != null) {
            try {
                edit = objectMapper.readValue(json, VentasDto.class);
                v1.setNomVenta(edit.getNomventa());
                return "Venta editada correctamente";
            } catch (JsonMappingException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "No se ha editado la venta";
        }
    }

}
