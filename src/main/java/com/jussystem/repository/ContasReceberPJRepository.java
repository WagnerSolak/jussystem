package com.jussystem.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.ContasReceberPJ;

public class ContasReceberPJRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public ContasReceberPJ porId(Long id) {
		return manager.find(ContasReceberPJ.class, id);
	}
	
	public ContasReceberPJ guardar(ContasReceberPJ contasReceberPJ){
		return manager.merge(contasReceberPJ);
	}
}
