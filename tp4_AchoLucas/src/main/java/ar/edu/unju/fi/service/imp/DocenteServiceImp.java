package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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

	private static final Log LOGGER = LogFactory.getLog(DocenteServiceImp.class);
	
	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public List<DocenteDTO> getDocentes() {

		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(docenteRepository.findByEstado(true));
		LOGGER.info("Cantidad de docentes totales en el listado: "+docentesDTO.size()+".");
		return docentesDTO;
	}

						//Listado dee docentes que NO esten asignados a una materia todabia //
	@Override
	public List<DocenteDTO> getDocentesNoAsignados() {
		List<Docente> docentes = docenteRepository.findAll();

	    // Obtener los IDs de docentes asignados a materias activas
	    List<Long> idsDocentesAsignados = materiaRepository.findByEstado(true).stream()
	            .map(materia -> materia.getDocente().getId())
	            .collect(Collectors.toList());

	    // Filtrar los docentes que no están asignados a materias activas y cuyo estado sea true
	    List<Docente> docentesNoAsignados = docentes.stream()
	            .filter(docente -> !idsDocentesAsignados.contains(docente.getId())) // No asignados a materias activas
	            .filter(Docente::isEstado) // Estado del docente sea true
	            .collect(Collectors.toList());
		LOGGER.info("Cantidad de docentes sin asignar en el listado: "+docentesNoAsignados.size()+".");
		return docenteMapper.toDocenteDTOList(docentesNoAsignados);
	}

	@Override
	public void agregarDocente(DocenteDTO docenteDTO) {

		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(true);

		docenteRepository.save(docente);
		LOGGER.info("Docente guardado correctamente.");
	}

	@Override
	public DocenteDTO buscarDocente(Long id) {
		LOGGER.info("Buscando docente.");
		return docenteMapper.toDocenteDTO(docenteRepository.findById(id).get());

	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTO) {

		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(true);
		docenteRepository.save(docente);
		LOGGER.info("Docente editado correctamente.");
	}

	@Override
	public void eliminarDocente(DocenteDTO docenteDTO) {

		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(false);
		docenteRepository.save(docente);
		LOGGER.info("Docente eliminado correctamente.");
	}
}
