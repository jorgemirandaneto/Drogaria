package br.pro.delfino.drogaria.dao;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;

import br.pro.delfino.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Remedio de pressão");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void lista(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		

		System.out.println("Quantidade de colunas: " + resultado.size());
		
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Fabricante não encotrado");
			
		}else{
			
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Operação invalida");
		}else{
			fabricanteDAO.excluir(fabricante);
			System.out.println("Fabricante excluido com sucesso");
			System.out.println(  fabricante.getCodigo() +"-"+ fabricante.getDescricao());
		}
		
	}
	
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Operação invalida");
		}else{
			System.out.println("Antes de alterar");
			System.out.println(fabricante.getDescricao());
			
			fabricante.setDescricao("Remedio de cancer");
			fabricanteDAO.editar(fabricante);
			
			System.out.println("Depois de alterar");
			System.out.println(fabricante.getDescricao());
		}
	}
	
	@Test
	public void listarWS(){
		
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:8080/Drogaria/rest/fabricante");
		String json = caminho.request().get(String.class);
		
		Gson gson = new Gson();
		Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
		
		List<Fabricante> fabricantes = Arrays.asList(vetor);
		
		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.getDescricao());
		}
	}
	
}
