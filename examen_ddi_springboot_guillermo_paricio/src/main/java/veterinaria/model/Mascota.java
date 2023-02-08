package veterinaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class Mascota {
	
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private int chip;
	
	@Getter @Setter
	private String nombre;
	
	@Getter @Setter
	private boolean vacunado;
	
	@Getter @Setter
	private int amo;

}
