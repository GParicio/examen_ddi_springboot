package veterinaria.repository;

import java.util.List;

import org.springframework.context.annotation.Profile;

import veterinaria.model.Palabra;

public interface IPalabraRepo {
	
	void reset();

	Palabra getListado();
}
