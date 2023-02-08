package veterinaria.service;

import java.util.List;

import veterinaria.model.Mascota;
import veterinaria.model.Persona;

public interface IMascotaService {
	
	List<Mascota> getAll();
	
	List<Persona> getAllPersonas();
	
	List<Mascota> getByAmo(int amo);

	Mascota getById(int id);
	
	void insert(Mascota mascota);
	
	void update(Mascota mascota);
	
	void delete(int id);
	
}
