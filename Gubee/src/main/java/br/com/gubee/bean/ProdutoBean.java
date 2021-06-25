
package br.com.gubee.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.gubee.dao.MercadoAlvoDAO;
import br.com.gubee.dao.ProdutoDAO;
import br.com.gubee.dao.TecnologiaUtilizadaDAO;
import br.com.gubee.domain.MercadoAlvo;
import br.com.gubee.domain.Produto;
import br.com.gubee.domain.TecnologiaUtilizada;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private Produto produto;
	private List<Produto> produtos;
	private List<TecnologiaUtilizada> tecnologiaUtilizadas;
	private List<MercadoAlvo> mercadoAlvos;
	
	

	

	public List<MercadoAlvo> getMercadoAlvos() {
		return mercadoAlvos;
	}

	public void setMercadoAlvos(List<MercadoAlvo> mercadoAlvos) {
		this.mercadoAlvos = mercadoAlvos;
	}

	public List<TecnologiaUtilizada> getTecnologiaUtilizadas() {
		return tecnologiaUtilizadas;
	}

	public void setTecnologiaUtilizadas(List<TecnologiaUtilizada> tecnologiaUtilizadas) {
		this.tecnologiaUtilizadas = tecnologiaUtilizadas;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void novo() {
		try {

			produto = new Produto();

			TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
			tecnologiaUtilizadas = tecnologiaUtilizadaDAO.listar("nomeTecnologiaUtilizada");
			
			MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
			mercadoAlvos = mercadoAlvoDAO.listar("nomeMercadoAlvo");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Produto");
		}

	}

	public void salvar() {
		try {

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);

			produto = new Produto();

			TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
			tecnologiaUtilizadas = tecnologiaUtilizadaDAO.listar();
			
			MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
			mercadoAlvos = mercadoAlvoDAO.listar("nomeMercadoAlvo");

			// produtoDAO.salvar(produto);

			

			produtos = produtoDAO.listar();
			

			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Produto");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Produto");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);

			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Produto removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a Produto");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
			tecnologiaUtilizadas = tecnologiaUtilizadaDAO.listar();
			
			MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
			mercadoAlvos = mercadoAlvoDAO.listar("nomeMercadoAlvo");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar uma produto");
			erro.printStackTrace();
		}

	}

}
