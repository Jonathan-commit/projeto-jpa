package com.schmitt.projeto_jpa.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity  // obrigatorio
@Table (name = "departamento")  // obrigatorio descriscao conforme escrito na tabela do danco de dados
public class DepartamentoEntity {
	
	@Id  // obrigatorio
	@GeneratedValue (strategy = GenerationType.IDENTITY)  // obrigatorio por ser auto incremento no banco de dados
	@Column (name = "id_departamento")  // opcional
	private int idDepartamento;
	@Column (name = "nome_Departamento")  // opcional
	private String nomeDepartamento;
	
	
	
	public DepartamentoEntity(int idDepartamento, String nomeDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.nomeDepartamento = nomeDepartamento;
	}

	public DepartamentoEntity () {  // construtor vazio, o jpa precisa para mapeamento
		
	}


	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNumeroDepartamento() {
		return nomeDepartamento;
	}

	public void setNumeroDepartamento(String numeroDepartamento) {
		this.nomeDepartamento = numeroDepartamento;
	}
	
	

}
