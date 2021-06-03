package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.DetallePedido;

@Repository
public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{
    
}
