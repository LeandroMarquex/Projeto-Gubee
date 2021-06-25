package br.com.gubee.testDAO;

import org.junit.Test;

import br.com.gubee.dao.MercadoAlvoDAO;
import br.com.gubee.dao.ProdutoDAO;
import br.com.gubee.dao.TecnologiaUtilizadaDAO;
import br.com.gubee.domain.MercadoAlvo;
import br.com.gubee.domain.Produto;
import br.com.gubee.domain.TecnologiaUtilizada;

public class ProdutoDAOTest {

	
	@Test
//	@Ignore
	public void salvar() {
	
		
		TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
		TecnologiaUtilizada tecnologiaUtilizada = tecnologiaUtilizadaDAO.buscar(new Long("1"));	
		Produto produto = new Produto();
		produto.setNomeProduto("Linguagem de Programção");
		produto.setDescricaoProduto("Curso de Java");
		
		produto.setTecnologiaUtilizada(tecnologiaUtilizada);
	
		
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}
}
