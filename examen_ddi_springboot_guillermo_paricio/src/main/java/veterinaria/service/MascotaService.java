package veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veterinaria.model.Mascota;
import veterinaria.model.Persona;
import veterinaria.repository.IMascotaRepo;
import veterinaria.repository.IPersonaRepo;

@Service
public class MascotaService implements IMascotaService{
	
	@Autowired
	private IMascotaRepo repo;
	
	@Autowired
	public IPersonaService servicePersonas;


	@Override
	public List<Mascota> getAll() {
		return repo.getListado();
	}
	
	@Override
	public List<Persona> getAllPersonas() {
		return servicePersonas.getAll();
	}

	@Override
	public List<Mascota> getByAmo(int amo) {
		List<Mascota> listaAux = new ArrayList<Mascota>();
		for (Mascota m : repo.getListado()) {
			if (m.getAmo() == amo) {
				listaAux.add(m);
			}
		}
		return listaAux;
	}

	@Override
	public Mascota getById(int id) {
		for (Mascota m : repo.getListado()) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	@Override
	public void insert(Mascota mascota) {
		repo.getListado().add(mascota);
		servicePersonas.getById(mascota.getAmo()).getMascotas().add(mascota);
	}

	@Override
	public void update(Mascota mascota) {
		int index = repo.getListado().indexOf(getById(mascota.getId()));
		repo.getListado().set(index, mascota);
		for(int i = 0; i < servicePersonas.getAll().size(); i++) {
			for(int j = 0; j < servicePersonas.getAll().get(i).getMascotas().size(); j++) {
				if(servicePersonas.getAll().get(i).getMascotas().get(j).getId() == mascota.getId()) {
					servicePersonas.getAll().get(i).getMascotas().remove(j);
				}
			}
		}
		servicePersonas.getById(mascota.getAmo()).getMascotas().add(mascota);
	}

	@Override
	public void delete(int id) {
		int index = repo.getListado().indexOf(getById(id));
		for (Persona p : servicePersonas.getAll()) {
			for (Mascota m : p.getMascotas()) {
				if (m.getId() == id) {
					p.getMascotas().remove(m);
					break;
				}
			}
		}
		repo.getListado().remove(index);
	}
	

}
