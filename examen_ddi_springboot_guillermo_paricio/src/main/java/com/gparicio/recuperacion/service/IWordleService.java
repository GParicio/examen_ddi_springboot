package com.gparicio.recuperacion.service;

import com.gparicio.recuperacion.model.Palabra;
import com.gparicio.recuperacion.model.Wordle;

public interface IWordleService {
    public Palabra getPalabra(String word);
    public void comprobarPalabra(Palabra palabraSeleccionada, Character[] palabra);
    public void wordle(String palabra);
    public Wordle getWordle();
    void resetWordle();
}
