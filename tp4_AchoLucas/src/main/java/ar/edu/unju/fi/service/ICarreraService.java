package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {

	List<CarreraDTO> findAll();
	
	CarreraDTO findByCod(int codigo);
	
	boolean save(CarreraDTO carreraDTO);
	
	void deleteByCod(int cod);
	
	void edit(CarreraDTO carreraDTO);
	
}
