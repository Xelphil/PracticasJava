package Xelphil.EjercicioUno.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FraseController {
    @Value("${frase.woe}")
    private String fraseWoe;

    @GetMapping("/frase")
    public ResponseEntity<String> miFrase(){
        return ResponseEntity.ok(fraseWoe);
    }
}
