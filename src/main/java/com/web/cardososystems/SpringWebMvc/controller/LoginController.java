package com.web.cardososystems.SpringWebMvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.cardososystems.SpringWebMvc.model.Administrador;
import com.web.cardososystems.SpringWebMvc.repository.AdministradorRepository;
import com.web.cardososystems.SpringWebMvc.service.CookieService;


@Controller
public class LoginController {
	
	@Autowired
	private AdministradorRepository repository;
	
	@GetMapping("/login")
	public String index() {
		return "login/index";
	}

	@PostMapping("/logar")
	public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws UnsupportedEncodingException {
		Administrador adm = repository.login(admParam.getEmail(), admParam.getSenha());
		if(adm != null) {
			int tempologado = (60*60);
			if(lembrar != null) {
				tempologado = (60*60*24);
			}
			CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()) ,tempologado);
			CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()) ,tempologado);
			return "redirect:/";
		}
		model.addAttribute("erro", "Usuário ou senha inválidos!");
		return "login/index";
	}
	
	@GetMapping("/sair")
	public String sair(HttpServletResponse response) throws UnsupportedEncodingException {
		CookieService.setCookie(response, "usuarioId", "" ,0);
		return "login/index";
	}

}
