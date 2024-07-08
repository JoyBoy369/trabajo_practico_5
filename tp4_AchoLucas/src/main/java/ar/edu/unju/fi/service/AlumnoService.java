package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;


public interface AlumnoService {
	
    List<AlumnoDTO> getAllAlumnos();
    
    AlumnoDTO getAlumnoById(Long id);
    
    void saveAlumno(AlumnoDTO alumnoDTO); 
    
    void updateAlumno(AlumnoDTO alumnoDTO);
    
    void deleteAlumno(AlumnoDTO alumnoDTO);
    
    List<AlumnoDTO> filtrarAlumnos(Long idCarrera);
}