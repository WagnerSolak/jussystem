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

import com.jussystem.model.ProcessoPF;
import com.jussystem.model.StatusProcesso;
import com.jussystem.repository.ProcessosPF;
import com.jussystem.repository.filter.ProcessoPFFilter;

@Named
@ViewScoped
public class PesquisaProcessoPFBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessosPF processosPF;

	private ProcessoPF processoPF;

	private ProcessoPFFilter filtro;

	private List<ProcessoPF> processosPessoaFisicaFiltrados;

	public PesquisaProcessoPFBean() {
		filtro = new ProcessoPFFilter();
		processosPessoaFisicaFiltrados = new ArrayList<>();
	}

	public void pesquisar() {
		processosPessoaFisicaFiltrados = processosPF.filtrados(filtro);
	}

	public void pesquisarProcessoEmAberto() {

		processosPessoaFisicaFiltrados = processosPF.filtradosEmAberto(filtro);

	}

	public StatusProcesso[] getStatuses() {
		return StatusProcesso.values();
	}

	public void posProcessarXls(Object documento) {
		HSSFWorkbook planilha = (HSSFWorkbook) documento;
		HSSFSheet folha = planilha.getSheetAt(0);
		HSSFRow cabecalho = folha.getRow(0);
		HSSFCellStyle estiloCelula = planilha.createCellStyle();
		HSSFFont fonteCabecalho = planilha.createFont();

		fonteCabecalho.setColor(IndexedColors.WHITE.getIndex());
		fonteCabecalho.setBold(true);
		fonteCabecalho.setFontHeightInPoints((short) 12);

		estiloCelula.setFont(fonteCabecalho);
		estiloCelula.setFillForegroundColor(HSSFColor.BLUE.index);
		estiloCelula.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		for (int i = 0; i < cabecalho.getPhysicalNumberOfCells(); i++) {
			cabecalho.getCell(i).setCellStyle(estiloCelula);
		}

	}

	public ProcessoPFFilter getFiltro() {
		return filtro;
	}

	public List<ProcessoPF> getProcessosPessoaFisicaFiltrados() {
		return processosPessoaFisicaFiltrados;
	}

	public ProcessoPF getProcessoPF() {
		return processoPF;
	}

	public void setProcessoPF(ProcessoPF processoPF) {
		this.processoPF = processoPF;
	}

}
