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

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.repository.ClientePessoaJuridicas;
import com.jussystem.repository.filter.ClientePessoaJuridicaFilter;


@Named
@ViewScoped
public class PesquisaClientePessoaJuridicaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientePessoaJuridicas clientePessoaJuridicas;
	
	private ClientePessoaJuridicaFilter filtro;
	
	List<ClientePessoaJuridica> clientesPessoaJuridicaFiltrados;
	
	public PesquisaClientePessoaJuridicaBean(){
		filtro = new ClientePessoaJuridicaFilter();
		clientesPessoaJuridicaFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		clientesPessoaJuridicaFiltrados = clientePessoaJuridicas.filtrados(filtro);
	}
	
	

	public ClientePessoaJuridicaFilter getFiltro() {
		return filtro;
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

	

	public List<ClientePessoaJuridica> getClientesPessoaJuridicaFiltrados() {
		return clientesPessoaJuridicaFiltrados;
	}

	public void setClientesPessoaJuridicaFiltrados(
			List<ClientePessoaJuridica> clientesPessoaJuridicaFiltrados) {
		this.clientesPessoaJuridicaFiltrados = clientesPessoaJuridicaFiltrados;
	}
	
	
}
