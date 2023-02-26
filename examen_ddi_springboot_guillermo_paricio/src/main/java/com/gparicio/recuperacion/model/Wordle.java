package com.gparicio.recuperacion.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Wordle {    

    private Character[] palabra;
    private int intentos;
    private List<Palabra> palabras;
    private static int longitudLetra;
    private static int maxIntentos;

    public Wordle() {
    }

    public Wordle(Character[] palabra, List<Palabra> palabras, int intentos) {
        this.palabra = palabra;
        this.intentos = intentos;
        longitudLetra = palabra.length;
        this.palabras = palabras;
        maxIntentos = intentos;
    }

    public Character[] getPalabra() {
        return palabra;
    }

    public void setPalabra(Character[] palabra) {
        this.palabra = palabra;
    }

    public List<Palabra> getPalabras() {
        return palabras;
    }

    public int getIntentos() {
        return intentos;
    }

    public void addPalabra(Palabra palabra){
        palabras.add(palabra);
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public static int getLongitudLetra() {
        return longitudLetra;
    }

    public static void setLongitudLetra(int longitudLetra) {
        Wordle.longitudLetra = longitudLetra;
    }

    public void setPalabras(List<Palabra> palabras) {
        this.palabras = palabras;
    }

    public static int getMaxIntentos() {
        return maxIntentos;
    }

    public static void setMaxIntentos(int maxIntentos) {
        Wordle.maxIntentos = maxIntentos;
    }
}
