package model.Repository;

import model.Entity.Usuario;

import javax.persistence.*;
import java.util.List;


public class UsuarioRepository  implements  BasicCrud{

    private EntityManager em;

    public UsuarioRepository(EntityManager em) {
        this.em = em;
    }

    public Usuario findBysenha(String senha) {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.senha = :senha");
        query.setParameter("senha", senha);
        List<Usuario> usuarios = query.getResultList();
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    @Override
    public Object create(Object object) {
        Usuario user = (Usuario) object;

        Query query = em.createQuery("SELECT u FROM  Usuario u where u.senha = :senha");
        query.setParameter("senha",user.getSenha());
        List<Usuario> userMesmaSenha = query.getResultList();

        if (!userMesmaSenha.isEmpty()){
            return null;
        }
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return findById(user.getId());
    }

    @Override
    public Object update(Object object) {
        Usuario user = (Usuario) object;

        // Verificar se a nova senha já está sendo usada por outro usuário
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.senha = :senha AND u.id != :userId");
        query.setParameter("senha", user.getSenha());
        query.setParameter("userId", user.getId());
        List<Usuario> usuariosComMesmaSenha = query.getResultList();

        if (!usuariosComMesmaSenha.isEmpty()) {
            System.out.println("A senha fornecida já está sendo usada por outro usuário. A senha não foi alterada.");
            return null;
        }

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var user = (Usuario) findById(id);
        em.remove(user);
        em.getTransaction().commit();
        System.out.println("Usuário com ID " + id + " deletado.");
    }

    @Override
    public Object findById(Object id) {
        try {
            Usuario usuarioInBd = em.find(Usuario.class, id);
            return usuarioInBd;
        } catch (Exception e) {

        }
        return null;
    }

    //login
    public  Usuario login(String nome, String senha){
        try{
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", Usuario.class);
            query.setParameter("nome", nome);
            query.setParameter("senha", senha);
            return query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Nenhum usuário encontrado com o nome e senha fornecidos.");
            return null;
        } catch (NonUniqueResultException e) {
            System.out.println("Mais de um usuário encontrado com o mesmo nome e senha. Isso não deveria acontecer.");
            return null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar fazer login: " + e.getMessage());
            return null;
        }
    }

    //listar usuario
    public  List<Usuario> findAll(){
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

}
