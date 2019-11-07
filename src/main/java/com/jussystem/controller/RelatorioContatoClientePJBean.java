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
public class RelatorioContatoClientePJBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletResponse response;
	
	@Inject
	private EntityManager manager;
	
	
	public void emitir() {
		try {
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("codigo", codigo);
			
			
			ExecutorRelatorio executor = new ExecutorRelatorio("/META-INF/relatorios/relatorio_contato_cliente_pj.jasper",
					response, parametros, "ContatoClientePJ.pdf");
			 
			Session session = manager.unwrap(Session.class);
			session.doWork(executor);
			
			if(executor.isRelatorioGerado()){
				facesContext.responseComplete();
			}
			
		} catch (GenericJDBCException e) {
			e.getMessage();
			FacesUtil.addErrorMessage("Não existem registros para o filtro informado!");
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
