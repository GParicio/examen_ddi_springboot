package com.gparicio.recuperacion.model;

import org.springframework.stereotype.Component;

@Component
public class Letra {
    
    private Character caracter;
    private int posicion;
    private String color;

    public Letra(Character caracter, int posicion, String color) {
        this.caracter = caracter;
        this.posicion = posicion;
        this.color = color;
    }

    public Letra() {
        
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Letra{" + "caracter=" + caracter + ", posicion=" + posicion + ", color=" + color + '}';
    }

    

}
