package br.com.gubee.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Produto extends GenericDomain {
	
	@Column(length = 50, nullable = false)
	private String nomeProduto;
	
	@Column(length = 80, nullable = false)
	private String descricaoProduto;
	

	@ManyToOne
	@JoinColumn(nullable = false)
	private TecnologiaUtilizada tecnologiaUtilizada;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private MercadoAlvo mercadoAlvo;



	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public String getDescricaoProduto() {
		return descricaoProduto;
	}


	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}


	public TecnologiaUtilizada getTecnologiaUtilizada() {
		return tecnologiaUtilizada;
	}


	public void setTecnologiaUtilizada(TecnologiaUtilizada tecnologiaUtilizada) {
		this.tecnologiaUtilizada = tecnologiaUtilizada;
	}


	public MercadoAlvo getMercadoAlvo() {
		return mercadoAlvo;
	}


	public void setMercadoAlvo(MercadoAlvo mercadoAlvo) {
		this.mercadoAlvo = mercadoAlvo;
	}

	

	




}
