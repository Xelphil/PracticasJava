package Xelphil.EjercicioUno.Services;

import Xelphil.EjercicioUno.Entity.Frase;
import Xelphil.EjercicioUno.Repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraseService {
    @Autowired
    FraseRepository fraseRepository;

    @Value("${frase.woe}")
    private String Frasewoe;

    public String FraseWoe() {
        return Frasewoe;
    }

    public List<Frase> leerFrase() {
        return fraseRepository.findAll();
    }

    public Frase actualizarFrase(Frase fraseActualizado, Long id) {
        Frase frase = fraseRepository.findById(String.valueOf(id)).orElse(null);
        if (frase != null) {
            frase.setNombre(fraseActualizado.getNombre());
            fraseRepository.save(frase);
        }
        return frase;
    }

    public Frase guardarFrase(Frase frase) {
        return fraseRepository.save(frase);
    }

    public Frase eliminarFrase(Long id) {
        Frase frase = fraseRepository.findById(String.valueOf(id)).orElse(null);
        if (frase != null) {
            fraseRepository.deleteById(String.valueOf(id));
        }
        return frase;
    }
}
