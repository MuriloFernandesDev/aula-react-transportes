package com.sistema.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.models.model.Entregador;
import com.sistema.models.repository.EntregadorRepository;
import com.sistema.models.service.EntregadorService;

@Service
public class EntregadorServiceImpl implements EntregadorService {
    
	@Autowired
	private EntregadorRepository entregadorRepository;
	
	@Override
	public Entregador incluir(Entregador entregador) {
		return entregadorRepository.save(entregador);
	}

	@Override
	public Entregador alterar(Long id, Entregador entregador) {
	    
		Entregador entregadorCadastrado = entregadorRepository.findById(id).get();

		entregadorCadastrado.setCidade(entregador.getCidade());
		entregadorCadastrado.setCodEntregador(entregador.getCodEntregador());
		entregadorCadastrado.setNomeEntregador(entregador.getNomeEntregador());
	
		return entregadorRepository.save(entregadorCadastrado);
	}
	
	@Override
	public void excluir(Long id) {
		entregadorRepository.deleteById(id);
		
	}

	@Override
	public Entregador consultarPorId(Long id) {
		return entregadorRepository.findById(id).get();
	}

	@Override
	public List<Entregador> lista() {
		return entregadorRepository.findAll();
	}

	@Override
	public List<Entregador> lista(String keyword) {
		return entregadorRepository.findAllByFields(keyword);
	}

	

}
