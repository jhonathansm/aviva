package com.aviva.repository;

import org.springframework.data.repository.CrudRepository;

import com.aviva.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findById(long id);
	Usuario findByLogin(String login);

}
