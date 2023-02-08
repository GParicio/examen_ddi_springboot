package veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import veterinaria.model.Persona;
import veterinaria.service.IMascotaService;
import veterinaria.service.IPersonaService;

@Controller
public class PersonaController {
	
	@Autowired
	IPersonaService service;
	
	@GetMapping("/persona")
	public ModelAndView index(ModelAndView model) {
		model.addObject("personas", service.getAll());
		model.setViewName("persona/index");
		return model;
	}
	
	@PostMapping("/persona/busqueda")
	public ModelAndView busqueda(String busqueda, ModelAndView model) {
		model.addObject("personas", service.search(busqueda));
		model.setViewName("persona/busqueda");
		return model;
	}
	
	@GetMapping("/persona/busqueda")
	public ModelAndView busquedaInit(ModelAndView model) {
		model.addObject("personas", service.search(null));
		model.setViewName("persona/busqueda");
		return model;
	}
	
	
	
	@GetMapping("/menuFromPersona")
	public String menu(ModelAndView model) {
		return "redirect:/";
	}
	
	@GetMapping("/persona/details/{id}")
	public ModelAndView details(@PathVariable("id") int id, ModelAndView model) {
		model.addObject("persona", service.getById(id));
		model.addObject("mascotas", service.getById(id).getMascotas());
		model.setViewName("persona/details");
		return model;
	}
	
	
	@GetMapping("/persona/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id, ModelAndView model) {
		model.addObject("persona", service.getById(id));
		model.setViewName("persona/delete");
		return model;
	}
	@PostMapping("/persona/delete")
	public String delete(@ModelAttribute Persona persona) {
		service.delete(persona.getId());
		return "redirect:/persona";
	}
	
	
	@GetMapping("/persona/update/{id}")
	public ModelAndView update(@PathVariable("id") int id, ModelAndView model) {
		model.addObject("persona", service.getById(id));
		model.setViewName("persona/update");
		return model;
	}	
	@PostMapping("/persona/update")
	public String update(@ModelAttribute Persona personaUpdated) {
		service.update(personaUpdated);
		return "redirect:/persona";
	}
	
	
    @GetMapping("/persona/create")
    public ModelAndView create(ModelAndView model) {
        model.addObject("persona", new Persona());
        model.setViewName("persona/create");
        return model;
    }
    @PostMapping("/persona/create")
    public String create(@ModelAttribute Persona persona) {
    	service.insert(persona);
        return "redirect:/persona";
    }
	
	
}
