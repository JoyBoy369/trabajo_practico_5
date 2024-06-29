package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Carrera {
    private int codigo;
    private String nombre;
    private int cantidadAnios;
    private boolean estado;

}