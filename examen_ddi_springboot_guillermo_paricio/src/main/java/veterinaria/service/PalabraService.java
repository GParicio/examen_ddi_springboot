package veterinaria.service;
import java.text.Normalizer;
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
    public void test(String palabra) {
        Juego juego = repo.getListado();
        Character[] wordCheck = wordle.getWord();
        Word myWord = getWord(word);
        for (Letter letter : myWord.getLetters()) {
            letter.setColor(checkLetter(letter, wordCheck));
        }
        // Change color of the letter cell
        
        wordle.addWord(myWord);
    }
    

        @Override
	public Palabra getAllPalabras() {
		return repo.getListado();
	}
    
}
