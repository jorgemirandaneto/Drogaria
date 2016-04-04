package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.PessoaDAO;
import br.pro.delfino.drogaria.dao.UsuarioDAO;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	private Usuario usuario;	
	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	public void novo(){
		try{
		usuario = new Usuario();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas = pessoaDAO.listar();
		}catch(RuntimeException erro){
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao gerar um novo usuário");
		}
	
	}
	
	
	@PostConstruct
	public void listar(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
			
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao listar usuário");
		}
	}
	
}
