package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	@Qualifier("materiaServiceImp")
	private IMateriaService materiaService;
	
	@Autowired
	private ICarreraService carreraService;
	
	@Autowired
	private IDocenteService docenteService;
	
	
	@Autowired
	private MateriaDTO materiaDTO;
	

		
	@GetMapping("/listado")
	public String getMateriasList(Model model) {
		
		model.addAttribute("materias",materiaService.findAll());
		model.addAttribute("titulo","Materias");
		
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {
		
		boolean editar = false;
		 List<DocenteDTO> docentes = docenteService.getDocentesNoAsignados();
		    if (docentes == null) {
		        docentes = new ArrayList<>(); // Inicializar con lista vacía si es null
		    }
		model.addAttribute("materia",materiaDTO);
		model.addAttribute("docentes",docenteService.getDocentesNoAsignados()); 
		model.addAttribute("carreras",carreraService.findAll());		
		model.addAttribute("editar",editar);
		model.addAttribute("titulo","Nueva materia");
	
		return "formulariomateria";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("formulariomateria");
			modelView.addObject("docentes",docenteService.getDocentesNoAsignados()); 
			modelView.addObject("carreras",carreraService.findAll());		
		}else {
			modelView = new ModelAndView("materias");
			materiaService.save(materiaDTO);
			modelView.addObject("materias",materiaService.findAll());
		}
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getEditarMateria(Model model,@PathVariable(value="id")Long id) {
		
		boolean editar = true;
		MateriaDTO materiaEncontradaDTO = materiaService.findById(id);
	
		model.addAttribute("editar", editar);
		model.addAttribute("materia", materiaEncontradaDTO);
		model.addAttribute("docentes",docenteService.getDocentesNoAsignados()); 
		model.addAttribute("carreras",carreraService.findAll());	
		model.addAttribute("titulo", "Modificar Carrera");		
		
		return "formulariomateria";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result, Model model) {
		boolean editar = true;
		if(result.hasErrors()) {
			model.addAttribute("editar", editar);
			model.addAttribute("docentes",docenteService.getDocentesNoAsignados()); 
			model.addAttribute("carreras",carreraService.findAll());
			return "formulariomateria";
		}else {
			materiaService.edit(materiaDTO);
			return "redirect:/materia/listado";
		}
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		
		MateriaDTO materiaEncontradaDTO = materiaService.findById(id);
		
		materiaService.deleteById(materiaEncontradaDTO);
		
		return "redirect:/materia/listado";
		
	}

}
