package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.mapper.MateriaMapperImpl;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceImp")
public class MateriaServiceImp implements IMateriaService {
	
	private static final Log LOGGER = LogFactory.getLog(MateriaServiceImp.class);
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private MateriaMapper materiaMapper;

	@Override
	public List<MateriaDTO> findAll() {
		
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriaDTOList(materiaRepository.findByEstado(true));		
		LOGGER.info("Cantidad de materias en el listado: "+materiasDTO.size()+".");
		return materiasDTO;
	}
	
	@Override
	public List<MateriaDTO> filtrarMaterias(Long idCarrera) {
	    List<Materia> materias = materiaRepository.findAll();
	    
	    // Filtra las materias por idCarrera //
	    List<Materia> materiasPorCarrera = materias.stream()
	            .filter(materia -> materia.getCarrera() != null && materia.getCarrera().getId().equals(idCarrera))
	            .filter(Materia :: isEstado) //estado sea true //
	            .collect(Collectors.toList());
	    
	    return materiaMapper.toMateriaDTOList(materiasPorCarrera);
	}


	@Override
	public MateriaDTO findById(Long id) {
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(materiaRepository.findById(id).get());
		LOGGER.info("Buscando materia.");
		return materiaDTO;
	}

	@Override
	public void save(MateriaDTO materiaDTO) {
		
		Materia materia = materiaMapper.toMateria(materiaDTO);

		  Carrera carrera = carreraRepository.findById(materia.getCarrera().getId()).get();
		  Docente docente = docenteRepository.findById(materia.getDocente().getId()).get();
		
		  materia.setCarrera(carrera);
		  materia.setDocente(docente);
		  materia.setEstado(true);
		  
		
		materiaRepository.save(materia);	
		LOGGER.info("Materia guardada correctamente.");
	}

	@Override
	public void deleteById(MateriaDTO materiaDTO) {
		
		Materia materia = materiaMapper.toMateria(materiaDTO);
		materia.setEstado(false);
		materia.setDocente(null);
		materia.setCarrera(null);
		materiaRepository.save(materia);
		LOGGER.info("Materia eliminada correctamente.");
	}

	@Override
	public void edit(MateriaDTO materiaDTO) {
		
		Materia materia = materiaMapper.toMateria(materiaDTO);
		
		Docente docente = docenteRepository.findById(materia.getCarrera().getId()).get();
		Carrera carrera = carreraRepository.findById(materia.getCarrera().getId()).get();
		
		materia.setDocente(docente);
		materia.setCarrera(carrera);
		
		materia.setEstado(true);
		materiaRepository.save(materia);
		LOGGER.info("Materia editada correctamente.");

	}

}
