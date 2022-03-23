package edu.mjv.school.projetofinal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	private LocalDateTime dataInclusao;

	@Column(name = "dt_alteracao", nullable = true)
	private LocalDateTime dataAlteracao;

	@PrePersist
	protected void onCreate() {
		if (this.dataInclusao == null)
			this.dataInclusao = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.dataAlteracao = LocalDateTime.now();
	}

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

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
