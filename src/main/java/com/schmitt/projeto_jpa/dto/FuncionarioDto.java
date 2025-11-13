package com.schmitt.projeto_jpa.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// abaixo uso do lombok para reduzir o codigo, substituindo metodos padroes.
@AllArgsConstructor // substitui o metodo public FuncionarioDto () normal super() e atributos
@NoArgsConstructor  // substitui o metodo public FuncionarioDto () construtor vazio
@Getter            // substitui os getters e setters
@Setter
@ToString          // substitui metodo ToString
public class FuncionarioDto {
	
	private int idFuncionario;
	@NotBlank (message = "Nome não pode ser vazio") 
	@Size     (max = 100, message = "Nome não pode ultrapassar 100 caracteres")
	private String nome;
	@NotBlank (message = "e-mail não pode ser vazio, inválido")
	@Email    (message = "e-mail inválido!")
	@Size     (max = 50, message = "Nome não pode ultrapassar 50 caracteres")
	private String email;
	@NotBlank (message = "Senha não pode ser vazio")
	@Size     (max = 50, message = "Nome não pode ultrapassar 50 caracteres")
	private String senha;
	@Positive (message = "Valor nao pode ser negativo")
	@Digits   (integer = 10, fraction = 2,  message = "valor inválido")
	private double salario;
	private int idDepartamento; // nao pode ser instanciado pelo danco de dados, por isso usa o int departamento
	
/*	
	public FuncionarioDto(int idFuncionario, String nome, String eMail, String senha, double salario,
			int idDepartamento) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.eMail = eMail;
		this.senha = senha;
		this.salario = salario;
		this.idDepartamento = idDepartamento;
	}
*/	
/*	
	public FuncionarioDto () {
		
	}
*/	
/*	
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
	public int getDepartamento() {
		return idDepartamento;
	}
    public void setDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
*/
/*
	@Override
	public String toString() {
		return "\nFuncionarioDto [idFuncionario=" + idFuncionario + ", nome=" + nome + ", eMail=" + eMail + ", senha="
				+ senha + ", salario=" + salario + ", departamento=" + idDepartamento + "]";
	}
*/	
	
	

}
