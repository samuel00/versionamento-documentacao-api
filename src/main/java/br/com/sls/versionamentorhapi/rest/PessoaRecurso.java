package br.com.sls.versionamentorhapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sls.versionamentorhapi.modelo.Pessoa;
import br.com.sls.versionamentorhapi.modelo.PessoaV2;
import br.com.sls.versionamentorhapi.modelo.PessoaV3;
import br.com.sls.versionamentorhapi.respositorio.PessoaRepositorio;
import br.com.sls.versionamentorhapi.util.PessoaUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pessoa")
public class PessoaRecurso {
	
	@Autowired
	private PessoaRepositorio repositorio;
	
	@GetMapping({"/v1/{id}", "/{id}"})
	@Deprecated
	@ApiOperation(
	        value = "${operation.value.pessoa}",
	        notes = "${operation.note.find.pessoa}",
	        produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code=200,message= "OK", response=Pessoa.class),
		@ApiResponse(code = 500, message = "Internal server error")})
	public Pessoa findPessoa(@ApiParam(value="${param.pessoa.id}") @PathVariable("id") Long id) {
		Pessoa pessoa = new Pessoa(repositorio.findById(id));
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
	
	@PostMapping({"/v3"})
    public PessoaV3 add(@RequestBody PessoaV3 pessoa) {
		return PessoaUtil.convertPessoa((PessoaV2) repositorio.add(pessoa));
    }

}
