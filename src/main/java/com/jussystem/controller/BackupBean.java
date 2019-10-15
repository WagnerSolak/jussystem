package com.jussystem.controller;

import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.jussystem.util.MySQLBackup;
import com.jussystem.util.jsf.FacesUtil;

@Named
@RequestScoped
public class BackupBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void fazerBackup(){
		try {
			MySQLBackup back = new MySQLBackup();
			
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro ao executar o backup!");
			e.getMessage();
		}
		
	}
}
