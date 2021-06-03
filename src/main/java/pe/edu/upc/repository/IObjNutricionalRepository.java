package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.ObjetivoNutricional;

@Repository
public interface IObjNutricionalRepository extends JpaRepository<ObjetivoNutricional, Integer>{
    
}
