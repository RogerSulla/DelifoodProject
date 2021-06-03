package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Direccion;

public interface IDireccionService {
    public boolean registrar(Direccion direccion);
    public void eliminar(int idDireccion);
    public Optional<Direccion> listarId(int idDireccion);
    List<Direccion> listar();
}
