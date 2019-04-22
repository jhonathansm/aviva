package com.aviva.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	@NotNull
	private String login;
	@NotNull
	private String cargo;
	@NotNull
	private String senha;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String login, String cargo, String senha) {
		
		this.login = login;
		this.cargo = cargo;
		this.senha = senha;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
