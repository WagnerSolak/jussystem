package com.jussystem.controller;

import java.io.Serializable;
import java.util.Date;
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

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.model.StatusMovimentoSaidaProduto;
import com.jussystem.repository.MovimentoSaidaProdutos;
import com.jussystem.repository.filter.MovimentoSaidaProdutoFilter;
import com.jussystem.util.jsf.FacesUtil;
import com.jusystem.service.CadastroMovimentoSaidaProdutoService;


@Named
@ViewScoped
public class PesquisaMovimentoSaidaDeProdutoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MovimentoSaidaProdutos movimentoSaidaProdutos;
	
	@Inject
	private CadastroMovimentoSaidaProdutoService cadastroMovimentoSaidaProdutoService;
	
	private MovimentoSaidaProdutoFilter filtro;
	
	private List<MovimentoSaidaProduto> movimentosFiltrados;
	
	private MovimentoSaidaProduto movimentoSaidaProdutoSelecionado;
	
	
	
	public PesquisaMovimentoSaidaDeProdutoBean(){
		filtro = new MovimentoSaidaProdutoFilter();
	}
	
	public void pesquisar(){
		movimentosFiltrados = movimentoSaidaProdutos.filtradas(filtro);
			
	}
	
	public void pesquisarMovimentosAtivos(){
		movimentosFiltrados = movimentoSaidaProdutos.filtradasAtivo(filtro);
	}
				
	public void estornarMovimentoSaidaDeProduto(){
		try {
			
			movimentoSaidaProdutoSelecionado.setStatusMovimentoSaidaProduto(StatusMovimentoSaidaProduto.CANCELADO);
			movimentoSaidaProdutoSelecionado.setDataCancelamento(new Date());
			
			
			cadastroMovimentoSaidaProdutoService.recalcularNovoEstoqueCancelado(movimentoSaidaProdutoSelecionado);
			movimentosFiltrados.remove(movimentoSaidaProdutoSelecionado);

			FacesUtil.addInfoMessage("Cancelamento do Movimento Saída do produto: " + movimentoSaidaProdutoSelecionado.getProduto().getNome()
					+ ", salvo com sucesso!");
			
			
		} catch (Exception e) {
			
			FacesUtil.addErrorMessage("Ocorreu um erro ao tentar estornar o movimento! ");
			e.getMessage();
		}
	}
	
	public StatusMovimentoSaidaProduto[]getStatuses(){
		return StatusMovimentoSaidaProduto.values();
	}
	
	public MovimentoSaidaProdutoFilter getFiltro() {
		return filtro;
	}
	
	
	public List<MovimentoSaidaProduto> getMovimentosFiltrados() {
		return movimentosFiltrados;
	}
	
	public void setMovimentoSaidaProdutoSelecionado(
			MovimentoSaidaProduto movimentoSaidaProdutoSelecionado) {
		this.movimentoSaidaProdutoSelecionado = movimentoSaidaProdutoSelecionado;
	}
	
	public MovimentoSaidaProduto getMovimentoSaidaProdutoSelecionado() {
		return movimentoSaidaProdutoSelecionado;
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
		
}
