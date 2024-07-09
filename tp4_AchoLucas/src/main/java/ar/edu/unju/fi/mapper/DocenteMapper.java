package ar.edu.unju.fi.mapper;

import org.mapstruct.Mapper;


import java.util.List;

import org.mapstruct.InheritInverseConfiguration;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocenteMapper {

	
	DocenteDTO toDocenteDTO(Docente docente);
	
	@InheritInverseConfiguration
	Docente toDocente(DocenteDTO docente);
	
	List<DocenteDTO> toDocenteDTOList(List<Docente> docentes);
	
	List<Docente> toDocenteList(List<DocenteDTO>docente);
}