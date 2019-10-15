package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.CondicaoDePagamento;
import com.jussystem.repository.CondicaoDePagamentos;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = CondicaoDePagamento.class)
public class CondicaoDePagamentoConverter implements Converter{
	
	private CondicaoDePagamentos condicaoDePagamentos;
	
	public CondicaoDePagamentoConverter(){
		condicaoDePagamentos = CDIServiceLocator.getBean(CondicaoDePagamentos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		CondicaoDePagamento retorno = null;
		
		if(value != null){
			retorno = condicaoDePagamentos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			CondicaoDePagamento condicaoDePagamento = (CondicaoDePagamento) value;
			return condicaoDePagamento.getId() == null ? null : condicaoDePagamento.getId().toString();
		}
		return "";
	}

}
