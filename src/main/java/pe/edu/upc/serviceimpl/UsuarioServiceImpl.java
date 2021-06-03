package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Usuario;
import pe.edu.upc.repository.IUsuarioRepository;
import pe.edu.upc.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements Serializable, IUsuarioService{

    @Autowired
    private IUsuarioRepository dUsuario;
    
    @Override
    @Transactional
    public boolean registrar(Usuario usuario) {
        boolean flag = false;
        try {
            dUsuario.save(usuario);
            flag = true;
        } catch (Exception e) {
            System.out.println("Sucedió un error");
        }
        return flag;
    }

    @Override
    @Transactional
    public void eliminar(int idUsuario) {
        dUsuario.deleteById(idUsuario);        
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> listarId(int idUsuario) {
        return dUsuario.findById(idUsuario);
    }
    
}
