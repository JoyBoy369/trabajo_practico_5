package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AlumnoDTO {
	
		private String id;
		
		@NotBlank(message="Debe ingresar DNI")
		@Size(min=8, max=8, message="El DNI debe de ser de 8 números")
		private String dni;
		
		@Size(min=2, max=20, message="El nombre debe de ser mayor a 2 caracteres y menor de 20")
		@NotBlank(message="Debe ingresar nombre")
	    private String nombre;
		
		@Size(min=2, max=20, message="El nombre debe de ser mayor a 2 caracteres y menor de 20")
		@NotBlank(message="Debe ingresar apellido")
	    private String apellido;
		
		@Email(regexp = ".+[@].+[\\.].+", message="Debe ingresar un email valido")
		@NotBlank(message="Este campo no puede estar vacio")
	    private String email;
		
		@NotBlank(message="Debe ingresar telefono")
		@Size(min=9, max=9, message="El número de teléfono debe de estar compuesto por 9 números.")
	    private String telefono;	
		
		@NotBlank(message="Debe ingresar fecha de nacimiento")
	    private String fechaNacimiento;	    
	    
		@Size(min=2, max=30, message="El nombre debe de ser mayor a 2 caracteres y menor de 30")
	    @NotBlank(message="Debe ingresar domicilio")
	    private String domicilio;
	    
	    @Size(min=5, max=5, message="La libreta universitaria debe de ser de 5 números")
	    @NotBlank(message="Debe ingresar libreta universitaria")
	    private String lu; // LU = Libreta Universitaria
	  
	    private String estado;
	    private List<Materia> materias;
	    
	    private Carrera carrera;
	    
}
