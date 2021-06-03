package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Factura;

public interface IFacturaService {
    public boolean registrar(Factura factura);
    public void eliminar(int idFactura);
    public Optional<Factura> listarId(int idFactura);
    List<Factura> listar();
}
