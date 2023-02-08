package veterinaria.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("easy")
public class Easy implements Level {

	@Override
	public int getTries() {
		return 20;
	}

	@Override
	public int getMaxLength() {
		return 3;
	}
}
