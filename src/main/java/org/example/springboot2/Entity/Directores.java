package org.example.springboot2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
public class Directores {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
    @Id
    @Column (name="id_director")
    private long idDirector;
    @Column (name = "nombre_dir")
    private String nombreDir;
    @Column (name = "apellido_dir")
    private String apellidoDir;
    @Column (name = "nacimiento_dir")
    private LocalDate nacimientoDir;
    @Column (name = "edad_dir")
    private int edadDir;


}
