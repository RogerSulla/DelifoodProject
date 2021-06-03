package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Comida;

public interface IComidaService {
    public boolean registrar(Comida comida);
    public void eliminar(int idComida);
    public Optional<Comida> listarId(int idComida);
    List<Comida> listar();
}