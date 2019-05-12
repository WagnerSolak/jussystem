/*package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.jussystem.model.Cidade;
import com.jussystem.model.Estado;
import com.jussystem.model.ProcuracaoAdJudicia;
import com.jussystem.util.jsf.FacesUtil;
import com.jussystem.util.report.ExecutorRelatorio;
import com.jusystem.service.CadastroProcuracaoAdJudiciaService;


@Named
@ViewScoped
public class CadastroProcuracaoAdJudiciaBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroProcuracaoAdJudiciaService cadastroProcuracaoAdJudiciaService;
	
    @Inject
    private EntityManager manager;
    
    @Inject
    private HttpServletResponse response;
    	
	private ProcuracaoAdJudicia procuracaoAdJudicia;
	
	private Cidade cidade;
	private Estado estado;
	private List<Cidade>cidades;
	
	public void inicializar() {
		limpar();
	}
	
	public void salvar() {
		procuracaoAdJudicia = cadastroProcuracaoAdJudiciaService.salvar(procuracaoAdJudicia);
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", procuracaoAdJudicia.getId());
		
		
		ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/relatorio_pedidos_emitidos.jasper",
					this.response, parametros, "Pedidos emitidos.pdf");
		
		
		Session session = manager.unwrap(Session.class);
		session.doWork(executor);
		
		limpar();
		FacesUtil.addInfoMessage("Procuração salva com sucesso");
	}
	
	private void limpar() {
		procuracaoAdJudicia = new ProcuracaoAdJudicia();
		
	}
	

	
	public Date getDataHoje() {
		return new Date();
	}
	
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setProcuracaoAdJudicia(ProcuracaoAdJudicia procuracaoAdJudicia) {
		this.procuracaoAdJudicia = procuracaoAdJudicia;
	}
	
	public ProcuracaoAdJudicia getProcuracaoAdJudicia() {
		return procuracaoAdJudicia;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}
}
*/