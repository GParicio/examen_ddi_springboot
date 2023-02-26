package com.gparicio.recuperacion.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import com.gparicio.recuperacion.model.Palabra;
import com.gparicio.recuperacion.model.Wordle;

@Profile("difícil")
@Repository
public class NivelDifícilRepositorio implements INivelRepositorio{
    static Character[] palabra = {'T','R','O','M','P','E','T','A'};
    static int intentos = 6;
    static List<Palabra> palabras = new ArrayList<Palabra>();

    private static Wordle wordle = new Wordle(palabra,palabras,intentos);
    
    
    @Override
    public void reset() {
        wordle = new Wordle(palabra,palabras,intentos);
    }

    @Override
    public Wordle getWordle(){
        return wordle;
    }

}
