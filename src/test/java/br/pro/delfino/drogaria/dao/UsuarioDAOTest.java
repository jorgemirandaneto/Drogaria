package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drograria.domain.Pessoa;
import br.pro.delfino.drograria.domain.Usuario;


public class UsuarioDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setSenha("1q2w3e4r");
		usuario.setTipo('A');
		usuario.setPessoa(pessoa);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		
		for(Usuario usuario : resultado){
			System.out.println(usuario.getPessoa());
			System.out.println(usuario.getSenha());
			System.out.println(usuario.getTipo());
		}
	}

	@Test
	@Ignore
	public void buscar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1L);
		
		System.out.println(usuario.getPessoa());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getTipo());
	
	}
	@Test
	@Ignore
	public void editar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		usuario.setAtivo(true);
		usuario.setSenha("1234");
		usuario.setTipo('A');
		usuario.setPessoa(pessoa);
		
		usuarioDAO.editar(usuario);

		System.out.println(usuario.getPessoa());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getTipo());
		
	}
	
	public void excluir(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1L);
		
		usuarioDAO.excluir(usuario);
		
		System.out.println(usuario.getPessoa());
		System.out.println(usuario.getSenha());
		System.out.println(usuario.getTipo());
		
		
	}
	
}
