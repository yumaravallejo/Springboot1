package org.example.springboot2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Table /*Para que sepa que es una table de la base de datos*/
@Data /*Para no tener que poner getter, toString, setter, equals y hashcode*/
@Entity /*Para que sepa que es una entidad --> pide clave primaria @Id --> */
@NoArgsConstructor //Constructor con ningún parámetro
@AllArgsConstructor //Constructor con todos los parámetros
public class Peliculas {
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Auto-increment
    @Id
    @Column (name="id_pelicula")
    private long idPelicula;
    @Column (name="nombre_peli")
    private String nombrePeli;
    @Column (name="duracion")
    private Integer duracion;
    @CreationTimestamp //Automáticamente te pone la fecha y hora
    @Column (name="fecha_creacion")
    private LocalDateTime fechCreacion;
    @Column (name="tipo_pelicula")
    private String tipoPelicula;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "id_director", nullable = false)
    private Directores directores;

    @ManyToMany(mappedBy = "peliculases")
    private Set<Actores> actoressss = new LinkedHashSet<>();

}
