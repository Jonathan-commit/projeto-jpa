package com.schmitt.projeto_jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity   // obrigatorio                      
@Table (name = "funcionario")   // obrigatorio descriscao conforme escrito na tabela do danco de dados
public class FuncionarioEntity {
	
	@Id  // obrigatorio
	@GeneratedValue (strategy = GenerationType.IDENTITY) // obrigatorio
	@Column (name = "id_funcionario") // opcional 
	private int idFuncionario;
	
	@Column (name = "nome") // opcional
	private String nome;
	
	@Column (name = "email") // opcional
	private String eMail;
	
	@Column (name = "senha") // opcional
	private String senha;
	
	@Column (name = "salario") // opcional
	private double salario;
	
	@ManyToOne // obrigatorio
	@JoinColumn (name = "id_departamento", referencedColumnName = "id_departamento") // obrigatorio referenciamento da foreign key
	private DepartamentoEntity departamento;
	
	
	public FuncionarioEntity(int idFuncionario, String nome, String eMail, String senha, double salario,
			DepartamentoEntity departamento) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.eMail = eMail;
		this.senha = senha;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	public FuncionarioEntity () {
		
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}
	
	
	
	
}