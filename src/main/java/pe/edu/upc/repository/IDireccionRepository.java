package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Direccion;

@Repository
public interface IDireccionRepository extends JpaRepository<Direccion, Integer>{
    
}
