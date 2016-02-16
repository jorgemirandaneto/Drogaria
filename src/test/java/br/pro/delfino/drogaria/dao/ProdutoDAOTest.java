package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drograria.domain.Fabricante;
import br.pro.delfino.drograria.domain.Produto;


public class ProdutoDAOTest {
	
	
	@Test
	@Ignore
	public void salvar(){
 		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1L);
		
		Produto produto = new Produto();
		produto.setDescricao("Dipirona");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("9.50"));
		produto.setQuantidade(new Short("11"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println(produto.getDescricao());
		System.out.println(produto.getFabricante());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
			
		
	}
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		
		for(Produto produto : resultado){
		System.out.println(produto.getDescricao());
		System.out.println(produto.getFabricante().getDescricao());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
		}
	}

	@Test
	@Ignore
	public void buscar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);
		
		System.out.println(produto.getDescricao());
		System.out.println(produto.getFabricante().getDescricao());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
	}
	
	@Test
	@Ignore
	public void editar(){
		Long descricao = 2L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(descricao);
		
		produto.setDescricao("Gelol");
		produto.setPreco(new BigDecimal("35.0"));
		produto.setQuantidade(new Short("100"));
		
		produto.setFabricante(fabricante);
		
		produtoDAO.editar(produto);
		
		System.out.println(produto.getDescricao());
		System.out.println(produto.getFabricante().getDescricao());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
		
	}

	@Test
	@Ignore
	public void excluir(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);
		
		produtoDAO.excluir(produto);
		
		System.out.println(produto.getDescricao());
		System.out.println(produto.getFabricante().getDescricao());
		System.out.println(produto.getPreco());
		System.out.println(produto.getQuantidade());
	}























}



