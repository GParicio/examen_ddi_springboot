package veterinaria.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.repository.IPalabraRepo;

import veterinaria.model.Palabra;


@Service
public class PalabraService implements IPalabraService{
        
        @Autowired
        private IPalabraRepo repo;

        
	@Autowired
	public IPalabraService servicePalabras;
    
        @Override
        public List<Palabra> getAll() {
            return repo.getListado();
        }

        @Override
	public List<Palabra> getAllPalabras() {
		return servicePalabras.getAll();
	}
    
        @Override
        public Palabra getById(int id) {
            for (Palabra p : repo.getListado()) {
                if (p.getId() == id) {
                    return p;
                }
            }
            return null;
        }
    
        @Override
        public void insert(Palabra palabra) {
            repo.getListado().add(palabra);
        }
    
        @Override
        public void update(Palabra palabra) {
            int index = repo.getListado().indexOf(getById(palabra.getId()));
            repo.getListado().set(index, palabra);
        }
    
        @Override
        public void delete(int id) {
            int index = repo.getListado().indexOf(getById(id));
            repo.getListado().remove(index);
        }
}
