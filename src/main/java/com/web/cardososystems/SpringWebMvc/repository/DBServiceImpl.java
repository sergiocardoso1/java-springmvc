package com.web.cardososystems.SpringWebMvc.repository;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.web.cardososystems.SpringWebMvc.model.Administrador;

@Service
@Component
public class DBServiceImpl {

	@Autowired
	private AdministradorRepository administradorRepository;


	public void instantiateTestDatabase() throws ParseException {

		Administrador adm = new Administrador(null, "Sérgio", "sergiocardosodeveloper@gmail.com", "12312321321");
		administradorRepository.save(adm);
	}

}
