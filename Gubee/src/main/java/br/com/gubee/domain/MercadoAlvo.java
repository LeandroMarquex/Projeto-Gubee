package br.com.gubee.domain;


import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class MercadoAlvo extends GenericDomain{
	
	
	@Column(length = 50, nullable = false)
	private String nomeMercadoAlvo;

	public String getNomeMercadoAlvo() {
		return nomeMercadoAlvo;
	}

	public void setNomeMercadoAlvo(String nomeMercadoAlvo) {
		this.nomeMercadoAlvo = nomeMercadoAlvo;
	}


	
	
}



