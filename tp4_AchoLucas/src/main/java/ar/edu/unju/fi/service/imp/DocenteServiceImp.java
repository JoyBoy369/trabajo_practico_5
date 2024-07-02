package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;

@Service("docenteServiceImp")
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public List<DocenteDTO> getDocentes() {

		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(docenteRepository.findByEstado(true));
		return docentesDTO;
	}

						//Listado dee docentes que NO esten asignados a una materia todabia //
	@Override
	public List<DocenteDTO> getDocentesNoAsignados() {
		List<Docente> docentes = docenteRepository.findAll();
		List<Long> idsDocentesAsignados = materiaRepository.findByEstado(true).stream()
				.map(materia -> materia.getDocente().getId()).collect(Collectors.toList());

		List<Docente> docentesNoAsignados = docentes.stream()
				.filter(docente -> !idsDocentesAsignados.contains(docente.getId())).collect(Collectors.toList());

		return docenteMapper.toDocenteDTOList(docentesNoAsignados);
	}

	@Override
	public void agregarDocente(DocenteDTO docenteDTO) {

		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(true);

		docenteRepository.save(docente);

	}

	@Override
	public DocenteDTO buscarDocente(Long id) {

		return docenteMapper.toDocenteDTO(docenteRepository.findById(id).get());

	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTO) {

		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(true);
		docenteRepository.save(docente);
	}

	@Override
	public void eliminarDocente(DocenteDTO docenteDTO) {

		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(false);
		docenteRepository.save(docente);
	}
}
