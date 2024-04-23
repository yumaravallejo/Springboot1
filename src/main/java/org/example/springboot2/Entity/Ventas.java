package org.example.springboot2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Table /*Para que sepa que es una table de la base de datos*/
@Data /*Para no tener que poner getter, toString, setter, equals y hashcode*/
@Entity /*Para que sepa que es una entidad --> pide clave primaria @Id --> */
@NoArgsConstructor //Constructor con ningún parámetro
@AllArgsConstructor //Constructor con todos los parámetros
public class Ventas {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
    @Id
    @Column (name="id_ventas")
    private long idVentas;
    @Column (name="id_pelicula")
    private long idPelicula;
    @Column (name="nom_venta")
    private String nomVenta;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Ventas_peliculases",
            joinColumns = @JoinColumn(name = "ventas_id_ventas"),
            inverseJoinColumns = @JoinColumn(name = "peliculases_id_pelicula"))
    private Set<Peliculas> peliculases = new LinkedHashSet<>();

}
