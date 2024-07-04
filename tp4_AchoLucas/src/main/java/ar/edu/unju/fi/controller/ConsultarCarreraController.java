package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;

@Controller
@RequestMapping("/materiaConsultar")
public class ConsultarCarreraController {
    
    @Autowired
    private CarreraDTO carreraDTO;
    
    @Autowired
    private ICarreraService carreraService;
    
    @GetMapping("/listado")
    public String getCarrerasList(Model model) {
        model.addAttribute("carreras", carreraService.findAll());
        model.addAttribute("titulo", "Carreras");
        return "ConsultaAlumno";
    }
    
    @GetMapping("/nuevo")
    public String getNuevaCarreraPage(Model model) {
        boolean editar = false;
        model.addAttribute("carrera", carreraDTO);
        model.addAttribute("editar", editar);
        model.addAttribute("titulo", "Nueva Carrera");
        return "formularioCarrera";
    }
    
    @GetMapping("/consultar/{id}")
    public String getConsultarAlumnosPage(@PathVariable("id") Long id, Model model) {
        // Aquí se añadiría la lógica para obtener los alumnos de la carrera con el id proporcionado.
        // model.addAttribute("alumnos", alumnoService.findByCarreraId(id));
        model.addAttribute("carreraId", id);
        model.addAttribute("titulo", "Listado de Alumnos");
        return "ListadoAlumno";
    }
}