package com.schmitt.projeto_jpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DepartamentoDto {
	
		private int idDepartamento;
	    @NotBlank (message = "Nome não pode ser vazio")
	    @Size (max = 50, message = "Nome não pode ultrapassar 50 caracteres")
		private String nomeDepartamento;
/*
		public DepartamentoDto(int idDepartamento, String nomeDepartamento) {
			super();
			this.idDepartamento = idDepartamento;
			this.nomeDepartamento = nomeDepartamento;
		}
*/
/*
		public DepartamentoDto () {  // conversor vazio
			
		}
*/
/*
		public int getIdDepartamento() {
			return idDepartamento;
		}

		public void setIdDepartamento(int idDepartamento) {
			this.idDepartamento = idDepartamento;
		}

		public String getNomeDepartamento() {
			return nomeDepartamento;
		}

		public void setNomeDepartamento(String nomeDepartamento) {
			this.nomeDepartamento = nomeDepartamento;
		}
*/
/*
		@Override
		public String toString() {
			return "\nDepartamentoDto [idDepartamento=" + idDepartamento + ", nomeDepartamento=" + nomeDepartamento + "]";
		}
*/				

}
