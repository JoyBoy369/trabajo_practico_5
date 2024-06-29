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

import ar.edu.unju.fi.service.imp.DocenteServiceImp;

import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	private DocenteServiceImp docenteServiceImp;
	
	@GetMapping("/listado")
	public String getDocentesList(Model model) {
		
		model.addAttribute("docentes", docenteServiceImp.getDocentes());
		model.addAttribute("titulo","Docentes");
		
		return "docentes";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		
		boolean editar = false;
		Docente docente = new Docente();
		model.addAttribute("docente",docente);
		model.addAttribute("editar",editar);
		model.addAttribute("titulo","Nuevo docente");
	
		return "formulariodocente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
		
		ModelAndView modelView = new ModelAndView("docentes");
		docenteServiceImp.agregarDocente(docente);
		modelView.addObject("docentes",docenteServiceImp.getDocentes());
		
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getEditarDocente(Model model,@PathVariable(value="legajo")int legajo) {
		
		boolean editar = true;
		Docente docenteEncontrado = new Docente();
		docenteEncontrado = docenteServiceImp.buscarDocente(legajo);
		model.addAttribute("editar", editar);
		model.addAttribute("docente", docenteEncontrado);
		model.addAttribute("titulo", "Modificar Docente");		
		
		return "formulariodocente";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente) {
		
		docenteServiceImp.modificarDocente(docente);
		
		return "redirect:/docente/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") int legajo) {
		
		docenteServiceImp.eliminarDocente(legajo);
		
		return "redirect:/docente/listado";
		
	}
}
