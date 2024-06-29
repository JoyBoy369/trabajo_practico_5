package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceImp")
public class MateriaServiceImp implements IMateriaService {
	
	@Autowired
	private MateriaMapper materiaMapper;

	@Override
	public List<MateriaDTO> findAll() {
		
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriaDTOList(CollectionMateria.getMaterias());		
		
		return materiasDTO;
	}

	@Override
	public MateriaDTO findByCodigo(int codigo) {
	
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(CollectionMateria.buscarMateria(codigo));
		
		return materiaDTO;
	}

	@Override
	public void save(MateriaDTO materiaDTO) {
		
		Materia materia = materiaMapper.toMateria(materiaDTO);
		
		Docente docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		Carrera carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		materia.setDocente(docente);
		materia.setCarrera(carrera);
		
		CollectionMateria.agregarMateria(materia);
		
	}

	@Override
	public void deleteByCodigo(int codigo) {
		
		CollectionMateria.eliminarMateria(codigo);
	}

	@Override
	public void edit(MateriaDTO materiaDTO) {
		
		Materia materia = materiaMapper.toMateria(materiaDTO);
		
		Docente docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		Carrera carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		materia.setDocente(docente);
		materia.setCarrera(carrera);
	
		CollectionMateria.modificarMateria(materia);

	}

}
