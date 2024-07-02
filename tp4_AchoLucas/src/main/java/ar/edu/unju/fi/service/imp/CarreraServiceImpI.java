package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

@Service
public class CarreraServiceImpI implements ICarreraService {

	private static final Log LOGGER = LogFactory.getLog(CarreraServiceImpI.class);
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private CarreraMapper carreraMapper;
	
	@Override
	public List<CarreraDTO> findAll() {
		
		List<CarreraDTO> carrerasDTO = carreraMapper.toCarreraDTOList(carreraRepository.findByEstado(true));
		LOGGER.info("Cantidad de carreras en el listado: "+carrerasDTO.size()+".");
		return carrerasDTO;
	}

	@Override
	public CarreraDTO findById(Long id) {
		
		LOGGER.info("Buscando carrera.");
		return carreraMapper.toCarreraDTO(carreraRepository.findById(id).get());
	}

	@Override
	public void save(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carrera.setEstado(true);
		carreraRepository.save(carrera);
		LOGGER.info("Carrera guardada correctamente.");
	}

	@Override
	public void deleteById(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carrera.setEstado(false);
		carreraRepository.save(carrera);
		LOGGER.info("Carrera eliminada correctamente.");
	}

	@Override
	public void edit(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carrera.setEstado(true);
		carreraRepository.save(carrera);
		LOGGER.info("Carrera editada correctamente.");
	}


}