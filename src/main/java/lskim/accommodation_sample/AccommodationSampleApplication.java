package lskim.accommodation_sample;

import lskim.accommodation_sample.jwt.util.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
class AccommodationSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccommodationSampleApplication.class, args);
	}
}

