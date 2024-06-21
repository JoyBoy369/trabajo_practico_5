package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;




@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarrerasList(Model model) {
		
		model.addAttribute("carreras",CollectionCarrera.getCarreras());
		model.addAttribute("titulo","Carreras");
		
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		
		boolean editar = false;
		model.addAttribute("carrera",carrera);
		model.addAttribute("editar",editar);
		model.addAttribute("titulo","Nueva carrera");
	
		return "formulariocarrera";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		
		ModelAndView modelView = new ModelAndView("carreras");
		carrera.setEstado(true);
		CollectionCarrera.agregarCarrera(carrera);
		modelView.addObject("carreras",CollectionCarrera.getCarreras());
		
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getEditarCarrera(Model model,@PathVariable(value="codigo")int codigo) {
		
		boolean editar = true;
		Carrera carreraEncontrada = new Carrera();
		carreraEncontrada = CollectionCarrera.buscarCarrera(codigo);
		model.addAttribute("editar", editar);
		model.addAttribute("carrera", carreraEncontrada);
		model.addAttribute("titulo", "Modificar Carrera");		
		
		return "formulariocarrera";
	}
	
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		
		CollectionCarrera.modificarCarrera(carrera);
		
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		
		CollectionCarrera.eliminarCarrera(codigo);
		
		return "redirect:/carrera/listado";
		
	}

}
