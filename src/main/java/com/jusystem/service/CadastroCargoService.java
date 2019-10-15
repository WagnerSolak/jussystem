package com.jusystem.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jussystem.model.Cargo;
import com.jussystem.repository.Cargos;
import com.jussystem.util.jpa.Transactional;

public class CadastroCargoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cargos cargos;
	
	@Transactional
	public Cargo salvar(Cargo cargo) {
		Cargo cargoExistente = cargos.porNomeDoCargo(cargo.getCargoEmpresa());
		
		if(cargoExistente != null && !cargoExistente.equals(cargo) ) {
			throw new NegocioException("Já existe um cargo com a descrição informada!");
		}
		return cargos.guardar(cargo);
	}
}
