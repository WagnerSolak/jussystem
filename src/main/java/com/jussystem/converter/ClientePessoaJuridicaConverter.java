package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ClientePessoaJuridica;
import com.jussystem.repository.ClientePessoaJuridicas;
import com.jussystem.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = ClientePessoaJuridica.class)
public class ClientePessoaJuridicaConverter implements Converter {
	
	private ClientePessoaJuridicas clientePessoaJuridicas;

	public ClientePessoaJuridicaConverter() {
		clientePessoaJuridicas = CDIServiceLocator.getBean(ClientePessoaJuridicas.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		ClientePessoaJuridica retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = clientePessoaJuridicas.porId(id);

		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			ClientePessoaJuridica clientePessoaJuridica = (ClientePessoaJuridica) value;
			return clientePessoaJuridica.getId() == null ? null : clientePessoaJuridica.getId().toString();
		}
		return "";
	}

}


