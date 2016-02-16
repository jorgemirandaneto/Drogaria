package br.pro.delfino.drograria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drograria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void novo() {
		estado = new Estado();
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao listar");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			estado = new Estado();
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado salvo com sucesso!!!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao salvar");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try{
		estado = (Estado) evento.getComponent().getAttributes()
				.get("estadoSelecionado");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		
		estados = estadoDAO.listar();
		
		Messages.addGlobalInfo("Estado excluido com sucesso");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao deletar");
		}
	}
	
	public void editar(ActionEvent evento){
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		Messages.addGlobalInfo("Nome: " + estado.getNome() + "Sigla" + estado.getSigla());
	}
}
