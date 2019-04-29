package com.aviva.repository;

import org.springframework.data.repository.CrudRepository;

import com.aviva.model.cadastrarVisitantes;

public interface VisitantesRepository extends CrudRepository<cadastrarVisitantes, String>{

	cadastrarVisitantes findById(long id);
	cadastrarVisitantes findByNome(String nome);
	cadastrarVisitantes findByEmail(String email);
}
