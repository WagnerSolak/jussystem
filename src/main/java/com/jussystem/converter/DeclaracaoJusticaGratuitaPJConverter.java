package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.DeclaracaoJusticaGratuitaPJ;
import com.jussystem.repository.DeclaracaoJusticaGratuitasPJ;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = DeclaracaoJusticaGratuitaPJ.class)
public class DeclaracaoJusticaGratuitaPJConverter implements Converter{
	
	private DeclaracaoJusticaGratuitasPJ declaracaoJusticaGratuitasPJ;
	
	public DeclaracaoJusticaGratuitaPJConverter() {
		declaracaoJusticaGratuitasPJ = CDIServiceLocator.getBean(DeclaracaoJusticaGratuitasPJ.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DeclaracaoJusticaGratuitaPJ retorno = null;
		if(value != null){
			retorno = declaracaoJusticaGratuitasPJ.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			DeclaracaoJusticaGratuitaPJ declaracaoJusticaGratuitaPJ = (DeclaracaoJusticaGratuitaPJ) value;
			return  declaracaoJusticaGratuitaPJ.getId() == null ? null : declaracaoJusticaGratuitaPJ.getId().toString();
		}
		return "";
	}

}
