package br.com.sls.versionamentorhapi.modelo;

import br.com.sls.versionamentorhapi.enums.Cargo;

public class Pessoa {
	
	private Long id;
	
	private String nome;
	
	private Cargo cargo;
	
	public Pessoa() {}
	
	public Pessoa(Long id, String nome, Cargo cargo){
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	

}
