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
	
	@GetMapping("/wordle")
	public ModelAndView busquedaInit(ModelAndView mv) {
		mv.setViewName("wordle");
		mv.addObject("palabra", new Palabra());
        mv.addObject("personas", service.getAllPalabras());
		return mv;
	}

	@PostMapping("/wordle")
    public ModelAndView create(@ModelAttribute("palabra") String palabra, ModelAndView mv) {
		mv.setViewName("wordle");
		service.insert(palabra);
		mv.addObject("wordle", service.getAllPalabras());
        return mv;
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