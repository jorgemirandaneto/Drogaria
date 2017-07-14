package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.math.BigDecimal;
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
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");

			vendasItem = new ArrayList<>();
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao carregar produtos");
		}

	}

	public void adicionar(ActionEvent evento) {

		Produto produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

		int achou = -1;
		for (int posicao = 0; posicao < vendasItem.size(); posicao++) {
			if (vendasItem.get(posicao).getProduto().equals(produto)) {
				achou = posicao;
			}
		}
		if (achou < 0) {
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setValorParcial(produto.getPreco());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("1"));

			vendasItem.add(itemVenda);
		} else {
			ItemVenda itemVenda = vendasItem.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
			itemVenda.setValorParcial(produto.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
		}
	}

	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = new ItemVenda();
		itemVenda = (ItemVenda) evento.getComponent().getAttributes().get("itemSelecionado");

		int achou = -1;
		for (int posicao = 0; posicao < vendasItem.size(); posicao++) {
			if (vendasItem.get(posicao).getProduto().equals(itemVenda.getProduto())) {
				achou = posicao;
			}
		}

		if (achou < -1) {
			//Produto produto = new Produto();
			//vendasItem.get(achou);
			//itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() -1 - ""));
			//itemVenda.setValorParcial(produto.getPreco().subtract(new BigDecimal("-1")));
			System.out.println("TESTE");
		}
		
	}
}