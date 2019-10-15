package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ContratoHonorarioAdvocaticioPJ;
import com.jussystem.repository.ContratoHonorarioAdvocaticiosPJ;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ContratoHonorarioAdvocaticioPJ.class)
public class ContratoHonorarioAdvocaticioPJConverter implements Converter{

	private ContratoHonorarioAdvocaticiosPJ contratoHonorarioAdvocaticios;
	
	public ContratoHonorarioAdvocaticioPJConverter() {
		contratoHonorarioAdvocaticios = CDIServiceLocator.getBean(ContratoHonorarioAdvocaticiosPJ.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ContratoHonorarioAdvocaticioPJ retorno = null;
		
		if(value != null){
			retorno = this.contratoHonorarioAdvocaticios.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			ContratoHonorarioAdvocaticioPJ contratoHonorarioAdvocaticioPJ = (ContratoHonorarioAdvocaticioPJ) value;
			return contratoHonorarioAdvocaticioPJ.getId() == null ? null : contratoHonorarioAdvocaticioPJ.getId().toString();
		}
		return "";
	}
}
