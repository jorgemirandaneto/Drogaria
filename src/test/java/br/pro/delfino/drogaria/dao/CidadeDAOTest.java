package br.pro.delfino.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Estado;
import br.pro.delfino.drogaria.domain.Pessoa;

public class CidadeDAOTest {
	@Test
	public void salvar() {

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);

		Cidade cidade = new Cidade();
		cidade.setNome("Fortaleza");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();

		cidadeDAO.salvar(cidade);

		System.out.println(cidade.getNome());
		System.out.println(cidade.getEstado());
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getNome());
			System.out.println(cidade.getEstado());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(1L);

		System.out.println(cidade.getNome());
		System.out.println(cidade.getEstado());

	}

	@Test
	@Ignore
	public void editar() throws ParseException {

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy")
				.parse("13/03/2015"));
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
