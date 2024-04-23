package org.example.springboot2.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Como es un json no cogeremos entity
public class ActoresDto {
    private String nombreActor;

    private LocalDate nacimientoAct;

    private String apellidosAct;

    private int edadActor;

}
