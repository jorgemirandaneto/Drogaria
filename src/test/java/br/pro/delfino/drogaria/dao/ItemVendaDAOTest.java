package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.ItemVenda;
import br.pro.delfino.drogaria.domain.Produto;
import br.pro.delfino.drogaria.domain.Venda;

public class ItemVendaDAOTest {
	
	@Test
	public void salvar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);
		
		
		ItemVenda itemVenda = new ItemVenda();
		
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("2"));
		itemVenda.setVenda(venda);
		itemVenda.setValorParcial(new BigDecimal("5.5"));
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		
		itemVendaDAO.salvar(itemVenda);
		
		
		}

}
