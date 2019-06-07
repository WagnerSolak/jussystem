package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.DeclaracaoJusticaGratuita;
import com.jussystem.repository.DeclaracaoJusticaGratuitas;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=DeclaracaoJusticaGratuita.class)
public class DeclaracaoJusticaGratuitaConverter implements Converter{

	
	private DeclaracaoJusticaGratuitas declaracaoJusticaGratuitas;
	
	public DeclaracaoJusticaGratuitaConverter() {
		this.declaracaoJusticaGratuitas = CDIServiceLocator.getBean(DeclaracaoJusticaGratuitas.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DeclaracaoJusticaGratuita retorno = null;
		 
		if(value !=null) {
			retorno = this.declaracaoJusticaGratuitas.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value !=null) {
			DeclaracaoJusticaGratuita declaracaoJusticaGratuita = (DeclaracaoJusticaGratuita) value;
			return declaracaoJusticaGratuita != null && declaracaoJusticaGratuita.getId() != null ? declaracaoJusticaGratuita.getId().toString() : null;
		}
		return "";
	}

}

