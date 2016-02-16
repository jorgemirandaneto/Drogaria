package br.pro.delfino.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drograria.domain.Cliente;
import br.pro.delfino.drograria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/10/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		System.out.println(cliente.getPessoa());
		System.out.println(cliente.getDataCadastro());
		System.out.println(cliente.getLiberado());


	}

	@Test
	@Ignore
	public void listar() {

		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			System.out.println(cliente.getPessoa());
			System.out.println(cliente.getDataCadastro());
			System.out.println(cliente.getLiberado());

		}
	}
	@Test
	@Ignore
	public void buscar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		System.out.println(cliente.getPessoa());
		System.out.println(cliente.getDataCadastro());
		System.out.println(cliente.getLiberado());

	}

	@Test
	@Ignore
	public void editar() throws ParseException {

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("13/03/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		clienteDAO.editar(cliente);

		System.out.println(cliente.getPessoa());
		System.out.println(cliente.getDataCadastro());
		System.out.println(cliente.getLiberado());

	}

	@Test
	@Ignore
	public void excluir() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		clienteDAO.excluir(cliente);

		System.out.println(cliente.getPessoa());
		System.out.println(cliente.getDataCadastro());
		System.out.println(cliente.getLiberado());
	}

}
