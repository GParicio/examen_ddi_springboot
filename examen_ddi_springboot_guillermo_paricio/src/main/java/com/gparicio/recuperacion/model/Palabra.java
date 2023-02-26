package com.gparicio.recuperacion.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Palabra {
    private List<Letra> letras = new ArrayList<Letra>();

    public List<Letra> getLetras() {
        return letras;
    }

    public void setLetras(List<Letra> letras) {
        this.letras = letras;
    }

    public void addLetra(Letra letra) {
        this.letras.add(letra);
    }

    public void removeLetra(Letra letra) {
        this.letras.remove(letra);
    }

    public void removeLetra(int index) {
        this.letras.remove(index);
    }

    public void removeLetra(Character caracter) {
        for (Letra letra : letras) {
            if (letra.getCaracter().equals(caracter)) {
                this.letras.remove(letra);
                break;
            }
        }
    }

    public Letra getLetra(int index) {
        return this.letras.get(index);
    }

    public Letra getLetra(Character caracter) {
        for (Letra letra : letras) {
            if (letra.getCaracter().equals(caracter)) {
                return letra;
            }
        }
        return null;
    }

    public boolean containsLetra(Character caracter) {
        for (Letra letra : letras) {
            if (letra.getCaracter().equals(caracter)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLetra(Letra letra) {
        return this.letras.contains(letra);
    }

    public int size() {
        return this.letras.size();
    }

    public boolean isEmpty() {
        return this.letras.isEmpty();
    }

    public void clear() {
        this.letras.clear();
    }

    public Letra get(int index) {
        return this.letras.get(index);
    }

    public boolean contains(Letra letra) {
        return this.letras.contains(letra);
    }

    @Override
    public String toString() {
        return "Palabra{" + "letras=" + letras + '}';
    }

}
