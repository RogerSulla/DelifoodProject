package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Plan;

public interface IPlanService {
    public boolean registrar(Plan plan);
    public void eliminar(int idPlan);
    public Optional<Plan> listarId(int idPlan);
    List<Plan> listar();
}
