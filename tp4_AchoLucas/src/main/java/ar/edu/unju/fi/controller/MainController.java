package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {
    @GetMapping("/")
    public String welcome() {
        return "bienvenida"; // Nombre de la vista de bienvenida (welcome.html, por ejemplo)
    }
	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		
		model.addAttribute("titulo","inicio");
		
		return "index";
	}

}
