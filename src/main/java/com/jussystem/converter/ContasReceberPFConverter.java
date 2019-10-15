package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ContasReceberPF;
import com.jussystem.repository.ContasReceberPFRepository;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ContasReceberPF.class)
public class ContasReceberPFConverter implements Converter{
	
	private ContasReceberPFRepository contasReceberRepository;
	
	public ContasReceberPFConverter() {
		contasReceberRepository = CDIServiceLocator.getBean(ContasReceberPFRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ContasReceberPF retorno = null;
		
			if (value != null) {
				retorno = contasReceberRepository.porId(new Long(value));
			}
	
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			ContasReceberPF contasReceberPF = (ContasReceberPF) value;
			return contasReceberPF.getId() == null ? null :contasReceberPF.getId().toString();
		}
		return "";
	}

}
