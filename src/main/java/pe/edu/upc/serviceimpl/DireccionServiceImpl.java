package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Direccion;
import pe.edu.upc.repository.IDireccionRepository;
import pe.edu.upc.service.IDireccionService;

@Service
public class DireccionServiceImpl implements Serializable, IDireccionService{
    @Autowired
    private IDireccionRepository dDireccion;

    @Override
    @Transactional
    public boolean registrar(Direccion direccion) {
        boolean flag = false;
        try {
            dDireccion.save(direccion);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idDireccion) {
        dDireccion.deleteById(idDireccion);  
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Direccion> listarId(int idDireccion) {
        return dDireccion.findById(idDireccion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Direccion> listar() {
        return dDireccion.findAll();
    }
}
