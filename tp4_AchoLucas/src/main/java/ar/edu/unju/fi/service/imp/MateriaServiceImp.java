package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceImp")
public class MateriaServiceImp implements IMateriaService {
	
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
		
		return materiasDTO;
	}

	@Override
	public MateriaDTO findById(Long id) {
	
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(materiaRepository.findById(id).get());
		
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
	}

	@Override
	public void deleteById(MateriaDTO materiaDTO) {
		
		Materia materia = materiaMapper.toMateria(materiaDTO);
		materia.setEstado(false);
		materia.setDocente(null);
		materia.setCarrera(null);
		materiaRepository.save(materia);
		
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
		

	}

}
