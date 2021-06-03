package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Tarjeta;

public interface ITarjetaService {
    public boolean registrar(Tarjeta tarjeta);
    public void eliminar(int idTarjeta);
    public Optional<Tarjeta> listarId(int idTarjeta);
    List<Tarjeta> listar();
}
