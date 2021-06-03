package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Pedido;

public interface IPedidoService {
    public boolean registrar(Pedido pedido);
    public void eliminar(int idPedido);
    public Optional<Pedido> listarId(int idPedido);
    List<Pedido> listar();
}
