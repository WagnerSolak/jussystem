package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.MotivoSaidaProduto;
import com.jussystem.repository.MotivoSaidaProdutos;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = MotivoSaidaProduto.class)
public class MotivoSaidaProdutoConverter implements Converter{
	
	private MotivoSaidaProdutos motivoSaidaProdutos;
	
	
	public MotivoSaidaProdutoConverter() {
		motivoSaidaProdutos = CDIServiceLocator.getBean(MotivoSaidaProdutos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		MotivoSaidaProduto retorno = null;
		if(value != null){
			retorno = this.motivoSaidaProdutos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			MotivoSaidaProduto motivoSaidaProduto = (MotivoSaidaProduto) value;
			return motivoSaidaProduto.getId() == null ? null : motivoSaidaProduto.getId().toString();
		}
		return "";
	}

}
