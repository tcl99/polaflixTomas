package es.unican.alumnos.tcl218.polaflix_tom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "es.unican.alumnos.tcl218.polaflix_tom.repositories")
public class PolaflixTomApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolaflixTomApplication.class, args);
		Feeder f = new Feeder();

		try {
			f.run("args");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}