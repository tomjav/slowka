package pl.mgrzybowski.slowka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "pl.mgrzybowski")
@EnableJpaRepositories(value = "pl.mgrzybowski")
@ComponentScan(value = "pl.mgrzybowski")
@SpringBootApplication
public class SlowkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowkaApplication.class, args);
	}
}
