package br.com.sls.versionamentorhapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sls.versionamentorhapi.modelo.Pessoa;
import br.com.sls.versionamentorhapi.modelo.PessoaV2;
import br.com.sls.versionamentorhapi.modelo.PessoaV3;
import br.com.sls.versionamentorhapi.respositorio.PessoaRepositorio;
import br.com.sls.versionamentorhapi.util.PessoaUtil;

@RestController
@RequestMapping("/pessoa")
public class PessoaRecurso {
	
	@Autowired
	private PessoaRepositorio repositorio;
	
	@GetMapping({"/v1/{id}", "/{id}"})
	public Pessoa findPessoa(@PathVariable("id") Long id) {
		Pessoa pessoa = repositorio.findById(id);
		return pessoa;
	}
	
	@GetMapping({"/v2/{id}"})
	public PessoaV2 findPessoaV2(@PathVariable("id") Long id) {
		PessoaV2 pessoa = (PessoaV2) repositorio.findById(id);
		return pessoa;
	}
	
	@GetMapping({"/v3/{id}"})
	public PessoaV3 findPessoaV3(@PathVariable("id") Long id) {
		PessoaV3 pessoa = PessoaUtil.convertPessoa((PessoaV2) repositorio.findById(id));
		return pessoa;
	}

}
