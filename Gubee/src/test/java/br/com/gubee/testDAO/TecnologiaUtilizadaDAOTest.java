package br.com.gubee.testDAO;

import org.junit.Test;

import br.com.gubee.dao.TecnologiaUtilizadaDAO;
import br.com.gubee.domain.TecnologiaUtilizada;

public class TecnologiaUtilizadaDAOTest {

	
	@Test
//	@Ignore
	public void salvar() {
		TecnologiaUtilizada tecnologiaUtilizada = new  TecnologiaUtilizada();
		
		tecnologiaUtilizada.setNomeTecnologiaUtilizada("Java Script");
		
		TecnologiaUtilizadaDAO tecnologiaUtilizadaDAO = new TecnologiaUtilizadaDAO();
		tecnologiaUtilizadaDAO.salvar(tecnologiaUtilizada);
	}
}
