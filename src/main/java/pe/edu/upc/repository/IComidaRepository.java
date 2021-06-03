package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Comida;

@Repository
public interface IComidaRepository extends JpaRepository<Comida, Integer>{
    
}
