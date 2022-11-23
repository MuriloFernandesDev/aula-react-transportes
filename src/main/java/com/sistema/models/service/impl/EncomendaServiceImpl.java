package com.sistema.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.models.model.Encomenda;
import com.sistema.models.repository.EncomendaRepository;
import com.sistema.models.service.EncomendaService;

@Service
public class EncomendaServiceImpl implements EncomendaService {
    
	@Autowired
	private EncomendaRepository encomendaRepository;
	
	@Override
	public Encomenda incluir(Encomenda encomenda) {
		return encomendaRepository.save(encomenda);
	}

	@Override
	public Encomenda alterar(Long id, Encomenda encomenda) {
	    
		Encomenda encomendaCadastrado = encomendaRepository.findById(id).get();

		encomendaCadastrado.setCidade(encomenda.getCidade());
		encomendaCadastrado.setCodEncomenda(encomenda.getCodEncomenda());
		encomendaCadastrado.setNomeEncomenda(encomenda.getNomeEncomenda());
	
		return encomendaRepository.save(encomendaCadastrado);
	}
	
	@Override
	public void excluir(Long id) {
		encomendaRepository.deleteById(id);
		
	}

	@Override
	public Encomenda consultarPorId(Long id) {
		return encomendaRepository.findById(id).get();
	}

	@Override
	public List<Encomenda> lista() {
		return encomendaRepository.findAll();
	}

	@Override
	public List<Encomenda> lista(String keyword) {
		return encomendaRepository.findAllByFields(keyword);
	}

	

}
