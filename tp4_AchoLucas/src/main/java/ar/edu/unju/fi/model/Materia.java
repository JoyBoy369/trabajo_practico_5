package ar.edu.unju.fi.model;



import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Materia {
    private int codigo;
    private String nombre;
    private String curso;
    private int cantidadHoras;
    private String modalidad; // virtual o presencial
    private Docente docente;
    private Carrera carrera;
    
    
  
}
