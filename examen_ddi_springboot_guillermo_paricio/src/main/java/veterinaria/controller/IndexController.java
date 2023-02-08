package veterinaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("wordle")
	public ModelAndView busquedaInit(ModelAndView model) {
		model.setViewName("wordle");
		return model;
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