package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ClientePessoaFisica;
import com.jussystem.repository.ClientePessoaFisicas;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ClientePessoaFisica.class)
public class ClientePessoaFisicaConverter implements Converter {
	
	private ClientePessoaFisicas clientePessoaFisicas;

	public ClientePessoaFisicaConverter() {
		clientePessoaFisicas = CDIServiceLocator.getBean(ClientePessoaFisicas.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ClientePessoaFisica retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = clientePessoaFisicas.porId(id);

		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) value;
			return clientePessoaFisica.getId() == null ? null : clientePessoaFisica.getId().toString();
		}
		return "";
	}

}
