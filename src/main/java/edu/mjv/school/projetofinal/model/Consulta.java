package edu.mjv.school.projetofinal.model;

import java.math.BigDecimal;
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
	private BigDecimal valorConsulta;

	@Column(name = "dt_consulta")
	private LocalDateTime dataConsulta;

	@Column(name = "dt_inclusao")
	private LocalDateTime dataInclusao;

	@Column(name = "dt_alteracao")
	private LocalDateTime dataAlteracao;
	
	@PrePersist
	protected void onCreate() {
		if (this.dataInclusao == null)
			this.dataInclusao = LocalDateTime.now();
		if (this.dataConsulta == null)
			this.dataConsulta = LocalDateTime.now();
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

	public BigDecimal getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(BigDecimal valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDateTime dataConsulta) {
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
