package br.com.sls.versionamentorhapi.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sls.versionamentorhapi.enums.Cargo;
import io.swagger.annotations.ApiModelProperty;

public class Pessoa {
	
	@JsonIgnore
	private Long id;
	
	@ApiModelProperty(required = true)
	private String nome;
	
	@ApiModelProperty(required = true)
	private Cargo cargo;
	
	public Pessoa() {}
	
	public Pessoa(Long id, String nome, Cargo cargo){
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
	}

	public Pessoa(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cargo = pessoa.getCargo();
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
