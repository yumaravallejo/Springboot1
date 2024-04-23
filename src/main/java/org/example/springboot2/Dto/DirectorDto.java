package org.example.springboot2.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Como es un json no cogeremos entity
public class DirectorDto {
    private String nombreDir;
    private String apellidoDir;
    private LocalDate nacimientoDir;
    private int edadDir;
}
//DTO --> data transfer object
