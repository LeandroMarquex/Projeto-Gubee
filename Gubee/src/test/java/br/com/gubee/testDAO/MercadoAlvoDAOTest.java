package br.com.gubee.testDAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gubee.dao.MercadoAlvoDAO;
import br.com.gubee.domain.MercadoAlvo;

public class MercadoAlvoDAOTest {
	
	@Test
//	@Ignore
	public void salvar() {
		MercadoAlvo mercadoAlvo = new  MercadoAlvo();
		
		mercadoAlvo.setNomeMercadoAlvo("Comercio2");
		
		MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
		mercadoAlvoDAO.salvar(mercadoAlvo);
	}

	@Test
	//@Ignore
	public void listar() {
		MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
		List<MercadoAlvo> resultado = mercadoAlvoDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (MercadoAlvo mercadoAlvo : resultado) {
			System.out.println(mercadoAlvo.getCodigo() + " - " + mercadoAlvo.getNomeMercadoAlvo());
		}
	}
	
	@Test
//	@Ignore
	public void buscar(){
		Long codigo = 3L;
		
		MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
		MercadoAlvo mercadoAlvo = mercadoAlvoDAO.buscar(codigo);
		
		if(mercadoAlvo == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(mercadoAlvo.getCodigo() + " - " + mercadoAlvo.getNomeMercadoAlvo());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
		MercadoAlvo mercadoAlvo = mercadoAlvoDAO.buscar(codigo);
		
		if(mercadoAlvo == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			mercadoAlvoDAO.excluir(mercadoAlvo);
			System.out.println("Registro removido:");
			System.out.println(mercadoAlvo.getCodigo() + " - " + mercadoAlvo.getNomeMercadoAlvo());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2L;
		MercadoAlvoDAO mercadoAlvoDAO = new MercadoAlvoDAO();
		MercadoAlvo mercadoAlvo = mercadoAlvoDAO.buscar(codigo);
		
		if(mercadoAlvo == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(mercadoAlvo.getCodigo() + " - "  + mercadoAlvo.getNomeMercadoAlvo());
			
			mercadoAlvo.setNomeMercadoAlvo("Santa Catarina");
			mercadoAlvoDAO.editar(mercadoAlvo);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(mercadoAlvo.getCodigo() + " - " + mercadoAlvo + " - " + mercadoAlvo.getNomeMercadoAlvo());
		}
	}
}
