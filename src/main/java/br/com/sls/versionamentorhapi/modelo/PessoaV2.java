package br.com.sls.versionamentorhapi.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sls.versionamentorhapi.enums.Cargo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Pessoa")
public class PessoaV2 extends Pessoa{
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@ApiModelProperty(required = true)
	private LocalDate dataNascimento;
	
	public PessoaV2(){}
	
	public PessoaV2(Long id, String nome, Cargo cargo, LocalDate dataNascimento) {
		super(id,nome,cargo);
		this.dataNascimento = dataNascimento;		
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
}
