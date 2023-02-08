package veterinaria.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import veterinaria.model.Mascota;
import veterinaria.model.Mascota;

@Repository
public class MascotaRepo implements IMascotaRepo{

	private static List<Mascota> listado = new ArrayList<Mascota>();
	
	static {
		listado.add(new Mascota(1, 1212, "Tobi", true, 1));
		listado.add(new Mascota(2, 1214, "Rayo", false, 1 ));
	}
	
	@Override
	public List<Mascota> getListado() {
		return listado;
	}
	
}
