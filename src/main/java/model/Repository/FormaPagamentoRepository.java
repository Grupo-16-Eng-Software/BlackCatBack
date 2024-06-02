package model.Repository;

import model.Entity.FormaPagamento;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoRepository implements BasicCrud {

    private EntityManager em;

    public FormaPagamentoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Object create(Object object) {
        FormaPagamento formaPagamento = (FormaPagamento) object;

        em.getTransaction().begin();
        em.persist(formaPagamento);
        em.getTransaction().commit();
        return findById(formaPagamento.getId());
    }

    @Override
    public Object update(Object object) {
        FormaPagamento formaPagamento = (FormaPagamento) object;

        em.getTransaction().begin();
        em.merge(formaPagamento);
        em.getTransaction().commit();
        return formaPagamento;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        FormaPagamento formaPagamento = em.find(FormaPagamento.class, id);
        em.remove(formaPagamento);
        em.getTransaction().commit();
        System.out.println("Forma de pagamento com ID " + id + " deletada.");
    }

    @Override
    public Object findById(Object id) {
        try {
            FormaPagamento formaPagamento = em.find(FormaPagamento.class, id);
            return formaPagamento;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<FormaPagamento> findAll() {
        return em.createQuery("SELECT f FROM FormaPagamento f", FormaPagamento.class).getResultList();
    }

    public FormaPagamento findById(Long id) {
        return em.find(FormaPagamento.class, id);
    }
}
