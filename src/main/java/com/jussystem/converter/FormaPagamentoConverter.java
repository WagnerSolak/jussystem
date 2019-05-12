package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import com.jussystem.model.FormaPagamento;
import com.jussystem.repository.FormaPagamentos;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = FormaPagamento.class)
public class FormaPagamentoConverter implements Converter{
	
	
	private FormaPagamentos formaPagamentos;

	public FormaPagamentoConverter() {
		formaPagamentos = CDIServiceLocator.getBean(FormaPagamentos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		FormaPagamento retorno = null;
		
		if(value != null) {
			Long id = new Long(value);
			retorno = formaPagamentos.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			FormaPagamento formaPagamento = (FormaPagamento) value;
			return formaPagamento.getId() == null ? null : formaPagamento.getId().toString();
		}
		return "";
	}

}
