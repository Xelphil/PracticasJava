package Xelphil.EjercicioUno.Repository;

import Xelphil.EjercicioUno.Entity.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraseRepository extends JpaRepository<Frase,String> {

}
