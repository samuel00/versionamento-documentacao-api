package br.com.sls.versionamentorhapi.configuracao;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import br.com.sls.versionamentorhapi.enums.Cargo;
import br.com.sls.versionamentorhapi.modelo.PessoaV2;
import br.com.sls.versionamentorhapi.respositorio.PessoaRepositorio;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@PropertySource("classpath:swagger.properties")
public class ConfiguracaoAplicacao {

	@Bean
	PessoaRepositorio repositorio() {
		PessoaRepositorio repository = new PessoaRepositorio();
		repository.add(new PessoaV2(1L, "Samuel Linhares Santana", Cargo.TERCEIRIZADO,
				LocalDate.parse("08/04/1987", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		repository.add(new PessoaV2(2L, "Yasmin Ynez", Cargo.AUDITOR,
				LocalDate.parse("12/06/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		repository.add(new PessoaV2(3L, "Rorion Fenomeno", Cargo.FISCAL,
				LocalDate.parse("20/10/1983", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		repository.add(new PessoaV2(4L, "Ernane Mora na Sefa", Cargo.COORDENADOR,
				LocalDate.parse("14/12/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		return repository;
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("pessoa-api-1.0").select()
				.apis(RequestHandlerSelectors.basePackage("br.com.sls.versionamentorhapi.rest"))
				.paths(regex("/pessoa/v1.*")).build().apiInfo(new ApiInfoBuilder().version("1.0").title("Pessoa API")
						.description("Documentação Pessoa API v1").build());
	}

	@Bean
	public Docket swaggerPersonApi11() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("pessoa-api-2.0").select()
				.apis(RequestHandlerSelectors.basePackage("br.com.sls.versionamentorhapi.rest"))
				.paths(regex("/pessoa/v2.*")).build().apiInfo(new ApiInfoBuilder().version("2.0").title("Pessoa API")
						.description("Documentação Pessoa API v2").build());
	}

	@Bean
	public Docket swaggerPersonApi12() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("pessoa-api-3.0").select()
				.apis(RequestHandlerSelectors.basePackage("br.com.sls.versionamentorhapi.rest"))
				.paths(regex("/pessoa/v3.*")).build().apiInfo(new ApiInfoBuilder().version("3.0").title("Pessoa API")
						.description(" Documentação Pessoa API v3").build());
	}

}
