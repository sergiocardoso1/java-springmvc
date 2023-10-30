package com.web.cardososystems.SpringWebMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.cardososystems.SpringWebMvc.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{

	@Query(value = "SELECT * FROM administradores WHERE email = :email AND senha = :senha", nativeQuery = true)
	public Administrador login(String email, String senha);
}
