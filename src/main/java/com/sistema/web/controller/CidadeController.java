package com.sistema.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sistema.models.model.Cidade;
import com.sistema.models.service.CidadeService;

@Controller
@RequestMapping(value = "/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

//  ROTINAS DE INCLUSÃO
	
	@GetMapping(value="/cadastro")
	public String showFormIncluir(Model model) {
		Cidade cidade = new Cidade();
		model.addAttribute("titulo", "Incluir Cidade");
		model.addAttribute("cidade", cidade);
		return "/cidade/incluir"; 
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(@Valid Cidade cidade, Model model) {
		 cidadeService.incluir(cidade);
		 model.addAttribute("titulo", "Incluir Cidade");
		 model.addAttribute("cidade", new Cidade());
		 return "/cidade/incluir";
	}

// ROTINAS DE ALTERAÇÃO
	
	@GetMapping(value="/alterar/{id}")
	public String showFormAlterar(@PathVariable("id") Long id, Model model) {
		Cidade cidade = cidadeService.consultarPorId(id);
	
		model.addAttribute("titulo","Alterar Cidade");
		model.addAttribute("cidade", cidade);
		return "/cidade/alterar";
	}
	
	
	@PostMapping(value = "/alterar/{id}")
	public String alterar(@PathVariable("id") Long id, @Valid Cidade cidade, Model model) {
		cidadeService.alterar(id, cidade);
		model.addAttribute("titulo", "Alterar Cidade");
		model.addAttribute("cidade", new Cidade());
		return "/cidade/alterar";
	}

// ROTINAS DE EXCLUSÃO
	
	@GetMapping(value = "/excluir/{id}")
	public String showFormExcluir(@PathVariable("id") Long id, Model model) {
		Cidade cidade = cidadeService.consultarPorId(id);
		model.addAttribute("titulo","Excluir Cidade");
		model.addAttribute("cidade", cidade);
		return "/cidade/excluir";
	}
	
	@PostMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		cidadeService.excluir(id);
		model.addAttribute("titulo", "Excluir Cidade");
		model.addAttribute("cidade", new Cidade());
		return "/cidade/excluir";
	}
	

// ROTINA DE CONSULTA	
	
	@GetMapping(value = "/consultar-por-id/{id}")
	public String consultarPorId(@PathVariable("id") Long id, Model model) {
		Cidade cidade = cidadeService.consultarPorId(id);
		model.addAttribute("titulo","Consultar Cidade");
		model.addAttribute("cidade", cidade);
		return "/cidade/consultar";
	}

	
	
	@GetMapping(value = "/lista")
	public String lista(
			@RequestParam(value="keyword", required = false ) String keyword,
			Model model) {
		
		List<Cidade> cidade = new ArrayList<>();
		
		if (Objects.isNull(keyword)) {
			cidade = cidadeService.lista();
		} else {
			cidade = cidadeService.lista(keyword);
		}
		
		model.addAttribute("titulo","Listagem de Cidade");
		model.addAttribute("cidade", cidade);
		return "/cidade/lista";
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> listaCidade(){
		return cidadeService.lista();
	}

}
