package br.pro.delfino.drogaria.dao;




import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drograria.domain.Pessoa;



public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Raiza");
		pessoa.setCpf("039947103-08");
		pessoa.setRg("00773654108");
		pessoa.setRua("Rua Salvador Correia sá");
		pessoa.setBairro("Sapiranga");
		pessoa.setNumero(new Short("1001"));
		pessoa.setCep("60833-183");
		pessoa.setComplemento("BL5 CS 202");
		pessoa.setTelefone("31816906");
		pessoa.setCelular("986453048");
		pessoa.setEmail("jorgin.miranda@gmail.com");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		pessoaDAO.salvar(pessoa);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		
		for(Pessoa pessoa : resultado){
			System.out.println(pessoa.getNome());
		}
		
	}
	@Test
	@Ignore
	public void buscar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());
		System.out.println(pessoa.getRg());
		System.out.println(pessoa.getRua());
		System.out.println(pessoa.getEmail());
		System.out.println(pessoa.getCelular());
		System.out.println(pessoa.getBairro());
		
	}
	@Test
	@Ignore
	public void excluir(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		pessoaDAO.excluir(pessoa);
		
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());
		System.out.println(pessoa.getRg());
		System.out.println(pessoa.getRua());
		System.out.println(pessoa.getEmail());
		System.out.println(pessoa.getCelular());
		System.out.println(pessoa.getBairro());
		
	}

	@Test
	public void editar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		pessoa.setNome("Jorge");
		pessoa.setCpf("039947103-08");
		pessoa.setRg("00773654108");
		pessoa.setRua("Rua Salvador Correia sá");
		pessoa.setBairro("Sapiranga");
		pessoa.setNumero(new Short("1001"));
		pessoa.setCep("60833-183");
		pessoa.setComplemento("BL5 CS 202");
		pessoa.setTelefone("31816906");
		pessoa.setCelular("986453048");
		pessoa.setEmail("jorgin.miranda@gmail.com");
		
		pessoaDAO.editar(pessoa);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());
		System.out.println(pessoa.getRg());
		System.out.println(pessoa.getRua());
		System.out.println(pessoa.getEmail());
		System.out.println(pessoa.getCelular());
		System.out.println(pessoa.getBairro());
		
		
	}
	






}


