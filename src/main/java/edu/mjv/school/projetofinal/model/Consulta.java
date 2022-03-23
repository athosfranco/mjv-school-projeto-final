package edu.mjv.school.projetofinal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Integer idConsulta;

	@ManyToOne
	@JoinColumn(name = "pac_id", referencedColumnName = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "med_id", referencedColumnName = "medico_id")
	private Medico medico;

	@Column(nullable = false, length = 255)
	private String motivo;

	@Column(nullable = false, length = 255)
	private String prescricao;

	@Column(name = "valor_consulta", nullable = false)
	private double valorConsulta;

	@Column(name = "dt_consulta", nullable = false)
	private LocalDate dataConsulta;

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

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
