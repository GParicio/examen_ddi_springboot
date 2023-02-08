package veterinaria.service;

import java.util.List;

import veterinaria.model.Palabra;

public interface IPalabraService {
        
        public List<Palabra> getAll();
        public Palabra getById(int id);
        public void insert(Palabra palabra);
        public void update(Palabra palabra);
        public void delete(int id);
        List<Palabra> getAllPalabras();
}
