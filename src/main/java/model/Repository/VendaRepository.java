package model.Repository;

import model.Entity.ProdutoHasVenda;
import model.Entity.Produtos;
import model.Entity.Vendas;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VendaRepository implements BasicCrud{

    private EntityManager em;
    private VendaRepository vendaRepository;

    public VendaRepository(EntityManager em){
        this.em = em;
        this.vendaRepository = vendaRepository;
    }

    @Override
    public Object create(Object object) {
        Vendas vendas = (Vendas) object;

        em.getTransaction().begin();
        em.persist(vendas);
        em.getTransaction().commit();
        return findById(vendas.getId());
    }

    @Override
    public Object update(Object object) {
        Vendas vendas = (Vendas) object;

        em.getTransaction().begin();
        em.persist(vendas);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var vendas =(Vendas)findById(id);
        em.remove(vendas);
        em.getTransaction().commit();
        System.out.println("Venda com ID " + id + " deletado.");

    }

    @Override
    public Object findById(Object id) {
        try {
            Vendas vendaInbBd = em.find(Vendas.class,id);
            return  vendaInbBd;
        } catch (Exception e) {

        }
        return null;
    }

    public List<Vendas>findALl(){
        return em.createQuery("SELECT v FROM Vendas v ",Vendas.class).getResultList();
    }

    public void save(Vendas venda) {
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public void saveProdutoHasVenda(ProdutoHasVenda produtoHasVenda) {
        em.getTransaction().begin();
        em.persist(produtoHasVenda);
        em.getTransaction().commit();
    }

}
