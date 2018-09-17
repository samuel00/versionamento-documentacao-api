package br.com.sls.versionamentorhapi.respositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sls.versionamentorhapi.modelo.Pessoa;

public class PessoaRepositorio {
	
	private List<Pessoa> listaPessoa = new ArrayList<>();
	
	public Pessoa add(Pessoa pessoa) {
		pessoa.setId((long) (listaPessoa.size()+1));
		listaPessoa.add(pessoa);
		return pessoa;
	}
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> pessoa = listaPessoa.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (pessoa.isPresent())
			return pessoa.get();
		else
			return null;
	}

}
