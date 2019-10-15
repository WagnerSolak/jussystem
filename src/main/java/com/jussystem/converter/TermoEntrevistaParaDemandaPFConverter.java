package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.TermoEntrevistaParaDemandaPF;
import com.jussystem.repository.TermoEntrevistaParaDemandasPF;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=TermoEntrevistaParaDemandaPF.class)
public class TermoEntrevistaParaDemandaPFConverter implements Converter{

	private TermoEntrevistaParaDemandasPF termoEntrevistaParaDemandasPF;
	
	public TermoEntrevistaParaDemandaPFConverter() {
		this.termoEntrevistaParaDemandasPF = CDIServiceLocator.getBean(TermoEntrevistaParaDemandasPF.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TermoEntrevistaParaDemandaPF retorno = null;
		 
		if(value != null) {
			retorno = this.termoEntrevistaParaDemandasPF.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			TermoEntrevistaParaDemandaPF termoEntrevistaParaDemandaPF = (TermoEntrevistaParaDemandaPF) value;
			return termoEntrevistaParaDemandaPF.getId() == null ? null : termoEntrevistaParaDemandaPF.getId().toString();
		}
		return "";
	}

}



