package com.schmitt.projeto_jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.schmitt.projeto_jpa.dto.DepartamentoDto;
import com.schmitt.projeto_jpa.entity.DepartamentoEntity;
import com.schmitt.projeto_jpa.repo.DepartamentoRepo;

import jakarta.validation.Valid;

@Service
@Validated
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepo repositorio; 
	
	
	// CRUD
	
	// Create
	public void cadastrarDepartamento ( @Valid DepartamentoDto departamentoDto) {
		DepartamentoEntity departamentoEntity = new DepartamentoEntity();
		departamentoEntity.setNumeroDepartamento(departamentoDto.getNomeDepartamento());
		repositorio.save(departamentoEntity);
		
	}
	
	// Read
	public List<DepartamentoDto> listarDepartamentos (){
		List<DepartamentoEntity> listaDepartamentoEntity = repositorio.findAll();
		
		List<DepartamentoDto> listaDepartamentoDto = new ArrayList<DepartamentoDto>();
		
		for (DepartamentoEntity d : listaDepartamentoEntity) {
			
			DepartamentoDto departamentoDto = new DepartamentoDto();
			
			departamentoDto.setIdDepartamento(d.getIdDepartamento());
			departamentoDto.setNomeDepartamento(d.getNumeroDepartamento());
			
			listaDepartamentoDto.add(departamentoDto);
		}
		
		return listaDepartamentoDto;
		
	}
	
	
	// Update
	public void atualizarDepartamento (int id, @Valid DepartamentoDto departamentoDto) {
		
		// validacao de regra de negocio
		// repositorio.findById(id).orElseThrow(()-> new RuntimeException(" departamento nao existe"));
		// procura o id e caso ele nao encontre lanca uma execssao, a sintaxe precisa ser escrita dessa forma
		
		//DepartamentoEntity departamentoEntity = new DepartamentoEntity();
		
		// outra forma de fazer
		DepartamentoEntity departamentoEntity = repositorio.findById(id).orElseThrow(()-> new RuntimeException(" departamento nao existe"));
		// nao precisa ter esse set no id usando a forma acima. pq a PK é imutavel.
		//departamentoEntity.setIdDepartamento(id);
		departamentoEntity.setNumeroDepartamento(departamentoDto.getNomeDepartamento());
		
		repositorio.save(departamentoEntity);
		
	}
	
	
	// Delete
	
	public void deletarDepartamento (int id) {
		// validacao de regra de negocio
		// procura o id e caso ele nao encontre lanca uma execssao, a sintaxe precisa ser escrita dessa forma
		repositorio.findById(id).orElseThrow(()-> new RuntimeException("Departamento nao existe"));
		
		repositorio.deleteById(id);  

	}

	

}
