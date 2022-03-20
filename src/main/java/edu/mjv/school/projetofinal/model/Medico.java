package edu.mjv.school.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Integer idMedico;
	
	@Column(name = "codigo_crm", nullable = false, length = 10)
	private String codigoCRM;	
	
	@Column(name = "id_pessoa", nullable = false)
	@JoinColumn(name = "tb_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "especialidade", nullable = false)
	@JoinColumn(name = "tb_especialidade", referencedColumnName = "titulo")
	private Especialidade especialidade;
	
	@Column(nullable = false)
	boolean ativo;

	//getters e setters
	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getCodigoCRM() {
		return codigoCRM;
	}

	public void setCodigoCRM(String codigoCRM) {
		this.codigoCRM = codigoCRM;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	

}
