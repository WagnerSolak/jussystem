package com.jussystem.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.Processo;

public class Processos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public Processo porId(Long id) {
		return this.manager.find(Processo.class, id);
	}
	
	public Processo guardar(Processo processo){
		return manager.merge(processo);
	}
}
