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
	public ModelAndView getRegistrarAlumno(@PathVariable(value="aluId")Long aluId,@PathVariable(value="matId")Long matId, Model model) {
		
		Alumno alumnoEncontrado = alumnoMapper.toAlumno(alumnoService.getAlumnoById(aluId));
		
		Materia materia= materiaMapper.toMateria(materiaService.findById(matId));
		
		materia.getAlumnos().add(alumnoEncontrado);
		
		materiaService.save(materiaMapper.toMateriaDTO(materia));
		
		model.addAttribute("alumnos", alumnoService.getAllAlumnos());
        model.addAttribute("titulo", "Alumnos");
		
		ModelAndView modelView = new ModelAndView("alumnos");
		
		return modelView;
		
	}


}
