package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Integer>{
    
}
