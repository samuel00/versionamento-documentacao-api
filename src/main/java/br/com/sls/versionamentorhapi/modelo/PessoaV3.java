package br.com.sls.versionamentorhapi.modelo;

import br.com.sls.versionamentorhapi.enums.Cargo;
import io.swagger.annotations.ApiModel;

@ApiModel("Pessoa")
public class PessoaV3 extends Pessoa{
	
	private Integer idade;
	
	public PessoaV3(Long id, String nome, Cargo cargo, Integer idade) {
		super(id,nome,cargo);
		this.idade = idade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
