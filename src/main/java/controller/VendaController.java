package controller;

import model.Entity.ProdutoHasVenda;
import model.Entity.Usuario;
import model.Entity.Vendas;
import model.Service.VendaService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VendaController {

    private VendaService vendaService;

    public VendaController(VendaService vendaService){
        this.vendaService = vendaService;
    }
    //listar
    public List<Vendas> findAll() {
        return vendaService.findAll();
    }

    //criar
    public  Vendas createVenda(Vendas vendas){
        return vendaService.createvenda(vendas);
    }

    //editar
    public void updateVendar(Vendas vendas){
        vendaService.updateVenda(vendas);
    }
    public Vendas findVenddById(long id) {
        return vendaService.findVendaById(id);
    }

    //deletar
    public void deleteVendaById(long id){
        vendaService.deletevenda(id);
    }


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPie");

    public void saveVenda(Vendas venda) {
        EntityManager em = emf.createEntityManager();
       /* try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } finally {
            em.close();
        }*/
        vendaService.saveVenda(venda);
    }

    public void saveProdutoHasVenda(ProdutoHasVenda produtoHasVenda) {
        vendaService.saveProdutoHasVenda(produtoHasVenda);
    }



}
