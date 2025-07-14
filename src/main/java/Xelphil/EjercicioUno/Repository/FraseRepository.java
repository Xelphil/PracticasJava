package Xelphil.EjercicioUno.Repository;

import Xelphil.EjercicioUno.Entity.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraseRepository extends JpaRepository<Frase,Long> {
    @Query("SELECT f FROM Frase f WHERE f.cantidad >= :cantidad")
    List<Frase> findByFraseMayor(@Param("cantidad") int cantidad);
}
