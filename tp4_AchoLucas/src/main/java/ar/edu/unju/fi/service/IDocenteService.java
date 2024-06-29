package ar.edu.unju.fi.service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

import java.util.List;

public interface IDocenteService {
	
		public void agregarDocente(Docente docente);
		
		public List<DocenteDTO> getDocentes();
		
		public Docente buscarDocente(int legajo);
		
		public void modificarDocente(Docente docente);
		
		public void eliminarDocente(int legajo);
}
