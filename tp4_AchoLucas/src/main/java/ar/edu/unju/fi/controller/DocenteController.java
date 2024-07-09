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

import ar.edu.unju.fi.service.imp.DocenteServiceImp;
import ar.edu.unju.fi.dto.DocenteDTO;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private DocenteDTO docenteDTO;
	
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
		model.addAttribute("docente",docenteDTO);
		model.addAttribute("editar",editar);
		model.addAttribute("titulo","Nuevo docente");
	
		return "formulariodocente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@Valid @ModelAttribute("docente") DocenteDTO docenteDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("formulariodocente");
		}else {
			modelView = new ModelAndView("docentes");
			docenteServiceImp.agregarDocente(docenteDTO);
			modelView.addObject("docentes",docenteServiceImp.getDocentes());
		}
		
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getEditarDocente(Model model,@PathVariable(value="id")Long id) {
		
		boolean editar = true;
		DocenteDTO docenteEncontradoDTO = docenteServiceImp.buscarDocente(id);
		
		model.addAttribute("editar", editar);
		model.addAttribute("docente", docenteEncontradoDTO);
		model.addAttribute("titulo", "Modificar Docente");		
		
		return "formulariodocente";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@Valid @ModelAttribute("docente") DocenteDTO docenteDTO, BindingResult result, Model model) {
		boolean editar = true;
		if(result.hasErrors()) {
			model.addAttribute("editar", editar);
			model.addAttribute("titulo", "Modificar Docente");		
			return "formulariodocente";
		}else {
			docenteServiceImp.modificarDocente(docenteDTO);
			return "redirect:/docente/listado";
		}
		}
		
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") Long id) {
		
		DocenteDTO docenteEncontradoDTO = docenteServiceImp.buscarDocente(id);
		docenteServiceImp.eliminarDocente(docenteEncontradoDTO);
		
		return "redirect:/docente/listado";
		
	}
}
