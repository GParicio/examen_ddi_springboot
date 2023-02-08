package veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class IndexWordleController {
    /*Quiero recibir la palabra de index.html */
    @GetMapping("/mascota")
	public ModelAndView index(ModelAndView model) {
		model.addObject("mascotas", service.getAll());
		model.setViewName("mascota/index");
		return model;
	}

    @GetMapping("/palabra")
    public ModelAndView palabra(ModelAndView model) {
        model.addObject("palabra", service.getAll());
        model.setViewName("mascota/index");
        return model;
    }
}
