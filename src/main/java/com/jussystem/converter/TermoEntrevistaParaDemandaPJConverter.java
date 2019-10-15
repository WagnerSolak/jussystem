package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.TermoEntrevistaParaDemandaPJ;
import com.jussystem.repository.TermoEntrevistaParaDemandasPJ;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = TermoEntrevistaParaDemandaPJ.class)
public class TermoEntrevistaParaDemandaPJConverter implements Converter {

	private TermoEntrevistaParaDemandasPJ termoEntrevistaParaDemandasPJ;

	public TermoEntrevistaParaDemandaPJConverter() {
		this.termoEntrevistaParaDemandasPJ = CDIServiceLocator
				.getBean(TermoEntrevistaParaDemandasPJ.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TermoEntrevistaParaDemandaPJ retorno = null;
		if(value != null){
			retorno = this.termoEntrevistaParaDemandasPJ.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			TermoEntrevistaParaDemandaPJ termoEntrevistaParaDemandaPJ = (TermoEntrevistaParaDemandaPJ) value;
			return termoEntrevistaParaDemandaPJ.getId() == null ? null : termoEntrevistaParaDemandaPJ.getId().toString();
		}
		return "";
	}

}
