package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.Produto;
import com.jussystem.repository.Produtos;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{
	
	private Produtos produtos;
	
	public ProdutoConverter() {
		produtos = CDIServiceLocator.getBean(Produtos.class);
	}
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
     Produto retorno = null;
		
		if (value != null) {
			retorno = this.produtos.porId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = (Produto) value;
			return produto.getId() == null ? null : produto.getId().toString();
		}
		
		return "";
	}

}
