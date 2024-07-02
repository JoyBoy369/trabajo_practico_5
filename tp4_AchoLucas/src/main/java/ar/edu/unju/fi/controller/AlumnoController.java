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

import ar.edu.unju.fi.dto.AlumnoDTO;

import ar.edu.unju.fi.service.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

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
        model.addAttribute("editar", editar);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "formularioalumno";
    }
    
    @PostMapping("/guardar")
    public ModelAndView guardarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO) {
    	
        ModelAndView modelView = new ModelAndView("redirect:/alumno/listado");
        alumnoService.saveAlumno(alumnoDTO);
        
        return modelView;
    }
    
    @GetMapping("/modificar/{id}")
    public String getEditarAlumno(Model model, @PathVariable(value = "id") Long id) {
        boolean editar = true;
        AlumnoDTO alumnoEncontradoDTO = alumnoService.getAlumnoById(id);
        model.addAttribute("editar", editar);
        model.addAttribute("alumno", alumnoEncontradoDTO);
        model.addAttribute("titulo", "Modificar Alumno");
        return "formularioalumno";
    }
    
    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO) {
    	
        alumnoService.updateAlumno(alumnoDTO);
        
        return "redirect:/alumno/listado";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable(value = "id") Long id) {
    		
    	AlumnoDTO alumnoEncontradoDTO = alumnoService.getAlumnoById(id);    	
        alumnoService.deleteAlumno(alumnoEncontradoDTO);
        
        return "redirect:/alumno/listado";
    }
}