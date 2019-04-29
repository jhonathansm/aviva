package com.aviva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class cadastrarVisitantes {

	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String nome;
	@NotNull
	private String telefone;
	@NotNull
	private String email;

	public cadastrarVisitantes() {

	}

	public cadastrarVisitantes(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
