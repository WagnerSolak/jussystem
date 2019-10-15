package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Profissao;
import com.jussystem.repository.Profissoes;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Profissao.class)
public class ProfissaoConverter implements Converter{
	
	private Profissoes profissoes;
	
	public ProfissaoConverter(){
		profissoes = CDIServiceLocator.getBean(Profissoes.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Profissao retorno = null;
		if(value != null){
			Long id = new Long(value);
			retorno = profissoes.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			Profissao profissao = (Profissao) value;
			return profissao.getId() == null ? null : profissao.getId().toString();
		}
		return "";
	}

}
