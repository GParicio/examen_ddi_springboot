package veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import veterinaria.model.Palabra;
import veterinaria.service.IPalabraService;


@Controller
public class IndexController {
	
	@Autowired
	IPalabraService service;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("wordle")
	public String busquedaInit(ModelAndView model) {
		model.addObject("palabra", new Palabra());
        model.addObject("personas", service.getAllPalabras());
		model.setViewName("wordle");
		return "index";
	}

	@PostMapping("wordle")
    public String create(@ModelAttribute Palabra palabra) {
    	service.insert(palabra);
        return "index";
    }

	@GetMapping("")
	public String mascota(ModelAndView model) {
		return "redirect:/mascota";
	}
	
	@GetMapping("/goToPersona")
	public String persona(ModelAndView model) {
		return "redirect:/persona";
	}
}