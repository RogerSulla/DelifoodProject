package pe.edu.upc.service;

import java.util.Optional;

import pe.edu.upc.model.Usuario;

public interface IUsuarioService {
    public boolean registrar(Usuario usuario);
    public void eliminar(int idUsuario);
    public Optional<Usuario> listarId(int idUsuario);
}
