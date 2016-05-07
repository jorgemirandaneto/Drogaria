package br.pro.delfino.drogaria.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.pro.delfino.drogaria.dao.FabricanteDAO;
import br.pro.delfino.drogaria.domain.Fabricante;

@Path("fabricante")
public class FabricanteService {
	
	@GET
	public String listar(){
	FabricanteDAO fabricanteDAO = new FabricanteDAO();
	List<Fabricante> fabricantes = fabricanteDAO.listar("descricao");
	
	Gson gson = new Gson();
	String json = gson.toJson(fabricantes);
		
	return json;
	
	}
	
}
