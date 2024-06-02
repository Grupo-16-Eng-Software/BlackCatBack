package controller;

import model.Entity.Usuario;
import model.Service.UsuarioService;

import java.util.List;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //login
    public Usuario login(String nome, String senha) {
        return usuarioService.login(nome, senha);
    }

    //listar usuario
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    //deletar usuario
    public void deleteUserById(long id){
        usuarioService.deleteUser(id);
    }

    //criar usuario
    public  Usuario createUser(Usuario usuario){
        return usuarioService.createUser(usuario);
    }

    //editar usuario
    public void updateUser(Usuario usuario){
        usuarioService.updateUser(usuario);
    }
    public Usuario findUserById(long id) {
        return usuarioService.findUserById(id);
    }

    //conferir senha
    public Usuario findBysenha(String senha) {
        return usuarioService.findBysenha(senha);
    }

}
