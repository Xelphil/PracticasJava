package Xelphil.EjercicioUno.Controller;

import Xelphil.EjercicioUno.Entity.Frase;
import Xelphil.EjercicioUno.Services.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FraseController {
    @Autowired
    FraseService fraseService;

    @GetMapping("/MiFrase")
    public ResponseEntity<String> MiFrase(){
        String miFrase = fraseService.FraseWoe();
        return ResponseEntity.ok(miFrase);
    }

    @GetMapping("frases")
    public ResponseEntity<List<Frase>> frases(){
        List<Frase> listaFrases = fraseService.leerFrase();
        return ResponseEntity.ok(listaFrases);
    }

    @GetMapping("/fraseMayor/{cantidad}")
    public ResponseEntity<List<Frase>> fraseMayor(@PathVariable int cantidad){
        List<Frase> listaFrases = fraseService.fraseMayor(cantidad);
        return ResponseEntity.ok(listaFrases);
    }

    @PutMapping("/actualizarFrase/{id}")
    public ResponseEntity<Frase> actualizarFrase(@RequestBody Frase frase, @PathVariable Long id){
        Frase fraseActualizado = fraseService.actualizarFrase(frase, id);
        return ResponseEntity.ok(fraseActualizado);
    }

    @PostMapping("/guardarFrase")
    public ResponseEntity<Frase> guardarFrase(@RequestBody Frase frase){
        Frase fraseGuardado = fraseService.guardarFrase(frase);
        return ResponseEntity.ok(fraseGuardado);
    }

    @DeleteMapping("/eliminarFrase/{id}")
    public ResponseEntity<Frase> eliminarFrase(@PathVariable Long id){
        Frase fraseEliminado = fraseService.eliminarFrase(id);
        return ResponseEntity.ok(fraseEliminado);
    }
}
