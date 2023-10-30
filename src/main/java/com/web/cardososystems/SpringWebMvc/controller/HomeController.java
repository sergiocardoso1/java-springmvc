package com.web.cardososystems.SpringWebMvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.cardososystems.SpringWebMvc.service.CookieService;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		
		model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
		return "home/index";
	}

}
