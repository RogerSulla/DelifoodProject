package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Comida;
import pe.edu.upc.repository.IComidaRepository;
import pe.edu.upc.service.IComidaService;

@Service
public class ComidaServiceImpl implements Serializable, IComidaService{

    @Autowired
    private IComidaRepository dComida;

    @Override
    @Transactional
    public boolean registrar(Comida comida) {
        boolean flag = false;
        try {
            dComida.save(comida);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idComida) {
        dComida.deleteById(idComida);        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comida> listarId(int idComida) {
        return dComida.findById(idComida);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comida> listar() {
        return dComida.findAll();
    }
    
}
