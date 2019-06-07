package com.jussystem.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.InativaPessoa;


public class InativaPessoas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public InativaPessoa guardar(InativaPessoa inativaPessoa) {
		return manager.merge(inativaPessoa);
	}
}
