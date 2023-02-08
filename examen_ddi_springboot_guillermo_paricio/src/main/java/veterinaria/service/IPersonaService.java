package veterinaria.service;

import java.util.List;

import veterinaria.model.Persona;

public interface IPersonaService {
	
	List<Persona> getAll();

	Persona getById(int id);
	
	void insert(Persona persona);
	
	void update(Persona persona);
	
	void delete(int id);
	
	int generateId();
	
	List<Persona> search(String busqueda);

}
