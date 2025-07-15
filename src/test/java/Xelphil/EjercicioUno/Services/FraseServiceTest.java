package Xelphil.EjercicioUno.Services;

import Xelphil.EjercicioUno.Entity.Frase;
import Xelphil.EjercicioUno.Repository.FraseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FraseServiceTest {
    @InjectMocks
    private FraseService fraseService;

    @Mock
    private FraseRepository fraseRepository;

    @Test
    public void testleerFrases(){
        //Datos de ejemplo
        List<Frase> frases = new ArrayList<>();
        frases.add(new Frase());
        frases.add(new Frase());

        when(fraseRepository.findAll()).thenReturn(frases);

        //Realizamos la prueba
        List<Frase> resultado = fraseService.leerFrase();

        //Verificamos los datos obtenidos
        assertEquals(2,resultado.size());
    }

    @Test
    public void testactualizarFrase(){
        Long id = 1L;
        Frase fraseActualizado = new Frase();
        fraseActualizado.setNombre("nuevoNombre");

        Frase fraseExistente = new Frase();
        fraseExistente.setId(id);

        //Mock para fingir que cuando se llama al metodo hace lo que queremos
        when(fraseRepository.findById(id)).thenReturn(java.util.Optional.of(fraseExistente));

        //realizamos la prueba
        Frase resultado = fraseService.actualizarFrase(fraseActualizado, id);

        //verificamos los datos obtenidos
        assertEquals("nuevoNombre", resultado.getNombre());
    }

    @Test
    public void testEliminarFrase() {
        Long id = 1L;
        Frase fraseExistente = new Frase();
        fraseExistente.setId(id);

        when(fraseRepository.findById(id)).thenReturn(java.util.Optional.of(fraseExistente));

        Frase resultado = fraseService.eliminarFrase(id);

        // Verifica que se elimine la frase correctamente
        verify(fraseRepository, times(1)).deleteById(id);

        // Verifica que el resultado sea la misma frase que se eliminó
        assertEquals(id, resultado.getId());
    }

    @Test
    public void testguardarFrase(){
        Frase fraseNueva = new Frase();
        fraseNueva.setNombre("nuevoNombre");

        when(fraseRepository.save(fraseNueva)).thenReturn(fraseNueva);

        //realizamos la prueba
        Frase resultado = fraseService.guardarFrase(fraseNueva);

        verify(fraseRepository, times(1)).save(fraseNueva);

        //verificamos los datos obtenidos
        assertEquals("nuevoNombre", resultado.getNombre());
    }

    @Test
    public void testfraseMayor() {
        int cantidad = 10;

        List<Frase> frases = new ArrayList<>();

        Frase f1 = new Frase();
        f1.setNombre("nuevoNombre");
        f1.setCantidad(30);

        Frase f2 = new Frase();
        f2.setNombre("nuevoNombre2");
        f2.setCantidad(3);

        frases.add(f1);
        frases.add(f2);

        when(fraseRepository.findByFraseMayor(cantidad)).thenReturn(List.of(f1));

        List<Frase> resultado = fraseService.fraseMayor(cantidad);

        verify(fraseRepository).findByFraseMayor(cantidad);
        assertEquals(1, resultado.size());
        assertEquals(f1, resultado.get(0));
    }
}