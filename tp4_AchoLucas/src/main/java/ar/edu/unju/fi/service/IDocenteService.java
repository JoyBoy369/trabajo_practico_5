package ar.edu.unju.fi.service;

import ar.edu.unju.fi.dto.DocenteDTO;


import java.util.List;

public interface IDocenteService {		
		
		 List<DocenteDTO> getDocentes();
		 
		 List<DocenteDTO> getDocentesNoAsignados(); //Util para validad Materias //
		 		
		 DocenteDTO buscarDocente(Long id);
		
		 void agregarDocente(DocenteDTO docenteDTO);
		
		 void modificarDocente(DocenteDTO docenteDTO);
		
		 void eliminarDocente(DocenteDTO docenteDTO);
}
