package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.ItemVenda;
import br.pro.delfino.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	
	List<Produto> produtos;
	List<ItemVenda> vendasItem;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<ItemVenda> getVendasItem() {
		return vendasItem;
	}
	
	public void setVendasItem(List<ItemVenda> vendasItem) {
		this.vendasItem = vendasItem;
	}
	
	@PostConstruct
	public void listar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");
			
			vendasItem = new ArrayList<>();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao carregar produtos");
		}
		
	}
	
	
	public void adicionar(ActionEvent evento){
		
		Produto produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setValorParcial(produto.getPreco());
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("1"));
		
		vendasItem.add(itemVenda);
		
		System.out.println(produto);
	}
	
		
}
