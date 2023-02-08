package veterinaria.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import veterinaria.model.Palabra;


@Profile("!especial")
@Repository
public class PalabraRepo implements IPalabraRepo{
	
	static List<Palabra> listado = new ArrayList<Palabra>();
	
	static {
		listado.add(new Palabra("perro", 1,1));   
	}

	@Override
	public List<Palabra> getListado() {
		return listado;
	}
	
}
