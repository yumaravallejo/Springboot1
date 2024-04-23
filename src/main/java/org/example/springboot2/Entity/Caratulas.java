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
public class Caratulas {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
    @Id
    @Column(name = "id_caratula")
    private long idCaratula;
    @Column(name = "imagen")
    private String imagen;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false, orphanRemoval = true)
    @JoinColumn(name = "id_pelicula", nullable = false)
    private Peliculas peliculas;

}
