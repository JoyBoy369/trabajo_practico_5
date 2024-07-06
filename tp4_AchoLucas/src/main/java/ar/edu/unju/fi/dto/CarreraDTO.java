package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {
	
	private String id;
	
	@NotBlank(message="Ingrese codigo")
	@Size(min=2, max=2, message="El codigo debe ser de 2 digitos")
    private String codigo;
	
	@NotBlank(message="Ingrese nombre de la carrera")
	@Size(min=2, max=30, message="El nombre debe ser menor de 30 caracteres y mayora 2.")
    private String nombre;
	
	@NotBlank
	@Size(max=1, message="La cantidad de años no puede superar una cifra.")
    private String cantidadAnios;
    private String estado;
    
    private List<Materia> materias;
    
    private List<Alumno> alumnos;

}
