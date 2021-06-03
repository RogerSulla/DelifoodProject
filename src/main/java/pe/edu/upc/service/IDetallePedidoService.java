package pe.edu.upc.service;

import java.util.Optional;

import pe.edu.upc.model.DetallePedido;

public interface IDetallePedidoService {
    public boolean registrar(DetallePedido detallePedido);
    public void eliminar(int idDetallePedido);
    public Optional<DetallePedido> listarId(int idDetallePedido);
}
