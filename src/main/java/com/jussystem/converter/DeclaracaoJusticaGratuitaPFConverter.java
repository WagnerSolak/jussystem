package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.DeclaracaoJusticaGratuitaPF;
import com.jussystem.repository.DeclaracaoJusticaGratuitasPF;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=DeclaracaoJusticaGratuitaPF.class)
public class DeclaracaoJusticaGratuitaPFConverter implements Converter{

	
	private DeclaracaoJusticaGratuitasPF declaracaoJusticaGratuitas;
	
	public DeclaracaoJusticaGratuitaPFConverter() {
		this.declaracaoJusticaGratuitas = CDIServiceLocator.getBean(DeclaracaoJusticaGratuitasPF.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DeclaracaoJusticaGratuitaPF retorno = null;
		 
		if(value != null) {
			retorno = this.declaracaoJusticaGratuitas.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			DeclaracaoJusticaGratuitaPF declaracaoJusticaGratuita = (DeclaracaoJusticaGratuitaPF) value;
			return declaracaoJusticaGratuita.getId() == null  ? null : declaracaoJusticaGratuita.getId().toString();
		}
		return "";
	}

}

