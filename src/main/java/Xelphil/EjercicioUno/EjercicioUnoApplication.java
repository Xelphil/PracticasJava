package Xelphil.EjercicioUno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class EjercicioUnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioUnoApplication.class, args);
			System.out.println("Hola Taos");
	}
}