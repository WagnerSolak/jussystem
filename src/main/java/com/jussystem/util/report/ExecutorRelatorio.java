package com.jussystem.util.report;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.jdbc.Work;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.PdfReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ExecutorRelatorio implements Work{
	
	private String caminhoRelatorio;
	private HttpServletResponse response;
	private Map<String, Object>parametros;
	private String nomeArquivoSaida;
	private boolean relatorioGerado;
			

	public ExecutorRelatorio(String caminhoRelatorio, HttpServletResponse response, Map<String, Object> parametros,
			String nomeArquivoSaida) {
		super();
		this.caminhoRelatorio = caminhoRelatorio;
		this.response = response;
		this.parametros = parametros;
		this.nomeArquivoSaida = nomeArquivoSaida;
	}



	@Override
	public void execute(Connection connection) throws SQLException {
		InputStream relatorioStream = this.getClass().getResourceAsStream(this.caminhoRelatorio);
		
		try {
			JasperPrint print = JasperFillManager.fillReport(relatorioStream, this.parametros, connection);
			// jasperPrint ja tem relatorio
			
		Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration, 
	    OutputStreamExporterOutput> exportador = new JRPdfExporter();
		exportador.setExporterInput(new SimpleExporterInput(print));
		exportador.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"" 
				+ this.nomeArquivoSaida  + "\"");
		
		exportador.exportReport();  //pega dados do print, gera pdf, e manda para outputStreamReponse
		} catch (Exception e) {
			throw new SQLException("Erro ao executar o relatório " +this.caminhoRelatorio, e);
		}
		
		
	}
	
	public boolean isRelatorioGerado() {
		return relatorioGerado;
	}

}
