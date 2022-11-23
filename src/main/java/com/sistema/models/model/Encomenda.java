package com.sistema.models.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENCOMENDA")
public class Encomenda {

	private Long idEncomenda;
	private String codEncomenda;
	private String nomeEncomenda;
	private Integer idadeEncomenda;
	private Cidade cidade;

	public Encomenda() {

	}

	public Encomenda(Long idEncomenda, String codEncomenda, String nomeEncomenda, Integer idadeEncomenda, Cidade cidade) {
		this.idEncomenda = idEncomenda;
		this.codEncomenda = codEncomenda;
		this.nomeEncomenda = nomeEncomenda;
		this.idadeEncomenda = idadeEncomenda;
		this.cidade = cidade;
	}

	@Id
	@Column(name="ID_ENCOMENDA")
	public Long getIdEncomenda() {
		return idEncomenda;
	}

	public void setIdEncomenda(Long idEncomenda) {
		this.idEncomenda = idEncomenda;
	}

	@Column(name="COD_ENCOMENDA")
	public String getCodEncomenda() {
		return codEncomenda;
	}

	public void setCodEncomenda(String codEncomenda) {
		this.codEncomenda = codEncomenda;
	}

	@Column(name="NOME_ENCOMENDA")
	public String getNomeEncomenda() {
		return nomeEncomenda;
	}

	public void setNomeEncomenda(String nomeEncomenda) {
		this.nomeEncomenda = nomeEncomenda;
	}

	@Column(name="IDADE")
	public Integer getIdadeEncomenda() {
		return idadeEncomenda;
	}

	public void setIdadeEncomenda(Integer idadeEncomenda) {
		this.idadeEncomenda = idadeEncomenda;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CIDADE")
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
