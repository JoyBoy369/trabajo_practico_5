package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DocenteDTO {
	
		private String id;
		
		@Size(min=2, max=2, message="El legajo debe de ser de 2 números")
		@NotBlank(message="Debe ingresar legajo")
		private String legajo;
		
		@Size(min=2, max=20, message="El nombre debe de ser mayor a 2 caracteres y menor de 20")
		@NotBlank(message="Debe ingresar nombre")
		private String nombre;
		
		@Size(min=2, max=20, message="El apellido debe de ser mayor a 2 caracteres y menor de 20")
		@NotBlank(message="Debe ingresar apellido")
		private String apellido;
		
		@Email(regexp = ".+[@].+[\\.].+", message="Debe ingresar un email valido")
		@NotBlank(message="Debe ingresar email")
		private String email;
		
		@NotBlank(message="Debe ingresar telefono")
		@Size(min=9, max=9, message="El número de teléfono debe de estar compuesto por 9 números.")
		private String telefono;
		
		private String estado;
		
		private Materia materia;
		
}
