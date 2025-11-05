package com.schmitt.projeto_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schmitt.projeto_jpa.entity.DepartamentoEntity;

public interface DepartamentoRepo extends  JpaRepository<DepartamentoEntity, Integer>{ // integer significa o tipo de dado da primary key

}
