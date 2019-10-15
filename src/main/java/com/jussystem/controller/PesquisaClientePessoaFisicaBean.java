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

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.repository.ClientePessoaFisicas;
import com.jussystem.repository.filter.ClientePessoaFisicaFilter;

@Named
@ViewScoped
public class PesquisaClientePessoaFisicaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientePessoaFisicas clientePessoaFisicas;
	
	private ClientePessoaFisicaFilter filtro;
	
	private List<ClientePessoaFisica> clientesPessoaFisicaFiltrados;
	
	private ClientePessoaFisica clientePessoaFisicaSelecionado;
	
	
	
	public PesquisaClientePessoaFisicaBean(){
		filtro = new ClientePessoaFisicaFilter();
		clientesPessoaFisicaFiltrados = new ArrayList<>();
	}
	
	public void pesquisar(){
		clientesPessoaFisicaFiltrados = clientePessoaFisicas.filtrados(filtro);
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
	
	public ClientePessoaFisicaFilter getFiltro() {
		return filtro;
	}
	
	public List<ClientePessoaFisica> getClientesPessoaFisicaFiltrados() {
		return clientesPessoaFisicaFiltrados;
	}
	
	public void setClientePessoaFisicaSelecionado(
			ClientePessoaFisica clientePessoaFisicaSelecionado) {
		this.clientePessoaFisicaSelecionado = clientePessoaFisicaSelecionado;
	}
	
	public ClientePessoaFisica getClientePessoaFisicaSelecionado() {
		return clientePessoaFisicaSelecionado;
	}
	
	
	
}
