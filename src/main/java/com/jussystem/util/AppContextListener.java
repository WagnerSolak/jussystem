package com.jussystem.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener{
//quando fizer deploy este metodo será chamado
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
		
	}

}
