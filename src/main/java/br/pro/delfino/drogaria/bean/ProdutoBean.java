package br.pro.delfino.drogaria.bean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.pro.delfino.drogaria.dao.FabricanteDAO;
import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	Produto produto;
	List<Produto> produtos;
	List<Fabricante> fabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao carregar lista");
		}
	}

	public void novo() {
		try {
			produto = new Produto();

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar gerar um novo produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);

			produto = new Produto();

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();

			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao salvar produto");
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);

			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Sucesso ao excluir produto");
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao excluir produto");
		}

	}

	public void editar(ActionEvent evento) {

		try {	
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();

		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalInfo("Erro ao editar produto");
		}

	}

	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			produto.setCaminho(arquivoTemp.toString());
		} catch (IOException erro) {
			Messages.addGlobalInfo("Erro ao salvar a foto");
			erro.printStackTrace();
		}

	}

}
