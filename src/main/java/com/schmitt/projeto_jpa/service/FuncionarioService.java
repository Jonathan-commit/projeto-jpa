package com.schmitt.projeto_jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.schmitt.projeto_jpa.dto.FuncionarioDto;
import com.schmitt.projeto_jpa.entity.DepartamentoEntity;
import com.schmitt.projeto_jpa.entity.FuncionarioEntity;
import com.schmitt.projeto_jpa.repo.DepartamentoRepo;
import com.schmitt.projeto_jpa.repo.FuncionarioRepo;

import jakarta.validation.Valid;

@Service
@Validated
public class FuncionarioService {
	@Autowired
	private FuncionarioRepo repositorioFuncionario;
	@Autowired
	private DepartamentoRepo repositorioDepartamento;
	
	// create
	public void cadastrarFuncionario (@Valid FuncionarioDto funcionarioDto) {
		
		if(repositorioFuncionario.existsByEMail(funcionarioDto.getEmail())) {
			throw new RuntimeException("Email já existe");
		}
		
		// optional usado para transformar um INT(integer) em uma Entity
		// Optional<DepartamentoEntity> departamento = repositorioDepartamento.findById(funcionarioDto.getDepartamento());
		
		// outra forma de fazer
		// validacao de regra de negocio
		DepartamentoEntity departamentoEntity = repositorioDepartamento.findById(funcionarioDto.getIdDepartamento())
				.orElseThrow(()-> new RuntimeException("Departamento nao existe"));
		
		
		FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
		
		funcionarioEntity.setNome(funcionarioDto.getNome());
		funcionarioEntity.seteMail(funcionarioDto.getEmail()); //
		funcionarioEntity.setSenha(funcionarioDto.getSenha());
		funcionarioEntity.setSalario(funcionarioDto.getSalario());
		// funcionarioEntity.setDepartamento(departamento.get()); // get nao precisa para a outra forma de fazer a avalidacao
		funcionarioEntity.setDepartamento(departamentoEntity);
		
		repositorioFuncionario.save(funcionarioEntity);
		
	}
	
	
	
	// Read
	
	public List<FuncionarioDto> listarFuncionarios (){
		
		
		List<FuncionarioEntity> listaFuncionarioEntity = repositorioFuncionario.findAll();
		
		List<FuncionarioDto> listaFuncionarioDto = new ArrayList<FuncionarioDto>();
		
		for (FuncionarioEntity f : listaFuncionarioEntity) {
			
			FuncionarioDto funcionarioDto = new FuncionarioDto();
			
			funcionarioDto.setIdFuncionario(f.getIdFuncionario());
			funcionarioDto.setNome(f.getNome());
			funcionarioDto.setEmail(f.geteMail());
			funcionarioDto.setSenha(f.getSenha());
			funcionarioDto.setSalario(f.getSalario());
			funcionarioDto.setIdDepartamento(f.getDepartamento().getIdDepartamento());
			
			listaFuncionarioDto.add(funcionarioDto);
		}
		
		return listaFuncionarioDto;
		
	}
	
	
	
	// update
	
        public void atualizarFuncionario (int id,@Valid FuncionarioDto funcionarioDto) {
        
        // Optional usado para transformar um INT(integer) em uma Entity
        // a heranca influencia na busca do parametro do atributo, dessa forma o Optional precisa referenciar sempre a tabeta "Pai"
        // tendo a forenkey vinculada, referencia a origem
        // Optional<DepartamentoEntity> departamento = repositorioDepartamento.findById(funcionarioDto.getDepartamento());
        //FuncionarioEntity funcionarioEntity = new FuncionarioEntity();	
        	
        	
        	// outra forma de fazer
    		// validacao de regra de negocio
        	FuncionarioEntity funcionarioEntity = repositorioFuncionario.findById(id)
        			.orElseThrow(()-> new RuntimeException("Funcionario nao existe"));
        	// outra forma de fazer
    		// validacao de regra de negocio
        	if(repositorioFuncionario.existsByEMailAndIdFuncionarioNot(funcionarioDto.getEmail(), id)) {
        		throw new RuntimeException("Email ja cadastrado");
        	} 			
        	// outra forma de fazer
    		// validacao de regra de negocio
        	DepartamentoEntity departamentoEntity = repositorioDepartamento.findById(funcionarioDto.getIdDepartamento())
    				.orElseThrow(()-> new RuntimeException("Departamento nao existe"));
		
		funcionarioEntity.setIdFuncionario(id);
		funcionarioEntity.setNome(funcionarioDto.getNome());
		funcionarioEntity.seteMail(funcionarioDto.getEmail());
		funcionarioEntity.setSenha(funcionarioDto.getSenha());
		funcionarioEntity.setSalario(funcionarioDto.getSalario());
		//funcionarioEntity.setDepartamento(departamento.get()); // pega o valor do Optional localizou
		funcionarioEntity.setDepartamento(departamentoEntity);  // nova forma de fazer com validacao
		repositorioFuncionario.save(funcionarioEntity);
		
	}
	
	
	// delete
        
	public void deletarFuncionario (int id) {
		// validacao de regra de negocio
		// procura o id e caso ele nao encontre lanca uma execssao, a sintaxe precisa ser escrita dessa forma
		repositorioFuncionario.findById(id)
		     .orElseThrow(()-> new RuntimeException("Funcionario nao existe"));
		
		repositorioFuncionario.deleteById(id);  

	}
	
	

}
