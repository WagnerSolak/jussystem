package com.jussystem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.jussystem.model.Fornecedor;
import com.jussystem.model.StatusFornecedor;
import com.jussystem.repository.Fornecedores;
import com.jussystem.repository.filter.FornecedorFilter;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroFornecedorService;

@Named
@ViewScoped
public class PesquisaFornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Fornecedores fornecedores;
	
	@Inject
	private CadastroFornecedorService cadastroFornecedorService;

	private Fornecedor fornecedorSelecionado;

	private FornecedorFilter filtro;

	private List<Fornecedor> fornecedoresFiltrados;

	public PesquisaFornecedorBean() {
		filtro = new FornecedorFilter();
		fornecedoresFiltrados = new ArrayList<>();

	}

	public void ativarDesativarStatusFornecedor() {
		if(fornecedorSelecionado != null){
			if(fornecedorSelecionado.getStatus().equals(StatusFornecedor.ATIVO)){
				fornecedorSelecionado.setStatus(StatusFornecedor.INATIVO);
				FacesUtil.addInfoMessage("Fornecedor "
						+ fornecedorSelecionado.getNomeFantasia()
						+ ", INATIVADO com sucesso!");
				salvarRemoverDaLista();
			}
			else{
				fornecedorSelecionado.setStatus(StatusFornecedor.ATIVO);
				FacesUtil.addInfoMessage("Fornecedor "
						+ fornecedorSelecionado.getNomeFantasia()
						+ ", ATIVADO com sucesso!");
				salvarRemoverDaLista();
			}
		}
		
	

	}
	
	

	public void salvarRemoverDaLista() {
		fornecedorSelecionado = cadastroFornecedorService.salvar(fornecedorSelecionado);
		fornecedoresFiltrados.remove(fornecedorSelecionado);
	}

	public void pesquisar() {
		fornecedoresFiltrados = fornecedores.filtrados(filtro);
	}
	
	 public void posProcessarXls(Object documento){
	    	HSSFWorkbook planilha = (HSSFWorkbook) documento;
	    	HSSFSheet folha  = planilha.getSheetAt(0);
	    	HSSFRow cabecalho = folha.getRow(0);
	    	HSSFCellStyle estiloCelula = planilha.createCellStyle();
	    	HSSFFont fonteCabecalho = planilha.createFont();
	    	
	    	fonteCabecalho.setColor(IndexedColors.WHITE.getIndex());
	    	fonteCabecalho.setBold(true);
	    	fonteCabecalho.setFontHeightInPoints((short)12);
	    	
	    	estiloCelula.setFont(fonteCabecalho);
	    	estiloCelula.setFillForegroundColor(HSSFColor.BLUE.index);
	    	estiloCelula.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    	
	    	for(int i = 0; i < cabecalho.getPhysicalNumberOfCells(); i++){
	    		cabecalho.getCell(i).setCellStyle(estiloCelula);
	    	}
	    	
	    	
	    	
	    }
	 
	 

	public FornecedorFilter getFiltro() {
		return filtro;
	}

	public StatusFornecedor[] getStatuses() {
		return StatusFornecedor.values();
	}

	public List<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}

	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

}
