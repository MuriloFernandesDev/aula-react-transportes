package com.sistema.models.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	private Long      idProduto;
	private String    codProduto;
	private String    nomeProduto;
	private Entregador entregador;
    private List<Entrega> listaEntrega;

	public Produto() {

	}

	public Produto(Long idProduto, String codProduto, String nomeProduto, Entregador entregador) {
		this.idProduto = idProduto;
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.entregador = entregador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(sequenceName = "SEQUENCE_PRODUTO",initialValue = 1,
	                   allocationSize = 1, name="PRODUTO_SEQ")
	@Column(name="ID_PRODUTO")
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	@Column(name="COD_PRODUTO")
	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
  
	@Column(name="NOME_PRODUTO")
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENTREGADOR",referencedColumnName = "ID_ENTREGADOR")
	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	@OneToMany(mappedBy = "produto")
	public List<Entrega> getListaEntrega() {
		return listaEntrega;
	}

	public void setListaEntrega(List<Entrega> listaEntrega) {
		this.listaEntrega = listaEntrega;
	}

	
	

	
}
