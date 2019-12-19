package com.jussystem.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jussystem.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpServletResponse response;
	
	private String email;
	
	
	public void login() throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.xhtml");
		
		System.out.println("dispatcher " +dispatcher);
		
		dispatcher.forward(request, response);
		
		System.out.println("Request "  +request);
		System.out.println("Response " +response);
		
		facesContext.responseComplete();
		
		
	}
	
	public void preRender() {
		if("true".equals(request.getParameter("invalid"))){
			
			System.out.println("Request do getParameter " +request);
			
			FacesUtil.addErrorMessage("Usuário ou senha inválidos!");
		}
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}
