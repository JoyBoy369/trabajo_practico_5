package ar.edu.unju.fi.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoImplementacionService implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	
    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        
    	List<Alumno> alumnosList = alumnoRepository.findByEstado(true);
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnosList);

		return alumnosDTO;
    }

    @Override
    public void saveAlumno(AlumnoDTO alumnoDTO) {
    	
    	Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
    }

    @Override
    public AlumnoDTO getAlumnoById(Long id) {
       
    	Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);

		if (optionalAlumno.isPresent()) {
			Alumno alumno = optionalAlumno.get();
			AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(alumno);
			return alumnoDTO;
		} else {
			return null; 
		}
    }

    @Override
    public void updateAlumno(AlumnoDTO alumnoDTO) {
    	
    	Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(AlumnoDTO alumnoDTO) {
       
    	Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(false);
		alumnoRepository.save(alumno);
    }
}