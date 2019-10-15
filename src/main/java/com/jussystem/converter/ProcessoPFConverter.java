package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ProcessoPF;
import com.jussystem.repository.ProcessosPF;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ProcessoPF.class)
public class ProcessoPFConverter implements Converter {

	private ProcessosPF processos;

	public ProcessoPFConverter() {
		this.processos = CDIServiceLocator.getBean(ProcessosPF.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ProcessoPF retorno = null;

		if (value != null) {
			retorno = this.processos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			ProcessoPF processo = (ProcessoPF) value;
			return processo != null && processo.getId() != null ? processo.getId().toString() : null;
		}
		return "";
	}

}
