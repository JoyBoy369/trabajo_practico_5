package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {
	
	List<MateriaDTO> findAll();
	
	MateriaDTO findByCodigo(int codigo);
	
	void save(MateriaDTO materiaDTO);
	
	void deleteByCodigo(int codigo);
	
	void edit(MateriaDTO materiaDTO);

}
