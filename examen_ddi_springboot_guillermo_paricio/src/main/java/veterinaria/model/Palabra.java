package veterinaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class    Palabra {
    /*Quiero hacer un wordle */
    @Getter @Setter
    private String palabra;

    @Getter @Setter
    private int numero;

    @Getter @Setter
    private int id;

    public Palabra(String palabra, int numero) {
        this.palabra = palabra;
        this.numero = numero;
    }
    

    @Override
    public String toString() {
        return "Palabra [numero=" + numero + ", palabra=" + palabra + "]";
    }

}
