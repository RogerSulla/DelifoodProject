package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Tarjeta;
import pe.edu.upc.repository.ITarjetaRepository;
import pe.edu.upc.service.ITarjetaService;

@Service
public class TarjetaServiceImpl implements Serializable, ITarjetaService{
 
    @Autowired
    private ITarjetaRepository dTarjeta;

    @Override
    @Transactional
    public boolean registrar(Tarjeta tarjeta) {
        boolean flag = false;
        try {
            dTarjeta.save(tarjeta);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idTarjeta) {
        dTarjeta.deleteById(idTarjeta);  
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tarjeta> listarId(int idTarjeta) {
        return dTarjeta.findById(idTarjeta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> listar() {
        return dTarjeta.findAll();
    }

}
