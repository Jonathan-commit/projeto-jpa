package com.schmitt.projeto_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schmitt.projeto_jpa.entity.FuncionarioEntity;

public interface FuncionarioRepo extends JpaRepository<FuncionarioEntity, Integer> {

	boolean existsByEMail(String email); 
	// metodo usa camel case, mas aqui o atributo esta escrito "eMail" com M maiusculo, este M repete no metodo
	
	
	boolean existsByEMailAndIdFuncionarioNot(String email, int id);

}
