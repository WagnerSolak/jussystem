package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Grupo;
import com.jussystem.repository.Grupos;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter("grupoConverter")
public class GrupoConverter implements Converter{

	private Grupos grupos;
	
	public GrupoConverter() {
		this.grupos = CDIServiceLocator.getBean(Grupos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;
		
		if(value !=null) {
			retorno = this.grupos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Grupo) value).getId().toString();
		}
		return null;
	}

}
