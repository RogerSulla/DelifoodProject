package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Factura;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer>{
    
}
