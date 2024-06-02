package model.Repository;

import model.Entity.Produtos;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProdutoRepository implements BasicCrud{
    private EntityManager em;
    private ProdutoRepository produtoRepository;


    public ProdutoRepository(EntityManager em){
        this.em = em;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Object create(Object object) {
        Produtos produto = (Produtos) object;

        Query query = em.createQuery("SELECT p FROM  Produtos p where p.nome = :nome");
        query.setParameter("nome",produto.getNome());
        List<Produtos> msmNome = query.getResultList();

        if (!msmNome.isEmpty()){
            return null;
        }
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        return findById(produto.getId());
    }

    @Override
    public Object update(Object object) {
        Produtos produto = (Produtos) object;

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var produto =(Produtos)findById(id);
        em.remove(produto);
        em.getTransaction().commit();
        System.out.println("Produto com ID " + id + " deletado.");
    }

    @Override
    public Object findById(Object id) {
        try {
            Produtos produtoInbBd = em.find(Produtos.class,id);
            return  produtoInbBd;
        } catch (Exception e) {

        }
        return null;
    }
    //listar produtos
    public List<Produtos> findAll(){
        return em.createQuery("SELECT p FROM Produtos p ",Produtos.class).getResultList();
    }

}
