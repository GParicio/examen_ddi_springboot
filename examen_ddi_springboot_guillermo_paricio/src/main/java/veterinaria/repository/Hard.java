package veterinaria.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hard")
public class Hard implements Level {

	@Override
	public int getTries() {
		return 6;
	}

	@Override
	public int getMaxLength() {
		return 8;
	}
}
