package edu.mjv.school.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private Integer idPaciente;

	@Column(name = "matricula_PS", nullable = false, length = 10)
	private String matriculaPlanoDeSaude;

	@Column(name = "id_pessoa", nullable = false)
	@JoinColumn(name = "tb_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa pessoa;

	@Column(nullable = false)
	boolean ativo;

	// getters and setters

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getMatriculaPlanoDeSaude() {
		return matriculaPlanoDeSaude;
	}

	public void setMatriculaPlanoDeSaude(String matriculaPlanoDeSaude) {
		this.matriculaPlanoDeSaude = matriculaPlanoDeSaude;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
