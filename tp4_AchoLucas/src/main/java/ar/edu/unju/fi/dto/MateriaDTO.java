package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MateriaDTO {
	
		private String codigo;
	    private String nombre;
	    private String curso;
	    private String cantidadHoras;
	    private String modalidad; // virtual o presencial
	    private Docente docente;
	    private Carrera carrera;

}
