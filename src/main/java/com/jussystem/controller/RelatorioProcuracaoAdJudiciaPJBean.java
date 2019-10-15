package com.jussystem.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;

import com.jussystem.util.jsf.FacesUtil;
import com.jussystem.util.report.ExecutorRelatorio;


@Named
@RequestScoped
public class RelatorioProcuracaoAdJudiciaPJBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletResponse response;
	
	@Inject
	private EntityManager manager;
	
	public void emitir(){
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("codigo", this.codigo);

		
		ExecutorRelatorio executor =  new ExecutorRelatorio("/META-INF/relatorios/doc_procuracao_ad_judicia_pj.jasper",
		 		 this.response, parametros, "ProcuracaoAdJudiciaPJ.pdf");
		 
		 
		 
		 Session session = manager.unwrap(Session.class);
		 session.doWork(executor);
		 
		 
		 if(executor.isRelatorioGerado()){
			 facesContext.responseComplete();
		 }else{
			 FacesUtil.addErrorMessage("Não existem registros para os filtros informados!");
		 }
		 
	}
	
	@NotNull
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
