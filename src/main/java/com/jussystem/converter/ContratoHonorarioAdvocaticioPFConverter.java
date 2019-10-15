package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ContratoHonorarioAdvocaticioPF;
import com.jussystem.repository.ContratoHonorarioAdvocaticiosPF;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ContratoHonorarioAdvocaticioPF.class)
public class ContratoHonorarioAdvocaticioPFConverter implements Converter{
	
	private ContratoHonorarioAdvocaticiosPF contratoHonorarioAdvocaticios;
	
	public ContratoHonorarioAdvocaticioPFConverter() {
		contratoHonorarioAdvocaticios = CDIServiceLocator.getBean(ContratoHonorarioAdvocaticiosPF.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ContratoHonorarioAdvocaticioPF retorno = null;
		
		if(value != null){
			retorno = this.contratoHonorarioAdvocaticios.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			ContratoHonorarioAdvocaticioPF contratoHonorarioAdvocaticioPF = (ContratoHonorarioAdvocaticioPF) value;
			return contratoHonorarioAdvocaticioPF.getId() == null ? null : contratoHonorarioAdvocaticioPF.getId().toString();
			
		}
		return "";
	}

}
