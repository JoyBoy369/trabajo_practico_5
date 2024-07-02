package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {
	
	private String id;
	
    private String codigo;
    private String nombre;
    private String cantidadAnios;
    private String estado;
    
    private List<Materia> materias;

}
