package br.pro.delfino.drograria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.pro.delfino.drograria.domain.Cidade;

@SuppressWarnings("serial")
@ManagedBean
public class CidadeBean implements Serializable {

	List<Cidade> cidades;
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	



}
