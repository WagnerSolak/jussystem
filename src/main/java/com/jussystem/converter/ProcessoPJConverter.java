package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ProcessoPJ;
import com.jussystem.repository.ProcessosPJ;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ProcessoPJ.class)
public class ProcessoPJConverter implements Converter {

	private ProcessosPJ processos;

	public ProcessoPJConverter() {
		this.processos = CDIServiceLocator.getBean(ProcessosPJ.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ProcessoPJ retorno = null;

		if (value != null) {
			retorno = this.processos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			ProcessoPJ processo = (ProcessoPJ) value;
			return processo != null && processo.getId() != null ? processo.getId().toString() : null;
		}
		return "";
	}

}

