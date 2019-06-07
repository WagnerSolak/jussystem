package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.repository.DeclaracaoJusticaGratuitas;
import com.jussystem.repository.filter.DeclaracaoJusticaGratuitaFilter;
import com.jussystem.util.jsf.FacesUtil;
import com.jussystem.util.report.ExecutorRelatorio;

@Named
@RequestScoped
public class RelatorioDeclaracaoJusticaGratuitaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletResponse response;
	
	@Inject
	private EntityManager manager;
	
	private List<DeclaracaoJusticaGratuita> declaracoesJusticaGratuitaFiltrada;
	
	private DeclaracaoJusticaGratuitaFilter filtro;
	
	
	
	
	//atributos para vincular tela - relatorio
	private Date dataInicio;
	private Date dataFim;
	private String nome;
	
	public void emitir() {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("data_inicio", this.dataInicio);
		parametros.put("data_final", this.dataFim);
		parametros.put("nome_cliente", this.nome);
		
		ExecutorRelatorio executor =  new ExecutorRelatorio("/relatorios/doc_declaracao_justica_gratuita.jasper",
		 		 this.response, parametros, "Declaracao Justica Gratuita.pdf");
		 
		 
		 
		 Session session = manager.unwrap(Session.class);
		 session.doWork(executor);
		 
		 
		 if(executor.isRelatorioGerado()){
			 facesContext.responseComplete();
		 }else{
			 FacesUtil.addErrorMessage("Não existem registros para os filtros informados!");
		 }
		 
	}
	
	public RelatorioDeclaracaoJusticaGratuitaBean(){
		filtro = new DeclaracaoJusticaGratuitaFilter();
		declaracoesJusticaGratuitaFiltrada = new ArrayList<>();
	}
	

	
	//teste inicial mas nao atende ao que deve ser impelementado - inicio
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	//teste inicial mas nao atende ao que deve ser impelementado -final
	
	
	
	public List<DeclaracaoJusticaGratuita> getDeclaracoesJusticaGratuitaFiltrada() {
		return declaracoesJusticaGratuitaFiltrada;
	}
	
	public DeclaracaoJusticaGratuitaFilter getFiltro() {
		return filtro;
	}
	
}
