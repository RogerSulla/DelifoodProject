package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Factura;
import pe.edu.upc.repository.IFacturaRepository;
import pe.edu.upc.service.IFacturaService;

@Service
public class FacturaServiceImpl implements Serializable, IFacturaService{
    @Autowired
    private IFacturaRepository dFactura;

    @Override
    @Transactional
    public boolean registrar(Factura factura) {
        boolean flag = false;
        try {
            dFactura.save(factura);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idFactura) {
        dFactura.deleteById(idFactura);  
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> listarId(int idFactura) {
        return dFactura.findById(idFactura);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> listar() {
        return dFactura.findAll();
    }
}
