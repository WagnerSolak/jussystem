package com.jussystem.validation;

import java.io.Serializable;

public class ValidationLetters implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static boolean validaCampo(String campo){
		boolean valido = true;
		campo = campo.replaceAll("[^a-zA-ZàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", "");
		if(!campo.substring(0).matches("[A-Za-zàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*")){
			valido = false;
		}
		return valido;
		
	}

}
