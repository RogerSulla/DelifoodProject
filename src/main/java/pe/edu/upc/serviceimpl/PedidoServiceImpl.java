package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Pedido;
import pe.edu.upc.repository.IPedidoRepository;
import pe.edu.upc.service.IPedidoService;

@Service
public class PedidoServiceImpl implements Serializable, IPedidoService{
    
    @Autowired
    private IPedidoRepository dPedido;

    @Override
    @Transactional
    public boolean registrar(Pedido pedido) {
        boolean flag = false;
        try {
            dPedido.save(pedido);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idPedido) {
        dPedido.deleteById(idPedido);   
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> listarId(int idPedido) {
        return dPedido.findById(idPedido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listar() {
        return dPedido.findAll();
    }
}
