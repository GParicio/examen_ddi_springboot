package veterinaria.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import veterinaria.model.Mascota;
import veterinaria.model.Persona;


@Profile("especial")
@Repository
public class PersonaEspecialRepo implements IPersonaRepo{
	
	static List<Persona> listado = new ArrayList<Persona>();

	
	static {
		
		listado.add(new Persona(3, "87565331M", "Peponaso", new ArrayList<Mascota>()));
		listado.add(new Persona(4, "12345678A", "Manolin", new ArrayList<Mascota>()));
	}
	
	@Override
	public List<Persona> getListado() {
		return listado;
	}
	
}
