package com.jussystem.controller;



import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.jussystem.model.Usuario;
import com.jussystem.repository.Pedidos;
import com.jussystem.security.UsuarioLogado;
import com.jussystem.security.UsuarioSistema;

@Named
@RequestScoped
public class GraficoPedidosCriadosBean {
	
	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM");
	
	@Inject
	private Pedidos pedidos;
	
	@Inject
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;
	
	private CartesianChartModel model;
	
	public void preRender() {
		this.model = new CartesianChartModel();
		
		adicionarSerie("Todos os pedidos", null);
		adicionarSerie("Meus pedidos", usuarioLogado.getUsuario());
	}
	
	private void adicionarSerie(String rotulo, Usuario criadoPor) {
		
		Map<Date, BigDecimal>valoresPorData = this.pedidos.valoresTotaisPorData(10, criadoPor);
		
		ChartSeries series = new ChartSeries(rotulo);
		
		for(Date data : valoresPorData.keySet()) {
			series.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}
		/*series.set("1", Math.random() * 1000);
		series.set("2", Math.random() * 1000);
		series.set("3", Math.random() * 1000);
		series.set("4", Math.random() * 1000);
		series.set("5", Math.random() * 1000); para grafico aleatorio*/
		
		this.model.addSeries(series);
	}

	public CartesianChartModel getModel() {
		return model;
	}
}
