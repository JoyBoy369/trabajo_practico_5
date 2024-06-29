package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Docente {
    private int legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
