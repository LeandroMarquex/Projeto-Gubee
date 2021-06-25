package br.com.gubee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.gubee.domain.Produto;
import br.com.gubee.util.HibernateUtil;

public class ProdutoDAO extends GenericDAO<Produto> {
	
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarPorTecnologiaUtilizada(Long tecnologiaUtilizadaCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Produto.class);
			consulta.add(Restrictions.eq("tecnologiaUtilizada.codigo", tecnologiaUtilizadaCodigo));	
			consulta.addOrder(Order.asc("nomeTecnologiaUtilizada"));
			List<Produto> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Produto> buscarPorMercadoAlvo(Long mercadoAlvoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Produto.class);
			consulta.add(Restrictions.eq("mercadoAlvo.codigo", mercadoAlvoCodigo));	
			consulta.addOrder(Order.asc("nomeMercadoAlvo"));
			List<Produto> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}