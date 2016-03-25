package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.CidadeDAO;
import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.dao.PessoaDAO;
import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;
import br.pro.delfino.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	private Estado estado;

	private List<Cidade> cidades;
	private List<Estado> estados;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		try {
			pessoa = new Pessoa();

			estado = new Estado();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentantar gerar uma pessoa");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);

			novo();

			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao salvar pessoa");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao editar pessoa");
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);

			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao excluir pessoa");
		}
	}

	public void popular() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorCidade(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar cidades");
		}
	}

}
