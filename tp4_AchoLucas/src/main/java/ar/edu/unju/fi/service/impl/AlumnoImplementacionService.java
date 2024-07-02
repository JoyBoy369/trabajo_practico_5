package ar.edu.unju.fi.service.impl;


import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoImplementacionService implements AlumnoService {

	private static final Log LOGGER = LogFactory.getLog(AlumnoImplementacionService.class);
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	
    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        
    	List<Alumno> alumnosList = alumnoRepository.findByEstado(true);
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnosList);
		LOGGER.info("Cantidad de alumnos en el listado: "+alumnosDTO.size()+".");
		return alumnosDTO;
    }

    @Override
    public void saveAlumno(AlumnoDTO alumnoDTO) {
    	
    	Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno guardado correctamente.");
    }

    @Override
    public AlumnoDTO getAlumnoById(Long id) {
       
    	Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
    	LOGGER.info("Buscando alumno.");
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
		LOGGER.info("Alumno editado correctamente.");
    }

    @Override
    public void deleteAlumno(AlumnoDTO alumnoDTO) {
       
    	Alumno alumno = alumnoMapper.toAlumno(alumnoDTO);
		alumno.setEstado(false);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno eliminado correctamente.");
    }
}