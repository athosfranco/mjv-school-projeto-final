package edu.mjv.school.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_especialidade")
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_especialidade")
	private Integer idEspecialidade;
	
	@Column(nullable = false, length = 20)
	private String titulo;
	
	@Column(nullable = false)
	boolean ativo;

	//getters & setters
	public Integer getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(Integer idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

	
}
