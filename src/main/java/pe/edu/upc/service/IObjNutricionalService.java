package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.ObjetivoNutricional;

public interface IObjNutricionalService {
    public boolean registrar(ObjetivoNutricional objNutricional);
    public void eliminar(int idObjNutricional);
    public Optional<ObjetivoNutricional> listarId(int idObjNutricional);
    List<ObjetivoNutricional> listar();
}
