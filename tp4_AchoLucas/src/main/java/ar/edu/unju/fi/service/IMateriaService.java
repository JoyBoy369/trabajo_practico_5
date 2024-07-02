package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {
	
	List<MateriaDTO> findAll();
	
	MateriaDTO findById(Long id);
	
	void save(MateriaDTO materiaDTO);
	
	void deleteById(MateriaDTO materiaDTO);
	
	void edit(MateriaDTO materiaDTO);

}
