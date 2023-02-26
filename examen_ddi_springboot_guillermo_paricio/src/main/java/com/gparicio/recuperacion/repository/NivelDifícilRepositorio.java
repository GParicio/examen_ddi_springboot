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
    static Character[] palabra = {'A','B','C','D','E','F','G','H'};
    static int intentos = 6;
    static List<Palabra> palabras = new ArrayList<Palabra>();

    private static Wordle wordle = new Wordle(null,null,0);
    
    
    @Override
    public void reset(){
        wordle = new Wordle(null, null, 0);
    }

    @Override
    public Wordle getWordle(){
        return wordle;
    }

}
