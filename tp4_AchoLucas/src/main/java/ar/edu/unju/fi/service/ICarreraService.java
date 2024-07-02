package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;


public interface ICarreraService {

	List<CarreraDTO> findAll();
	
	CarreraDTO findById(Long id);
	
	void save(CarreraDTO carreraDTO);
	
	void deleteById(CarreraDTO carreraDTO);
	
	void edit(CarreraDTO carreraDTO);
	
}
