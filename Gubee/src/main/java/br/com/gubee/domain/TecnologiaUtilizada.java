package br.com.gubee.domain;


import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class TecnologiaUtilizada extends GenericDomain{
	
	
	@Column(length = 50, nullable = false)
	private String nomeTecnologiaUtilizada;

	public String getNomeTecnologiaUtilizada() {
		return nomeTecnologiaUtilizada;
	}

	public void setNomeTecnologiaUtilizada(String nomeTecnologiaUtilizada) {
		this.nomeTecnologiaUtilizada = nomeTecnologiaUtilizada;
	}

	

	
	
}



