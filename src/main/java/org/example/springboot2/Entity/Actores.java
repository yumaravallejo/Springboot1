package org.example.springboot2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column (name="id_actor")
    private int idActor;
    @Column (name="id_pelicula")
    private long idPelicula;
    @Column (name="nombre_actor")
    private String nombreActor;
    @Column (name="apellido_act")
    private String apellidosAct;
    @Column (name="nacimiento_act")
    private LocalDate nacimientoAct;
    @Column (name = "edad_act")
    private int edadActor;;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Actores_peliculases",
            joinColumns = @JoinColumn(name = "actores_id_actor"),
            inverseJoinColumns = @JoinColumn(name = "peliculases_id_pelicula"))
    private Set<Peliculas> peliculases = new LinkedHashSet<>();

}
