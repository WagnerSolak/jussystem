package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ProcuracaoAdJudiciaPF;
import com.jussystem.repository.ProcuracaoAdJudiciasPF;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ProcuracaoAdJudiciaPF.class)
public class ProcuracaoAdJudiciaPFConverter implements Converter{

	
	private ProcuracaoAdJudiciasPF procuracaoAdJudicias;
	
	public ProcuracaoAdJudiciaPFConverter() {
		this.procuracaoAdJudicias = CDIServiceLocator.getBean(ProcuracaoAdJudiciasPF.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ProcuracaoAdJudiciaPF retorno = null;
		 
		if(value !=null) {
			retorno = this.procuracaoAdJudicias.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value !=null) {
			ProcuracaoAdJudiciaPF procuracaoAdJudicia = (ProcuracaoAdJudiciaPF) value;
			return procuracaoAdJudicia.getId() == null ? null : procuracaoAdJudicia.getId().toString();
		}
		return "";
	}

}

