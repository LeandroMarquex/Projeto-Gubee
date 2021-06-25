package br.com.gubee.bean;

import java.io.Serializable;
import java.util.List;


import javax.annotation.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.gubee.dao.MercadoAlvoDAO;
import br.com.gubee.domain.MercadoAlvo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MercadoAlvoBean implements Serializable {

	private MercadoAlvo mercadoAlvo;
	private List<MercadoAlvo> mercadosAlvo;


	public MercadoAlvo getMercadoAlvo() {
		return mercadoAlvo;
	}

	public void setMercadoAlvo(MercadoAlvo mercadoAlvo) {
		this.mercadoAlvo = mercadoAlvo;
	}

	public List<MercadoAlvo> getMercadosAlvo() {
		return mercadosAlvo;
	}

	public void setMercadosAlvo(List<MercadoAlvo> mercadosAlvo) {
		this.mercadosAlvo = mercadosAlvo;
	}

	public void novo() {
		mercadoAlvo = new MercadoAlvo();
	}

	public void salvar() {
		try {
			MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
			mercadoAlvoDAO.salvar(mercadoAlvo);
		//	mercadoAlvoDAO.merge(mercadoAlvo);

			novo();
			
			mercadosAlvo = mercadoAlvoDAO.listar();
			
			Messages.addGlobalInfo("Mercado alvo salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Mercado Alvo");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
			mercadosAlvo = mercadoAlvoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Mercados Alvos");
			erro.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento) {
		try {
			mercadoAlvo = (MercadoAlvo) evento.getComponent().getAttributes().get("mercadoAlvoSelecionado");

			MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
			mercadoAlvoDAO.excluir(mercadoAlvo);

			mercadosAlvo = mercadoAlvoDAO.listar();

			Messages.addGlobalInfo("Mercado Alvo removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a Mercado Alvo");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		mercadoAlvo = (MercadoAlvo) evento.getComponent().getAttributes().get("mercadoAlvoSelecionado");
	}
	
}
