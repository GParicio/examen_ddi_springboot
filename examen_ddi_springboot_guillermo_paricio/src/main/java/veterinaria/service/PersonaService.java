package veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veterinaria.repository.IMascotaRepo;
import veterinaria.repository.IPersonaRepo;
import veterinaria.model.Mascota;
import veterinaria.model.Persona;


@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private IPersonaRepo repo;
	
	@Autowired
	private IMascotaService mascotaService;

	@Override
	public List<Persona> getAll() {
		return repo.getListado();
	}

	@Override
	public Persona getById(int id) {
		for (Persona p : repo.getListado()) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insert(Persona persona) {
		persona.setId(generateId());
		persona.setMascotas(new ArrayList<Mascota>());
		repo.getListado().add(persona);
	}

	@Override
	public void update(Persona persona) {
		int index = repo.getListado().indexOf(getById(persona.getId()));
		persona.setMascotas(repo.getListado().get(index).getMascotas());
		repo.getListado().set(index, persona);
	}

	@Override
	public void delete(int id) {
		int index = repo.getListado().indexOf(getById(id));
		repo.getListado().remove(index);
		for (Mascota m : mascotaService.getByAmo(id)) {
			m.setAmo(0);
		}
	}
	
	@Override
	public int generateId() {
		int maxId=0;
		for (Persona p : repo.getListado()) {
			if (p.getId()>maxId) {
				maxId = p.getId();
			}
		}
		return maxId+1;
	}
	
	@Override
	public List<Persona> search(String busqueda) {
		if (busqueda != null) {
			List<Persona> listaFiltrada = new ArrayList<Persona>();
			for (Persona p : repo.getListado()) {
				if (p.getNombre().contains(busqueda)) {					
					listaFiltrada.add(p);
				}
			}
			return listaFiltrada;
		}
		else {
			return repo.getListado();
		}
	}

}
