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
import com.sistema.models.model.Encomenda;
import com.sistema.models.service.CidadeService;
import com.sistema.models.service.EncomendaService;

@Controller
@RequestMapping(value = "/encomenda")
public class EncomendaController {

	@Autowired
	private EncomendaService encomendaService;
	
	@Autowired
	private CidadeService cidadeService;

//  ROTINAS DE INCLUSÃO
	
	@GetMapping(value="/cadastro")
	public String showFormIncluir(Model model) {
		Encomenda encomenda = new Encomenda();
		model.addAttribute("titulo", "Incluir Encomenda");
		model.addAttribute("encomenda", encomenda);
		return "/encomenda/incluir"; 
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(@Valid Encomenda encomenda, Model model) {
		 encomendaService.incluir(encomenda);
		 model.addAttribute("titulo", "Incluir Encomenda");
		 model.addAttribute("encomenda", new Encomenda());
		 return "/encomenda/incluir";
	}

// ROTINAS DE ALTERAÇÃO
	
	@GetMapping(value="/alterar/{id}")
	public String showFormAlterar(@PathVariable("id") Long id, Model model) {
		Encomenda encomenda = encomendaService.consultarPorId(id);
	
		model.addAttribute("titulo","Alterar Encomenda");
		model.addAttribute("encomenda", encomenda);
		return "/encomenda/alterar";
	}
	
	
	@PostMapping(value = "/alterar/{id}")
	public String alterar(@PathVariable("id") Long id, @Valid Encomenda encomenda, Model model) {
		encomendaService.alterar(id, encomenda);
		model.addAttribute("titulo", "Alterar Encomenda");
		model.addAttribute("encomenda", new Encomenda());
		return "/encomenda/alterar";
	}

// ROTINAS DE EXCLUSÃO
	
	@GetMapping(value = "/excluir/{id}")
	public String showFormExcluir(@PathVariable("id") Long id, Model model) {
		Encomenda encomenda = encomendaService.consultarPorId(id);
		model.addAttribute("titulo","Excluir Encomenda");
		model.addAttribute("encomenda", encomenda);
		return "/encomenda/excluir";
	}
	
	@PostMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		encomendaService.excluir(id);
		model.addAttribute("titulo", "Excluir Encomenda");
		model.addAttribute("encomenda", new Encomenda());
		return "/encomenda/excluir";
	}
	

// ROTINA DE CONSULTA	
	
	@GetMapping(value = "/consultar-por-id/{id}")
	public String consultarPorId(@PathVariable("id") Long id, Model model) {
		Encomenda encomenda = encomendaService.consultarPorId(id);
		model.addAttribute("titulo","Consultar Encomenda");
		model.addAttribute("encomenda", encomenda);
		return "/encomenda/consultar";
	}

	
	
	@GetMapping(value = "/lista")
	public String lista(
			@RequestParam(value="keyword", required = false ) String keyword,
			Model model) {
		
		List<Encomenda> encomendaes = new ArrayList<>();
		
		if (Objects.isNull(keyword)) {
			encomendaes = encomendaService.lista();
		} else {
			encomendaes = encomendaService.lista(keyword);
		}
		
		model.addAttribute("titulo","Listagem de Encomenda");
		model.addAttribute("encomendaes", encomendaes);
		return "/encomenda/lista";
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> listaCidade(){
		return cidadeService.lista();
	}
	

}
