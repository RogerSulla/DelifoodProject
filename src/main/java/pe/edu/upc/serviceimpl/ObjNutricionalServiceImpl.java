package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.ObjetivoNutricional;
import pe.edu.upc.repository.IObjNutricionalRepository;
import pe.edu.upc.service.IObjNutricionalService;

@Service
public class ObjNutricionalServiceImpl implements Serializable, IObjNutricionalService{
    @Autowired
    private IObjNutricionalRepository dObjNutricional;

    @Override
    @Transactional
    public boolean registrar(ObjetivoNutricional objNutricional) {
        boolean flag = false;
        try {
            dObjNutricional.save(objNutricional);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idObjNutricional) {
        dObjNutricional.deleteById(idObjNutricional); 
        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ObjetivoNutricional> listarId(int idObjNutricional) {
        return dObjNutricional.findById(idObjNutricional);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ObjetivoNutricional> listar() {
        return dObjNutricional.findAll();
    }
}
