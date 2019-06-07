package com.jussystem.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.repository.DeclaracaoJusticaGratuitas;
import com.jussystem.repository.filter.DeclaracaoJusticaGratuitaFilter;


@Named
@ViewScoped
public class PesquisaDeclaracaoJusticaGratuitaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DeclaracaoJusticaGratuitas declaracaoJusticaGratuitas;

	
	private List<DeclaracaoJusticaGratuita> declaracoesJusticaGratuitaFiltrada;
	
	
	private DeclaracaoJusticaGratuitaFilter filtro;
	
	public PesquisaDeclaracaoJusticaGratuitaBean(){
		filtro = new DeclaracaoJusticaGratuitaFilter();
	}
	

	public void pesquisar(){
		declaracoesJusticaGratuitaFiltrada = declaracaoJusticaGratuitas.filtrados(filtro);
	}
	
	
	
	public List<DeclaracaoJusticaGratuita> getDeclaracoesJusticaGratuitaFiltrada() {
		return declaracoesJusticaGratuitaFiltrada;
	}
	
	public DeclaracaoJusticaGratuitaFilter getFiltro() {
		return filtro;
	}
}
