package Xelphil.EjercicioUno.Controller;

import Xelphil.EjercicioUno.Services.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("practica")
public class PracticasController {
    @Autowired
    FraseService fraseService;

    @GetMapping("/ej1")
    public ResponseEntity<String> ejercicio1() {
        // Hago el ejercicio 1
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        lista.forEach(i -> {
            System.out.println("El número es el: "+i);
        });
        List<Integer> pares = lista.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: "+pares);
        return ResponseEntity.ok("1");
    }


    @GetMapping("/ej2")
    public ResponseEntity<String> ejercicio2() {
        // Hago el ejercicio 2
        List<String> lista = Arrays.asList("Java", "Python", "C#", "JavaScript", "C++");

        System.out.println(lista);

        List<String> mayusculas = lista.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(mayusculas);

        mayusculas.stream()
                .filter(m -> m.contains("C"))
                .forEach(System.out::println);

        return ResponseEntity.ok("2");
    }

    @GetMapping("/ej3")
    public ResponseEntity<String> ejercicio3() {
        // Hago el ejercicio 3
        List<String> lista = Arrays.asList("Java", "Python", "C#", "JavaScript", "C++");

        System.out.println(lista);

        lista.stream()
                .forEach(l -> {
                    System.out.println(l.length());
                });

        return ResponseEntity.ok("2");
    }

}
