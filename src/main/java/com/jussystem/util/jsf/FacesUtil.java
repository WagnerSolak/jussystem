package com.jussystem.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	//toda ação na página após carregamento
	public static boolean isPostBack() {
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static boolean isNotPostBack() {
		return !isPostBack();
	}
	
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
}
