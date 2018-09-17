package br.com.sls.versionamentorhapi.inicializador;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "br.com.sls.versionamentorhapi"} )
public class VersionamentoRhApiApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(VersionamentoRhApiApplication.class).web(true).run(args);
	}
}
