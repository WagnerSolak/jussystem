package com.jussystem.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jussystem.model.Cidade;
import com.jussystem.model.Estado;
import com.jussystem.model.ProcuracaoAdJudicia;

public class ProcuracaoAdJudicias implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ProcuracaoAdJudicia guardar(ProcuracaoAdJudicia procuracaoAdJudicia) {
		return manager.merge(procuracaoAdJudicia);
	}
	


	public List<Cidade>buscarCidades(){
		return manager.createQuery("from Cidades", Cidade.class).getResultList();
	}
	
	
}
