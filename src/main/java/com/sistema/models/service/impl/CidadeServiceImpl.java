package com.sistema.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.models.model.Cidade;
import com.sistema.models.repository.CidadeRepository;
import com.sistema.models.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
    
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public Cidade incluir(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public Cidade alterar(Long id, Cidade cidade) {
	    
		Cidade cidadeCadastrado = cidadeRepository.findById(id).get();

		cidadeCadastrado.setCodCidade(cidade.getCodCidade());
		cidadeCadastrado.setNomeCidade(cidade.getNomeCidade());
	
		return cidadeRepository.save(cidadeCadastrado);
	}
	
	@Override
	public void excluir(Long id) {
		cidadeRepository.deleteById(id);
		
	}

	@Override
	public Cidade consultarPorId(Long id) {
		return cidadeRepository.findById(id).get();
	}

	@Override
	public List<Cidade> lista() {
		return cidadeRepository.findAll();
	}

	@Override
	public List<Cidade> lista(String keyword) {
		return cidadeRepository.findAllByFields(keyword);
	}

	

}
