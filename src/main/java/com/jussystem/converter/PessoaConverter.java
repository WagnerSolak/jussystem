package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Pessoa;
import com.jussystem.repository.Pessoas;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{

	private Pessoas pessoas;
	
	public PessoaConverter() {
		this.pessoas = CDIServiceLocator.getBean(Pessoas.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		 
		if(value !=null) {
			retorno = this.pessoas.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value !=null) {
			return ((Pessoa) value).getId().toString();
		}
		return "";
	}

}
