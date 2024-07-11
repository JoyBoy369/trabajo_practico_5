package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;

import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.IMateriaService;


@Controller
@RequestMapping("/registro")
public class InscripcionController {

	@Autowired
	private IMateriaService materiaService;

	@Autowired
	private AlumnoService alumnoService;
	

	
	@Autowired
	private AlumnoDTO alumnoDTO;
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	@Autowired
	private MateriaMapper materiaMapper;

	
	/*
	 * @GetMapping("/alumno") public String getFormularioPage(Model model) {
	 * 
	 * model.addAttribute("alumno", alumnoDTO);
	 * model.addAttribute("alumnoslista",alumnoService.getAllAlumnos());
	 * model.addAttribute("titulo","Elegir Alumno"); return "elegiralumno";
	 * 
	 * }
	 */

	
	@GetMapping("/alumno/{aluId}/materia/{matId}")
	public ModelAndView getRegistrarAlumno(@PathVariable(value="aluId") Long aluId, @PathVariable(value="matId") Long matId, Model model) {
	    Alumno alumnoEncontrado = alumnoMapper.toAlumno(alumnoService.getAlumnoById(aluId));
	    Materia materia = materiaMapper.toMateria(materiaService.findById(matId));
	    
	    // Validar si el alumno ya está registrado en la materia
	    if (materia.getAlumnos().contains(alumnoEncontrado)) {
	        model.addAttribute("registroExitoso", false); // No se registra porque ya está registrado
	        model.addAttribute("mensajeModal", "El alumno ya está registrado en esta materia.");
	    } else {
	    	
	        materia.getAlumnos().add(alumnoEncontrado);
	        materiaService.save(materiaMapper.toMateriaDTO(materia));
	       
	    }
	    

	    AlumnoDTO alumno = alumnoService.getAlumnoById(aluId);
	    model.addAttribute("alumno", alumno);
	    model.addAttribute("materias", alumno.getMaterias());
	    model.addAttribute("titulo", "Materias del Alumno");

	    ModelAndView modelView = new ModelAndView("materiasalumno");
	    return modelView;
	}


}
