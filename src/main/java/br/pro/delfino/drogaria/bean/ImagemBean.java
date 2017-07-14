package br.pro.delfino.drogaria.bean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
	

@ManagedBean
@RequestScoped
public class ImagemBean {
	@ManagedProperty("#{param.caminho}")
	private String caminho;
	private StreamedContent foto;
	
	public String getCaminho() {
		return caminho;
	}
	
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public StreamedContent getFoto() throws IOException {
		if(caminho == null || caminho.isEmpty()) {
			Path pach = Paths.get("C:/Users/jorge/Documents/Upload/branco.png");
			InputStream stream = Files.newInputStream(pach);
			foto = new DefaultStreamedContent(stream);
		}else {
			Path pach = Paths.get(caminho);
			InputStream stream = Files.newInputStream(pach);
			foto = new DefaultStreamedContent(stream);
		}
		return foto;
	}
	
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}
}
