package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.DetallePedido;
import pe.edu.upc.repository.IDetallePedidoRepository;
import pe.edu.upc.service.IDetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements Serializable, IDetallePedidoService{

    @Autowired
    private IDetallePedidoRepository dDetallePedido;

    @Override
    @Transactional
    public boolean registrar(DetallePedido detallePedido) {
        boolean flag = false;
        try {
            dDetallePedido.save(detallePedido);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idDetallePedido) {
        dDetallePedido.deleteById(idDetallePedido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DetallePedido> listarId(int idDetallePedido) {
        return dDetallePedido.findById(idDetallePedido);
    }
    
}
