package veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import veterinaria.model.Mascota;
import veterinaria.model.Persona;
import veterinaria.service.IMascotaService;
import veterinaria.service.IPersonaService;

@Controller
public class MascotaController {
	
	@Autowired
	IMascotaService service;
	
	@GetMapping("/mascota")
	public ModelAndView index(ModelAndView model) {
		model.addObject("mascotas", service.getAll());
		model.setViewName("mascota/index");
		return model;
	}
	
	@GetMapping("/menuFromMascota")
	public String menu(ModelAndView model) {
		return "redirect:/";
	}
	
	@GetMapping("/mascota/update/{id}")
	public ModelAndView update(@PathVariable("id") int id, ModelAndView model) {
		model.addObject("mascota", service.getById(id));
        model.addObject("personas", service.getAllPersonas());
		model.setViewName("mascota/update");
		return model;
	}	
	@PostMapping("/mascota/update")
	public String update(@ModelAttribute Mascota mascotaUpdated) {
		service.update(mascotaUpdated);
		return "redirect:/mascota";
	}
	
	
	@GetMapping("/mascota/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id, ModelAndView model) {
		model.addObject("mascota", service.getById(id));
		model.setViewName("mascota/delete");
		return model;
	}
	@PostMapping("/mascota/delete")
	public String delete(@ModelAttribute Mascota mascota) {
		service.delete(mascota.getId());
		return "redirect:/mascota";
	}
	
    @GetMapping("/mascota/create")
    public ModelAndView create(ModelAndView model) {
        model.addObject("mascota", new Mascota());
        model.addObject("personas", service.getAllPersonas());
        model.setViewName("mascota/create");
        return model;
    }
    @PostMapping("/mascota/create")
    public String create(@ModelAttribute Mascota mascota) {
    	service.insert(mascota);
        return "redirect:/mascota";
    }
	
	
}
