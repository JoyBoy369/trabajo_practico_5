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

import ar.edu.unju.fi.dto.AlumnoDTO;

import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IMateriaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private IMateriaService materiaService;
	
    @Autowired
    private AlumnoService alumnoService;
    
    @Autowired
    private ICarreraService carreraService;

    @Autowired
    private AlumnoDTO alumnoDTO;
    
    @GetMapping("/listado")
    public String getAlumnosList(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllAlumnos());
        model.addAttribute("titulo", "Alumnos");
        return "alumnos";
    }
    
    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        boolean editar = false;
        model.addAttribute("alumno", alumnoDTO);
        model.addAttribute("carreras",carreraService.findAll());
        model.addAttribute("editar", editar);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "formularioalumno";
    }
    
    @PostMapping("/guardar")
    public ModelAndView guardarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result, Model model) {
        ModelAndView modelView;
        boolean editar = false;
        if (result.hasErrors()) {
        	modelView = new ModelAndView("formularioalumno");
        	model.addAttribute("carreras",carreraService.findAll());
            model.addAttribute("titulo", "Nuevo Alumno");
            model.addAttribute("editar", editar);
        }else {
        	modelView = new ModelAndView("redirect:/alumno/listado");
        	alumnoService.saveAlumno(alumnoDTO);
        }
        return modelView;
    }
    
    @GetMapping("/modificar/{id}")
    public String getEditarAlumno(Model model, @PathVariable(value = "id") Long id) {
        boolean editar = true;
        AlumnoDTO alumnoEncontradoDTO = alumnoService.getAlumnoById(id);
        model.addAttribute("editar", editar);
        model.addAttribute("alumno", alumnoEncontradoDTO);
        model.addAttribute("carreras",carreraService.findAll());
        model.addAttribute("titulo", "Modificar Alumno");
        return "formularioalumno";
    }
    
    @PostMapping("/modificar")
    public String modificarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result, Model model) {
    	boolean editar = true;
    	if(result.hasErrors()) {
    		model.addAttribute("editar", editar);
            model.addAttribute("titulo", "Modificar Alumno");
            model.addAttribute("carreras",carreraService.findAll());
    		return "formularioalumno";
    	}else {
    		alumnoService.updateAlumno(alumnoDTO);
    		return "redirect:/alumno/listado";
    	} 
        
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable(value = "id") Long id) {
    		
    	AlumnoDTO alumnoEncontradoDTO = alumnoService.getAlumnoById(id);    	
        alumnoService.deleteAlumno(alumnoEncontradoDTO);
        
        return "redirect:/alumno/listado";
    }
    
	@GetMapping("/asignar/{id}")
	public String getMateriaPage(Model model,@PathVariable(value="id")Long id) {
		
		AlumnoDTO alumnoElegidoDTO = alumnoService.getAlumnoById(id);
		
		model.addAttribute("alumno",alumnoElegidoDTO);
		model.addAttribute("materias",materiaService.filtrarMaterias(alumnoElegidoDTO.getCarrera().getId())); //recupera el id de la carrera del alumno //);
		model.addAttribute("titulo", "Elegir Materia");		
		return "inscripcionmateria";
	}
	
	@GetMapping("/{id}/materias")
	public String getMateriasPage(Model model, @PathVariable(value="id") Long id) {
		AlumnoDTO alumno = alumnoService.getAlumnoById(id);
		model.addAttribute("alumno",alumno);
		model.addAttribute("materias", alumno.getMaterias());
		model.addAttribute("titulo", "Materias del Alumno");
		return "materiasalumno";
	}
}
