package model.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Vendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	float total;

	@Column(name = "data_venda")
	LocalDateTime dataVenda;

	@Column(name = "nfe", nullable = false, columnDefinition = "bigint default 0")
	private Long nfe;

	@ManyToOne
	@JoinColumn(name = "id_usuario_fk")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "id_forma_pagamento_fk")
	private FormaPagamento formaPagamento;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	private List<ProdutoHasVenda> itens;

	public Vendas() {
		
	}
	
	public Vendas(Usuario usuario, FormaPagamento formaPagamento,Long id, float total, LocalDateTime data, Long nfe) {
		this.usuario = usuario;
		this.formaPagamento = formaPagamento;
		this.id = id;
		this.total = total;
		this.dataVenda = data;
		this.nfe = nfe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Long getNfe() {
		return nfe;
	}

	public void setNfe(Long nfe) {
		this.nfe = nfe;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public List<ProdutoHasVenda> getItens() {
		return itens;
	}

	public void setItens(List<ProdutoHasVenda> itens) {
		this.itens = itens;
	}


}
