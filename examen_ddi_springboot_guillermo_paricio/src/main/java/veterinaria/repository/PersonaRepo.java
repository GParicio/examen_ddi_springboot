package veterinaria.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import veterinaria.model.Mascota;
import veterinaria.model.Persona;


@Profile("!especial")
@Repository
public class PersonaRepo implements IPersonaRepo{
	
	static List<Persona> listado = new ArrayList<Persona>();
	
	static {
		
		ArrayList<Mascota> initialValues = new ArrayList<Mascota>();
		initialValues.add(new Mascota(1, 1212, "Tobi", true, 1));
		initialValues.add(new Mascota(2, 1214, "Rayo", false, 1 ));
		
		listado.add(new Persona(1, "12345678A", "Pepe", initialValues));
		listado.add(new Persona(2, "87654321M", "Manolo", new ArrayList<Mascota>()));
	}
	
	@Override
	public List<Persona> getListado() {
		return listado;
	}
	
}
