package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.model.Plan;
import pe.edu.upc.repository.IPlanRepository;
import pe.edu.upc.service.IPlanService;

@Service
public class PlanServiceImpl implements Serializable, IPlanService{
    
    @Autowired
    private IPlanRepository dPlan;

    @Override
    public boolean registrar(Plan plan) {
        boolean flag = false;
        try {
            dPlan.save(plan);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    public void eliminar(int idPlan) {
        dPlan.deleteById(idPlan);  
    }

    @Override
    public Optional<Plan> listarId(int idPlan) {
        return dPlan.findById(idPlan);
    }

    @Override
    public List<Plan> listar() {
        return dPlan.findAll();
    }
}
