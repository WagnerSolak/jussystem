package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Cargo;
import com.jussystem.repository.Cargos;
import com.jussystem.util.cdi.CDIServiceLocator;



@FacesConverter(forClass = Cargo.class)
public class CargoConverter implements Converter {
	
	private Cargos cargos;
	
	public CargoConverter(){
		cargos = CDIServiceLocator.getBean(Cargos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cargo retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = cargos.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Cargo cargo = (Cargo) value;
			return cargo.getId() == null ? null : cargo.getId().toString();
		}
		return "";
	}
	
	
}
