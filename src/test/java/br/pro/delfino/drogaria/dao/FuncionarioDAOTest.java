package br.pro.delfino.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drograria.domain.Funcionario;
import br.pro.delfino.drograria.domain.Pessoa;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabalho("3215466554");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("10/1/2015"));
		funcionario.setPessoa(pessoa);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);

	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		for (Funcionario funcionario : resultado) {
			System.out.println(funcionario.getCarteiraTrabalho());
			System.out.println(funcionario.getDataAdmissao());
			System.out.println(funcionario.getPessoa());
		}
	}
	
	
	@Test
	@Ignore
	public void buscar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		System.out.println(funcionario.getCarteiraTrabalho());
		System.out.println(funcionario.getDataAdmissao());
		System.out.println(funcionario.getPessoa());

	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		funcionario.setCarteiraTrabalho("3215466554");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("15/1/2015"));
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.editar(funcionario);
		
		System.out.println(funcionario.getCarteiraTrabalho());
		System.out.println(funcionario.getDataAdmissao());
		System.out.println(funcionario.getPessoa());
	}
	
	@Test
	public void excluir(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		
		funcionarioDAO.excluir(funcionario);
		
		System.out.println(funcionario.getCarteiraTrabalho());
		System.out.println(funcionario.getDataAdmissao());
		System.out.println(funcionario.getPessoa());
	}
	
	
	
	
	
}
