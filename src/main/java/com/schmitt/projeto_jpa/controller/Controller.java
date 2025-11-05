package com.schmitt.projeto_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.schmitt.projeto_jpa.dto.DepartamentoDto;
import com.schmitt.projeto_jpa.dto.FuncionarioDto;
import com.schmitt.projeto_jpa.service.DepartamentoService;
import com.schmitt.projeto_jpa.service.FuncionarioService;



@Component
public class Controller implements CommandLineRunner {
	
	@Autowired
	private DepartamentoService departamentoServive;
	@Autowired
	private FuncionarioService funcionarioService;
	

	@Override
	public void run(String... args) throws Exception {
		
		DepartamentoDto departamentoDto = new DepartamentoDto();
		
		FuncionarioDto funcionarioDto = new FuncionarioDto();
		
		// cadastramento de departamentos
/*		departamentoDto.setNomeDepartamento("Vendas");
		departamentoServive.cadastrarDepartamento(departamentoDto);
*/		
		// exclusao de departamentos
		//departamentoServive.deletarDepartamento(3);  // numero 3 se refere ao id da coluna  linha 2 na tabela do banco de dados.

		// mostrando lista de departamentos cadastrados na tabela do banco de dados.
		 System.out.println(departamentoServive.listarDepartamentos());
		
		// atualizar departamento 
		// departamentoDto.setNomeDepartamento("Recursos Humanos"); // informacao nova
		// departamentoServive.atualizarDepartamento(2, departamentoDto); // atualiza a partir do id da service que vem da tabela danco dados.
		// como daria pra usar o trycatch aqui ????
		
		 
		// cadastramento de Funcionarios
		
/*		funcionarioDto.setNome("pedro");
		funcionarioDto.seteMail("exemplo@pedro.com");
		funcionarioDto.setSenha("5588");
		funcionarioDto.setSalario(2500);
		funcionarioDto.setDepartamento(4);
		
		 funcionarioService.cadastrarFuncionario(funcionarioDto);
		
*/		
		// deletar fucionario na tabela
		// funcionarioService.deletarFuncionario(3);  // numero 2 se refere ao id da coluna  linha 2 na tabela do banco de dados.
		
		 System.out.println(funcionarioService.listarFuncionarios());
		 
		 // atualizar funcionario na tabela      
		 funcionarioDto.setNome("Maria"); // informacao nova
		 funcionarioDto.seteMail("exemplo@maria.com"); // se repete todos os campos de atributos, mesmo mudando apenas um dos parametros
		 funcionarioDto.setSenha("1234"); // alterado
		 funcionarioDto.setSalario(5000);  // alterado
		 funcionarioDto.setDepartamento(4); // repete // 1 = departamento a qual pertence
	     funcionarioService.atualizarFuncionario(3, funcionarioDto); // 1 = id do funcionario, da tabela funcionario.
	     // atualiza a partir do id da service que vem da tabela danco dados.
		

		
		 System.out.println("hello world");
		 
		 
		 
		
	}

}
