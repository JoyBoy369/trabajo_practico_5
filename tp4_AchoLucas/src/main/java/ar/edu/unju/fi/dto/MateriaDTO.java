package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
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
	
		private String id;
	
		private String codigo;
	    private String nombre;
	    private String curso;
	    private String cantidadHoras;
	    private String modalidad; // virtual o presencial
	    private Docente docente;
	    private Carrera carrera;
	    
	    private String estado;
	    private List<Alumno> alumnos;

}
