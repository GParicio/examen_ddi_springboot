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
    

    @Override
    public String toString() {
        return "Palabra [numero=" + numero + ", palabra=" + palabra + "]";
    }

}
