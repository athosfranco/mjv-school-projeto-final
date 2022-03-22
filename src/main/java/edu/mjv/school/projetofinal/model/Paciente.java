package edu.mjv.school.projetofinal.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paciente_id")
	private Integer id;

	@Column(name = "matricula_PS", nullable = false, length = 10)
	private String matriculaPlanoDeSaude;

	@Embedded
	private Pessoa pessoa;

	@Column(name = "dt_inclusao", nullable = false)
	private LocalDate dataInclusao;

	@Column(name = "dt_alteracao", nullable = false)
	private LocalDate dataAlteracao;

	// ============================================
	// getters e setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
