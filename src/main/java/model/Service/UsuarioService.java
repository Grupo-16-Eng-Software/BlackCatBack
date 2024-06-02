package model.Service;

import model.Entity.Usuario;
import model.Repository.UsuarioRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioService {
    private EntityManager em;
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.em = Persistence.createEntityManagerFactory("BancoPie").createEntityManager();
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario createUser(Usuario usuario){
        return (Usuario) usuarioRepository.create(usuario);
    }

    //deletar usuario
    public  void deleteUser(long id){
        usuarioRepository.delete(id);
    }

    //login
    public  Usuario login(String nome, String senha){
        Usuario user = usuarioRepository.login(nome, senha);
        if(user !=null){
            System.out.println("Login bem-sucedido para o usuario:" + nome);
        }else {
            System.out.println("falha ao realizar login");
        }

        return user;
    }
    //listar usuario
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    //editar usuario
    public  void updateUser(Usuario usuario){
        usuarioRepository.update(usuario);
    }
    //buscar por id
    public Usuario findUserById(long id) {
        return (Usuario) usuarioRepository.findById(id);
    }

    //conferir senha
    public Usuario findBysenha(String senha) {
        return usuarioRepository.findBysenha(senha);
    }

}
