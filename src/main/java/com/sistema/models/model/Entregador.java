package com.sistema.models.model;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ENTREGADOR")
public class Entregador {

	
	private Long    idEntregador;
	private String  codEntregador;
	private String  nomeEntregador;
	private Cidade  cidade;
	
    
	private List<Produto> listaProduto;
	
	public Entregador() {
		
	}

	public Entregador(Long idEntregador, String codEntregador, String nomeEntregador, Cidade cidade) {
		this.idEntregador = idEntregador;
		this.codEntregador = codEntregador;
		this.nomeEntregador = nomeEntregador;
		this.cidade = cidade;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTREGADOR_SEQ")
	@SequenceGenerator(sequenceName = "SEQUENCE_ENTREGADOR",initialValue = 1,allocationSize = 1, name="ENTREGADOR_SEQ")
	@Column(name = "ID_ENTREGADOR")
	public Long getIdEntregador() {
		return idEntregador;
	}

	public void setIdEntregador(Long idEntregador) {
		this.idEntregador = idEntregador;
	}
	
	
    @NotNull(message = "O campo código do entregador não pode ser nulo ")
	@Column(name = "COD_ENTREGADOR")
	public String getCodEntregador() {
		return codEntregador;
	}

	public void setCodEntregador(String codEntregador) {
		this.codEntregador = codEntregador;
	}

	@NotBlank(message = "O nome do entregador deve ser informado")
	@Column(name = "NOME_ENTREGADOR")
	public String getNomeEntregador() {
		return nomeEntregador;
	}

	public void setNomeEntregador(String nomeEntregador) {
		this.nomeEntregador = nomeEntregador;
	}

	@NotNull(message = "A cidade deve ser selecionada")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CIDADE")
	public Cidade getCidade() {
		return cidade;
	}



	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@OneToMany(mappedBy = "entregador",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
     
	
	
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	@Override
	public String toString() {
		return "Entregador [idEntregador=" + idEntregador + ", codEntregador=" + codEntregador + ", nomeEntregador="
				+ nomeEntregador + ", cidade=" + cidade + "]";
	}
	
	
    
}
