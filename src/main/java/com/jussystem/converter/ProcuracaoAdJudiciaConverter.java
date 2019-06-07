package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ProcuracaoAdJudicia;
import com.jussystem.repository.ProcuracaoAdJudicias;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ProcuracaoAdJudicia.class)
public class ProcuracaoAdJudiciaConverter implements Converter{

	
	private ProcuracaoAdJudicias procuracaoAdJudicias;
	
	public ProcuracaoAdJudiciaConverter() {
		this.procuracaoAdJudicias = CDIServiceLocator.getBean(ProcuracaoAdJudicias.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ProcuracaoAdJudicia retorno = null;
		 
		if(value !=null) {
			retorno = this.procuracaoAdJudicias.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value !=null) {
			ProcuracaoAdJudicia procuracaoAdJudicia = (ProcuracaoAdJudicia) value;
			return procuracaoAdJudicia != null && procuracaoAdJudicia.getId() != null ? procuracaoAdJudicia.getId().toString() : null;
		}
		return "";
	}

}

