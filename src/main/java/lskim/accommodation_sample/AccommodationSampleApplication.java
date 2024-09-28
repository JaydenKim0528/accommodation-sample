package lskim.accommodation_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AccommodationSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationSampleApplication.class, args);
	}

}
