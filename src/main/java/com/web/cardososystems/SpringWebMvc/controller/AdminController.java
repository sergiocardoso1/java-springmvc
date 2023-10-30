package com.web.cardososystems.SpringWebMvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.cardososystems.SpringWebMvc.model.Administrador;
import com.web.cardososystems.SpringWebMvc.repository.AdministradorRepository;


@Controller
public class AdminController {
	
	@Autowired
	private AdministradorRepository repository;
	
	@GetMapping("/administradores")
	public String index(Model model) {
		model.addAttribute("administradores", repository.findAll());
		return "administradores/index";
	}
	
	@GetMapping("/administradores/novo")
	public String novo() {
		return "administradores/novo";
	}

	@PostMapping("/administradores/criar")
	public String criar(Administrador administrador) {
		repository.save(administrador);
		return "redirect:/administradores";
	}
	
	@GetMapping("/administradores/{id}/excluir")
	public String excluir(@PathVariable Integer id, RedirectAttributes attr) {
		repository.deleteById(id);
		attr.addFlashAttribute("mensagem", "Admin excluído com sucesso.");
		return "redirect:/administradores";
	}
	
	@GetMapping("/administradores/{id}")
	public String buscar(@PathVariable Integer id, Model model) {
		Optional<Administrador> admin = repository.findById(id);
		try {
			model.addAttribute("administrador", admin);
		} catch (Exception e) {
			return "redirect:/administradores";
		}
		
		return "administradores/editar";
	}
	
	@PostMapping("/administradores/{id}/editar")
	public String editar(@PathVariable Integer id, Administrador administrador, RedirectAttributes attr) {
		if(repository.findById(id) != null) {
			repository.save(administrador);
			attr.addFlashAttribute("mensagem", "Admin editado com sucesso.");
		}
		
		return "redirect:/administradores";
	}
	

	
}
