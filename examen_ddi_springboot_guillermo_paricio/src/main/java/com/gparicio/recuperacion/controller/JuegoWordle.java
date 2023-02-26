package com.gparicio.recuperacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gparicio.recuperacion.service.IWordleService;

@Controller
public class JuegoWordle {
    
    @Autowired
    IWordleService wordleService;

    @GetMapping("/")
    public ModelAndView wordle(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("wordle", wordleService.getWordle());
		modelAndView.addObject("intentosPalabra", wordleService.getWordle().getPalabras().size());
		//Si toda la palbra está en verde, el finJuego es true
		if (wordleService.getWordle().getPalabras().size() > 0) {
            if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size() > 0) {
                if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().get(wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size()-1).getColor() == "bg-success") {
                    modelAndView.addObject("finJuego", true);
                }
            }
        }
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView wordlePost(@ModelAttribute("palabra") String palabra, ModelAndView modelAndView) {
        wordleService.wordle(palabra);
        modelAndView.setViewName("index");
        modelAndView.addObject("wordle", wordleService.getWordle());
		modelAndView.addObject("intentosPalabra", wordleService.getWordle().getPalabras().size());
		// //Si toda la palbra está en verde, el finJuego es true
		// if (wordleService.getWordle().getPalabras().size() > 0) {
        //     if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size() > 0) {
        //         if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().get(wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size()-1).getColor() == "bg-success") {
        //             modelAndView.addObject("finJuego", true);
        //         }
        //     }
        // }
		// //Si toda la palabra está en rojo, el finJuego es true
		// if (wordleService.getWordle().getPalabras().size() > 0) {
		// 	if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size() > 0) {
		// 		if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().get(wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size()-1).getColor() == "bg-danger") {
		// 			modelAndView.addObject("finJuegoPerder", true);
		// 		}
		// 	}
		// }

		//Comprobar que cada letra de la palabra está en verde, si es así, el finJuego es true
		if (wordleService.getWordle().getPalabras().size() > 0) {
			if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size() > 0) {
				for (int i = 0; i < wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size(); i++) {
					if (wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().get(i).getColor() != "bg-success") {
						break;
					}
					if (i == wordleService.getWordle().getPalabras().get(wordleService.getWordle().getPalabras().size()-1).getLetras().size()-1) {
						modelAndView.addObject("finJuego", true);
					}
				}
			}
		}

		//Si el número de intentos ha superado el máximo, el finJuego es true
		if (wordleService.getWordle().getPalabras().size() > wordleService.getWordle().getIntentos()) {
			modelAndView.addObject("finJuegoPerder", true);
		}
        return modelAndView;
    }

    @GetMapping("/checkReset")
	public String checkResetGet() {
		wordleService.getWordle().getPalabras().clear();
		return "redirect:/";
	}

    @GetMapping("/busquedaIntentos")
	public ModelAndView searchTry(ModelAndView mv) {
		mv.setViewName("busquedaIntentos");
		mv.addObject("tries", wordleService.getWordle().getPalabras().size());
		if (wordleService.getWordle().getPalabras().size() > 1) {
			mv.addObject("try", 1);
			mv.addObject("busquedaIntentos", wordleService.getWordle().getPalabras().get(0).getLetras());
		}		
		return mv;
	}

	@PostMapping("/busquedaIntentos")
	public ModelAndView searchTryPost(@ModelAttribute("try") int trySearch, ModelAndView mv) {
		mv.setViewName("busquedaIntentos");
		mv.addObject("busquedaIntentos", wordleService.getWordle().getPalabras().get(trySearch - 1).getLetras());
		mv.addObject("tries", wordleService.getWordle().getPalabras().size());
		mv.addObject("try", trySearch);
		return mv;
	}

	//Obtener número de intentos usados
	@GetMapping("/intentos")
	public ModelAndView intentos(ModelAndView mv) {
		mv.setViewName("intentos");
		mv.addObject("tries", wordleService.getWordle().getPalabras().size());
		return mv;
	}
}
