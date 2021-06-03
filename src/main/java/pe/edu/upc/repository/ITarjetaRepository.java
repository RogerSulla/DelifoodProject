package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Tarjeta;

@Repository
public interface ITarjetaRepository extends JpaRepository<Tarjeta, Integer>{
    
}
