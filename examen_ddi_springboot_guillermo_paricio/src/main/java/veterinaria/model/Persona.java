package veterinaria.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Persona {
	
	private int id;
	
	private String dni;
	
	private String nombre;
	
	private ArrayList<Mascota> mascotas;
	
}
