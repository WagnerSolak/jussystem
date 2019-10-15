package com.jussystem.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jussystem.model.ProcuracaoAdJudiciaPJ;
import com.jussystem.repository.ProcuracaoAdJudiciasPJ;
import com.jussystem.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ProcuracaoAdJudiciaPJ.class)
public class ProcuracaoAdJudiciaPJConverter implements Converter{

	private ProcuracaoAdJudiciasPJ procuracaoAdJudicias;
	
	public ProcuracaoAdJudiciaPJConverter() {
		this.procuracaoAdJudicias = CDIServiceLocator.getBean(ProcuracaoAdJudiciasPJ.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ProcuracaoAdJudiciaPJ retorno = null;
		
		if(value != null){
			retorno = this.procuracaoAdJudicias.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			ProcuracaoAdJudiciaPJ procuracaoAdJudiciaPJ = (ProcuracaoAdJudiciaPJ) value;
			return procuracaoAdJudiciaPJ.getId() == null ? null : procuracaoAdJudiciaPJ.getId().toString();
		}
		return null;
	}

}
