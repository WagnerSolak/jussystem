package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Cidade;
import com.jussystem.repository.Cidades;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter {

	/* @Inject(não tem como injetar em servicos */
	private Cidades cidades;

	public CidadeConverter() {
		cidades = CDIServiceLocator.getBean(Cidades.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cidade retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = cidades.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Cidade cidade = (Cidade) value;
			return cidade.getId() == null ? null : cidade.getId().toString();
		}
		return "";
	}

}
