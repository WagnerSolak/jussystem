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
import org.hibernate.exception.GenericJDBCException;

import com.jussystem.util.jsf.FacesUtil;
import com.jussystem.util.report.ExecutorRelatorio;


@Named
@RequestScoped
public class RelatorioProcuracaoAdJudiciaPFBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletResponse response;
	
	@Inject
	private EntityManager manager;
	
	
	public void emitir(){
		
		
		try {
			
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("codigo", this.codigo);
			
			ExecutorRelatorio executor = new ExecutorRelatorio("/META-INF/relatorios/doc_procuracao_ad_judicia_pf.jasper",
					this.response, parametros, "ProcuraçãoAdJudiciaPF.pdf");
			Session session = manager.unwrap(Session.class);
			session.doWork(executor);
			
			if(executor.isRelatorioGerado()){
				facesContext.responseComplete();
			}else{
				FacesUtil.addErrorMessage("Não existem registros para o filtro informado!");
			}
			
		} catch (GenericJDBCException e) {
			e.getMessage();
			FacesUtil.addErrorMessage("Não existem registros para o filtro informado!");
		}
		
		
		
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotNull(message = "O campo deve ser preenchido.")
	public Long getCodigo() {
		return codigo;
	}
}
