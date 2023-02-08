package veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("veterinaria.*")
public class VeterinariaApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VeterinariaApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
	}

}
