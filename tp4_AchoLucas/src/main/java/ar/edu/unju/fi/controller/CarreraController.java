package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.CarreraDTO;

import ar.edu.unju.fi.service.ICarreraService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping("/listado")
	public String getCarrerasList(Model model) {
		
		model.addAttribute("carreras", carreraService.findAll());
		model.addAttribute("titulo","Carreras");
		
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		
		boolean editar = false;
		model.addAttribute("carrera", carreraDTO);
		model.addAttribute("editar", editar);
		model.addAttribute("titulo","Nueva carrera");
	
		return "formulariocarrera";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@Valid @ModelAttribute("carrera") CarreraDTO carreraDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("formulariocarrera");
		}else {
			modelView = new ModelAndView("carreras");
			carreraDTO.setEstado("true");
			carreraService.save(carreraDTO);
			modelView.addObject("carreras", carreraService.findAll());
			
		}
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getEditarCarrera(Model model,@PathVariable(value="id")Long id) {
		
		boolean editar = true;
		CarreraDTO carreraEncontradaDTO = carreraService.findById(id);
		model.addAttribute("editar", editar);
		model.addAttribute("carrera", carreraEncontradaDTO);
		model.addAttribute("titulo", "Modificar Carrera");		
		
		return "formulariocarrera";
	}
	
	
	@PostMapping("/modificar")
	public String modificarCarrera(@Valid @ModelAttribute("carrera") CarreraDTO carreraDTO, BindingResult result, Model model) {
		boolean editar = true;
		if(result.hasErrors()) {
			model.addAttribute("editar", editar);
			model.addAttribute("titulo", "Modificar Carrera");	
			return "formulariocarrera";
		}else {
			carreraService.edit(carreraDTO);
			return "redirect:/carrera/listado";
		}
		
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		
		
		CarreraDTO carreraEncontradaDTO = carreraService.findById(id);
		carreraService.deleteById(carreraEncontradaDTO);
		
		return "redirect:/carrera/listado";
		
	}

}

