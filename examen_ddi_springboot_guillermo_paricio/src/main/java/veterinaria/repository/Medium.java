package veterinaria.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("medium")
public class Medium implements Level {

	@Override
	public int getTries() {
		return 10;
	}

	@Override
	public int getMaxLength() {
		return 5;
	}
}
