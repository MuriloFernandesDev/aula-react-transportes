package com.sistema.models.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ENTREGA")
public class Entrega {

	private Long       idEntrega;
	private String     codEntrega;
	private String     descricaoEntrega;
	private Produto produto;
	
	
	public Entrega() {
		
	}


	public Entrega(Long idEntrega, String codEntrega, String descricaoEntrega, Produto produto) {
		this.idEntrega = idEntrega;
		this.codEntrega = codEntrega;
		this.descricaoEntrega = descricaoEntrega;
		this.produto = produto;
	}


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTREGA_SEQ")
	@SequenceGenerator(sequenceName = "SEQUENCE_ENTREGA",initialValue = 1,allocationSize = 1, name="ENTREGA_SEQ")
    @Column(name = "ID_ENTREGA")
	public Long getIdEntrega() {
		return idEntrega;
	}



	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}


	@Column(name="COD_ENTREGA")
	public String getCodEntrega() {
		return codEntrega;
	}



	public void setCodEntrega(String codEntrega) {
		this.codEntrega = codEntrega;
	}


	@Column(name="DESCRICAO")
	public String getDescricaoEntrega() {
		return descricaoEntrega;
	}



	public void setDescricaoEntrega(String descricaoEntrega) {
		this.descricaoEntrega = descricaoEntrega;
	}


    @ManyToOne
    @JoinColumn(name="ID_PRODUTO")
	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
