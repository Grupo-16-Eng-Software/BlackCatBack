package model.Entity;

import javax.persistence.*;

@Entity
@Table(name ="produto_has_venda")
public class ProdutoHasVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int quantidade;
    @Column
    private float subtotal;

    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produtos produtos;

    @ManyToOne
    @JoinColumn(name = "id_venda_fk")
    private Vendas venda;

    public ProdutoHasVenda() {

    }

    public ProdutoHasVenda(int quantidade, float subtotal, Produtos produtos, Vendas vendas) {
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.produtos = produtos;
        this.venda = vendas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Vendas getVendas() {
        return venda;
    }

    public void setVendas(Vendas vendas) {
        this.venda = vendas;
    }
}
