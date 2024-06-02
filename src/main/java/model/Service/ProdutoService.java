package model.Service;

import model.Entity.Produtos;
import model.Repository.ProdutoRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoService {
    private EntityManager em;

    private ProdutoRepository produtoRepository;

    public  ProdutoService( ProdutoRepository produtoRepository){
        this.em = Persistence.createEntityManagerFactory("BancoPie").createEntityManager();
        this.produtoRepository = produtoRepository;
    }

    public List<Produtos>findAll(){
        return  produtoRepository.findAll();
    }
    //deletar usuario
    public  void deleteProduto(long id){
        produtoRepository.delete(id);
    }

    //criar produto
    public Produtos createProduto(Produtos produtos){
        return  (Produtos)  produtoRepository.create(produtos);
    }

    //editar produto
    public void updateProduto(Produtos produto) {
        produtoRepository.update(produto);
    }

    public Produtos findProdutoById(Long id){
        return (Produtos) produtoRepository.findById(id);
    }




}
