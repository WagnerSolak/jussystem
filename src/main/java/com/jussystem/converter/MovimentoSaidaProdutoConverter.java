package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.MovimentoSaidaProduto;
import com.jussystem.repository.MovimentoSaidaProdutos;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = MovimentoSaidaProduto.class)
public class MovimentoSaidaProdutoConverter implements Converter{
	
	private MovimentoSaidaProdutos movimentoSaidaProdutos;
	
	public MovimentoSaidaProdutoConverter() {
		movimentoSaidaProdutos = CDIServiceLocator.getBean(MovimentoSaidaProdutos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		MovimentoSaidaProduto retorno = null;
		if(value != null){
			retorno = this.movimentoSaidaProdutos.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			MovimentoSaidaProduto movimentoSaidaProduto = (MovimentoSaidaProduto) value;
			return movimentoSaidaProduto.getId() == null ? null : movimentoSaidaProduto.getId().toString();
		}
		return "";
	}

}
