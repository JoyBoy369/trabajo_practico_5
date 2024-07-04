package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MateriaDTO {
	
		private String id;
		
		@Pattern(regexp = "\\d+", message = "Debe ingresar solo números")
		@NotBlank(message="Debe ingresar codigo")
		@Size(min=2, max=3, message="El codigo debe de tenerr entre 2 y 3 digitos.")
		private String codigo;
		
		@Size(min=2, max=20, message="El nombre debe de ser mayor a 2 caracteres y menor de 20")
		@NotBlank(message="Debe ingresar nombre")
	    private String nombre;
		
		@NotBlank(message="Debe ingresar curso")
	    private String curso;
		
		@Size(max=4, message="La cantidad de horas tiene un máximo de 4 digitos")
		@NotBlank(message="Debe ingresar la cantidad de horas")
	    private String cantidadHoras;
		
		
	    private String modalidad; // virtual o presencial
	    
	    @NotNull(message="Debe elegir un docente")
	    private Docente docente;
	    private Carrera carrera;
	    
	    private String estado;
	    private List<Alumno> alumnos;

}
