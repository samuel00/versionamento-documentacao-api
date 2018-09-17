package br.com.sls.versionamentorhapi.util;

import java.time.LocalDate;
import java.time.Period;

import br.com.sls.versionamentorhapi.modelo.PessoaV2;
import br.com.sls.versionamentorhapi.modelo.PessoaV3;

public class PessoaUtil {

	public static PessoaV3 convertPessoa(PessoaV2 pessoa) {
		Integer idade	= Period.between(pessoa.getDataNascimento(), LocalDate.now()).getYears();
		return new PessoaV3(pessoa.getId(), pessoa.getNome(), pessoa.getCargo(), idade);
	}

}
