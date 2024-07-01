package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;

@Service("docenteServiceImp")
public class DocenteServiceImp implements IDocenteService{

	List<Docente> docentes = new ArrayList<Docente>();
	@Autowired
	private DocenteMapper docenteMapper;
	
	@Override
	public void agregarDocente(Docente docente) {
		int ultimoCodigo = 0;
        for (Docente d : docentes) {
            if (d.getLegajo() > ultimoCodigo) {
                ultimoCodigo = d.getLegajo();
            }
        }
        docente.setLegajo(ultimoCodigo+1);		
		docentes.add(docente);
	}
	
	@Override 
	public List<DocenteDTO> getDocentes(){
		if(docentes.isEmpty()) {
			
			/*
			 * docentes.add(new Docente(1001, "Juan", "Pérez", "juan.perez@gmail.com",
			 * "123456789")); docentes.add(new Docente(1002, "Ana", "García",
			 * "ana.garcia@hotmail.com", "987654321")); docentes.add(new Docente(1003,
			 * "Luis", "Martínez", "luis.martinez@gmail.com", "123123123"));
			 * docentes.add(new Docente(1004, "María", "López", "maria.lopez@gmail.com",
			 * "456789123")); docentes.add(new Docente(1005, "Pedro", "Sánchez",
			 * "pedro.sanchez@gmail.com", "789456123")); docentes.add(new Docente(1006,
			 * "Laura", "Gómez", "laura.gomez@gmail.com", "321654987")); docentes.add(new
			 * Docente(1007, "Carlos", "Fernández", "carlos.fernandez@gmail.com",
			 * "654987321"));
			 */
		
		}
	List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(docentes);
	return docentesDTO;
	}
	
	@Override
	public Docente buscarDocente(int legajo) {
		Predicate<Docente> filterLegajo = l -> l.getLegajo() == legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		if (docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}
	
	@Override
	public void modificarDocente(Docente docente) {
		for(Docente d : docentes) {
			if(d.getLegajo() == docente.getLegajo()) {
				d.setNombre(docente.getNombre());
				d.setApellido(docente.getApellido());
				d.setEmail(docente.getEmail());
				d.setTelefono(docente.getTelefono());
				
			}
		}
	}
	
	@Override
	public void eliminarDocente(int legajo) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLegajo()== legajo) {
				iterator.remove();
			}
		}
	}
}
