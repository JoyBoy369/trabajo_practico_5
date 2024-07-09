package ar.edu.unju.fi;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;

@SpringBootTest
class MateriaTest {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	DocenteRepository docenteRepository;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@Test
	void crearCarreraTest() {
		/*
		 * Carrera carrera = new Carrera(10, "El mati carrera", 10, true); Carrera
		 * carreraGuardada = carreraRepository.save(carrera); assertTrue(carreraGuardada
		 * instanceof Carrera);
		 * 
		 * Docente docente = new Docente(10, "Perez", "God", "Perez@gmail.com",
		 * "123456", true); Docente docenteGuardado = docenteRepository.save(docente);
		 * assertTrue(docenteGuardado instanceof Docente);
		 * 
		 * Materia materia = new Materia(10, "PE", "1ro", 100, "Presencial", true, new
		 * ArrayList<Alumno>(), docenteGuardado, carreraGuardada); //Alumno alumno1 =
		 * alumnoRepository.findById(1L).get(); //materia.getAlumnos().add(alumno1);
		 * Materia materiaGuardada = materiaRepository.save(materia);
		 * assertTrue(materiaGuardada instanceof Materia);
		 * 
		 * Alumno alumno = new Alumno("123", "El mati", "Izi", "correo", "321",
		 * LocalDate.now(), "calle", "LU1", true, new ArrayList<Materia>()); Alumno
		 * alumnoGuardado = alumnoRepository.save(alumno); assertTrue(alumnoGuardado
		 * instanceof Alumno);
		 */
		
	}

}
