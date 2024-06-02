package controller;

import model.Entity.Produtos;
import model.Service.ProdutoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoPie");
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;

    }

    //listar prodtudos
    public List<Produtos>findAll(){
        return produtoService.findAll();
    }

    //deletar usuario
    public void deleteProdrById(long id){
        produtoService.deleteProduto(id);
    }

    //criar usuario
    public Produtos createProduto(Produtos produtos){
        return produtoService.createProduto(produtos);
    }

    //editar produto
    public  void updateProduto(Produtos produto){
        produtoService.updateProduto(produto);
    }

     public Produtos findProdutoByid(Long id){
        return produtoService.findProdutoById(id);
    }

    public Produtos getProdutoById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Produtos.class, id);
        } finally {
            em.close();
        }
    }

}
