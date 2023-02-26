package com.gparicio.recuperacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gparicio.recuperacion.model.*;
import com.gparicio.recuperacion.repository.INivelRepositorio;

@Service
public class WordleService implements IWordleService{
    
    @Autowired
    private INivelRepositorio nivelRepositorio;

    @Override
    public Palabra getPalabra(String palabra){
        Palabra palabraFinal = new Palabra();
        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            Letra letra = new Letra();
            letra.setCaracter(Character.toUpperCase(letras[i]));
            letra.setPosicion(-1);
            palabraFinal.getLetras().add(letra);
        }
        return palabraFinal;
    }

    @Override
    public void comprobarPalabra(Palabra palabraSeleccionada, Character[] palabra) {
        List<Letra> letras = palabraSeleccionada.getLetras();
        
        for (int i = 0; i < letras.size(); i++) {
            if (letras.get(i).getCaracter() == palabra[i]) {
                letras.get(i).setColor("bg-success");
                letras.get(i).setPosicion(i);
            }
        }
        for (int i = 0; i < letras.size(); i++) {
            for (int j = 0; j < palabra.length; j++) {
                if (letras.get(i).getCaracter() == palabra[j] && letras.get(j).getColor() != "bg-success" && letras.get(i).getColor() != "bg-success") {
                            boolean isRepeated = false;
                            for (int k = 0; k < letras.size(); k++) {
                                if (letras.get(k).getPosicion() == j) {
                                    isRepeated = true;
                                }
                            }
                            if (!isRepeated) {
                                letras.get(i).setColor("bg-warning");
                                letras.get(i).setPosicion(j);
                            }
                }
            }
            if (letras.get(i).getColor() == null) {
                letras.get(i).setColor("bg-danger");
            }
        }
    }

    @Override
    public void wordle(String palabra) {
        Wordle wordle = nivelRepositorio.getWordle();
        Character[] comprobarPalabra = wordle.getPalabra();
        Palabra palabraSeleccionada = getPalabra(palabra);
        comprobarPalabra(palabraSeleccionada, comprobarPalabra);
        // Change color of the letter cell
        wordle.addPalabra(palabraSeleccionada);
    }

    @Override
    public Wordle getWordle(){
        return nivelRepositorio.getWordle();
    }

    @Override
    public void resetWordle() {
        Wordle wordle = nivelRepositorio.getWordle();
        wordle.getPalabras().clear();
    }
}