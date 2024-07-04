package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.IMateriaService;

import java.util.List;

@Controller
@RequestMapping("/filtrarAlumno")
public class FiltrarAlumnoController {

	@Autowired
	private IMateriaService materiaService;

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("/formulario")
    public String getFiltrarAlumnoPage(Model model) {
        List<MateriaDTO> materias = materiaService.findAll();
        model.addAttribute("materias", materias);
        model.addAttribute("mensaje", "");
        return "Filtrar";
    }

/*
 * @PostMapping("/resultados") public String
 * filtrarAlumno(@RequestParam("materiaCodigo") int materiaCodigo, Model model)
 * {
 * 
 * MateriaDTO materia = materiaService.findById(materiaCodigo); List<AlumnoDTO>
 * alumnos = alumnoService.findByMateria(materiaCodigo);
 * 
 * String mensaje = (materia != null) ? "Alumnos de la materia: " +
 * materia.getNombre() : "Materia no encontrada";
 * 
 * model.addAttribute("materias", materiaService.findAll());
 * model.addAttribute("alumnos", alumnos); model.addAttribute("carreraId",
 * materiaCodigo); model.addAttribute("mensaje", mensaje);
 * 
 * return "Filtrar"; }
 */
}