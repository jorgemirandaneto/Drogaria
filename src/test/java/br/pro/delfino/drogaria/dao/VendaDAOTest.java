package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	public void salvar() throws ParseException {

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		Venda venda = new Venda();
		venda.setHorario(new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2015"));
		venda.setPrecoTotal(new BigDecimal("25.50"));
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
		

		System.out.println(venda.getPrecoTotal());
		System.out.println(venda.getCliente());
		System.out.println(venda.getFuncionario());
		System.out.println(venda.getHorario());
	}

	@Test
	public void buscar() {

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);
		
		System.out.println(venda.getPrecoTotal());
		System.out.println(venda.getCliente());
		System.out.println(venda.getFuncionario());
		System.out.println(venda.getHorario());
	}

}
