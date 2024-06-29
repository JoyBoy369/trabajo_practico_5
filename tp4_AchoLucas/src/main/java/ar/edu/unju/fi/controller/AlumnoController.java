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

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private Alumno alumno;
    
    @GetMapping("/listado")
    public String getAlumnosList(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllAlumnos());
        model.addAttribute("titulo", "Alumnos");
        return "alumnos";
    }
    
    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        boolean editar = false;
        model.addAttribute("alumno", alumno);
        model.addAttribute("editar", editar);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "formularioalumno";
    }
    
    @PostMapping("/guardar")
    public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        ModelAndView modelView = new ModelAndView("redirect:/alumno/listado");
        alumnoService.saveAlumno(alumno);
        return modelView;
    }
    
    @GetMapping("/modificar/{dni}")
    public String getEditarAlumno(Model model, @PathVariable(value = "dni") String dni) {
        boolean editar = true;
        Alumno alumnoEncontrado = alumnoService.getAlumnoByDni(dni);
        model.addAttribute("editar", editar);
        model.addAttribute("alumno", alumnoEncontrado);
        model.addAttribute("titulo", "Modificar Alumno");
        return "formularioalumno";
    }
    
    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.updateAlumno(alumno);
        return "redirect:/alumno/listado";
    }
    
    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable(value = "dni") String dni) {
        alumnoService.deleteAlumno(dni);
        return "redirect:/alumno/listado";
    }
}