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
import com.sistema.models.model.Entregador;
import com.sistema.models.service.CidadeService;
import com.sistema.models.service.EntregadorService;

@Controller
@RequestMapping(value = "/entregador")
public class EntregadorController {

	@Autowired
	private EntregadorService entregadorService;
	
	@Autowired
	private CidadeService cidadeService;

//  ROTINAS DE INCLUSÃO
	
	@GetMapping(value="/cadastro")
	public String showFormIncluir(Model model) {
		Entregador entregador = new Entregador();
		model.addAttribute("titulo", "Incluir Entregador");
		model.addAttribute("entregador", entregador);
		return "/entregador/incluir"; 
	}
	
	@PostMapping(value = "/incluir")
	public String incluir(@Valid Entregador entregador, Model model) {
		 entregadorService.incluir(entregador);
		 model.addAttribute("titulo", "Incluir Entregador");
		 model.addAttribute("entregador", new Entregador());
		 return "/entregador/incluir";
	}

// ROTINAS DE ALTERAÇÃO
	
	@GetMapping(value="/alterar/{id}")
	public String showFormAlterar(@PathVariable("id") Long id, Model model) {
		Entregador entregador = entregadorService.consultarPorId(id);
	
		model.addAttribute("titulo","Alterar Entregador");
		model.addAttribute("entregador", entregador);
		return "/entregador/alterar";
	}
	
	
	@PostMapping(value = "/alterar/{id}")
	public String alterar(@PathVariable("id") Long id, @Valid Entregador entregador, Model model) {
		entregadorService.alterar(id, entregador);
		model.addAttribute("titulo", "Alterar Entregador");
		model.addAttribute("entregador", new Entregador());
		return "/entregador/alterar";
	}

// ROTINAS DE EXCLUSÃO
	
	@GetMapping(value = "/excluir/{id}")
	public String showFormExcluir(@PathVariable("id") Long id, Model model) {
		Entregador entregador = entregadorService.consultarPorId(id);
		model.addAttribute("titulo","Excluir Entregador");
		model.addAttribute("entregador", entregador);
		return "/entregador/excluir";
	}
	
	@PostMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		entregadorService.excluir(id);
		model.addAttribute("titulo", "Excluir Entregador");
		model.addAttribute("entregador", new Entregador());
		return "/entregador/excluir";
	}
	

// ROTINA DE CONSULTA	
	
	@GetMapping(value = "/consultar-por-id/{id}")
	public String consultarPorId(@PathVariable("id") Long id, Model model) {
		Entregador entregador = entregadorService.consultarPorId(id);
		model.addAttribute("titulo","Consultar Entregador");
		model.addAttribute("entregador", entregador);
		return "/entregador/consultar";
	}

	
	
	@GetMapping(value = "/lista")
	public String lista(
			@RequestParam(value="keyword", required = false ) String keyword,
			Model model) {
		
		List<Entregador> entregadores = new ArrayList<>();
		
		if (Objects.isNull(keyword)) {
			entregadores = entregadorService.lista();
		} else {
			entregadores = entregadorService.lista(keyword);
		}
		
		model.addAttribute("titulo","Listagem de Entregador");
		model.addAttribute("entregadores", entregadores);
		return "/entregador/lista";
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> listaCidade(){
		return cidadeService.lista();
	}
	

}
