package veterinaria.repository;

import java.util.List;

import org.springframework.context.annotation.Profile;

import veterinaria.model.Persona;

public interface IPersonaRepo {
	
	List<Persona> getListado();
}
