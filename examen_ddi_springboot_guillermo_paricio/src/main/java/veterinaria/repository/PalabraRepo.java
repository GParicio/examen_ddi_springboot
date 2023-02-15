package veterinaria.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import veterinaria.model.Palabra;


@Profile("!especial")
@Repository
public class PalabraRepo implements IPalabraRepo{
	
	private static Palabra listado = new Palabra();
	
	@Override
    public void reset() {
        listado = new Palabra();
    }

	@Override
	public Palabra getListado() {
		return listado;
	}
	
}
