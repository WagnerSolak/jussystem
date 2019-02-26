package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Estado;
import com.jussystem.repository.Estados;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter{
	
	private Estados estados;
	
	public EstadoConverter() {
		estados = CDIServiceLocator.getBean(Estados.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Estado retorno = null;
		
		if(value != null) {
			Long id = new Long(value);
			retorno = estados.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value !=null) {
			Estado estado = (Estado) value;
			return estado.getId() == null ? null : estado.getId().toString();
			
		}
		return "";
	}

}
