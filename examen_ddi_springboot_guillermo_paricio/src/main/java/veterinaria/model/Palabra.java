package veterinaria.model;

public class Palabra {
    /*Quiero hacer un wordle */
    private String palabra;
    private int numero;

    public Palabra(String palabra, int numero) {
        this.palabra = palabra;
        this.numero = numero;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Palabra [numero=" + numero + ", palabra=" + palabra + "]";
    }
}
