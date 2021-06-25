package br.com.gubee.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;


import br.com.gubee.dao.TecnologiaUtilizadaDAO;

import br.com.gubee.domain.TecnologiaUtilizada;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TecnologiaUtilizadaBean implements Serializable {

	private TecnologiaUtilizada tecnologiaUtilizada;
	private List<TecnologiaUtilizada> tecnologiasUtilizada;


	

	public TecnologiaUtilizada getTecnologiaUtilizada() {
		return tecnologiaUtilizada;
	}

	public void setTecnologiaUtilizada(TecnologiaUtilizada tecnologiaUtilizada) {
		this.tecnologiaUtilizada = tecnologiaUtilizada;
	}

	public List<TecnologiaUtilizada> getTecnologiasUtilizada() {
		return tecnologiasUtilizada;
	}

	public void setTecnologiasUtilizada(List<TecnologiaUtilizada> tecnologiasUtilizada) {
		this.tecnologiasUtilizada = tecnologiasUtilizada;
	}

	public void novo() {
		tecnologiaUtilizada = new TecnologiaUtilizada();
	}

	public void salvar() {
		try {
			TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
		
			tecnologiaUtilizadaDAO.merge(tecnologiaUtilizada);
			//	tecnologiaUtilizadaDAO.salvar(tecnologiaUtilizada);

			novo();
			
			tecnologiasUtilizada = tecnologiaUtilizadaDAO.listar();
			
			Messages.addGlobalInfo("Tecnologia Utilizada salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Tecnologia Utilizada");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
			tecnologiasUtilizada = tecnologiaUtilizadaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Tecnologia Utilizada");
			erro.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento) {
		try {
			tecnologiaUtilizada = (TecnologiaUtilizada) evento.getComponent().getAttributes().get("tecnologiaUtilizadaSelecionada");

			TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
			tecnologiaUtilizadaDAO.excluir(tecnologiaUtilizada);

			tecnologiasUtilizada = tecnologiaUtilizadaDAO.listar();

			Messages.addGlobalInfo("Tecnologia Utilizada removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a Tecnologia Utilizada");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		tecnologiaUtilizada = (TecnologiaUtilizada) evento.getComponent().getAttributes().get("tecnologiaUtilizadaSelecionada");
	}
	
}
