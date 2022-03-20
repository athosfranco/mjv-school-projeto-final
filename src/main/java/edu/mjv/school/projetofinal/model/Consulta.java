package edu.mjv.school.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_consulta")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Integer idConsulta;
	
	@Column(nullable = false, length = 255) 
	private String motivo;
	
	@Column(nullable = false, length = 255) 
	private String prescricao;
	
	@Column(name = "valor_consulta", nullable = false)
	private double valorConsulta;
	
	@Column(name = "dt_consulta", nullable = false)
	private Date dataConsulta;
	
	@Column(name = "dt_inclusao", nullable = false)
	private Date dataInclusao;

	@Column(name = "dt_alteracao", nullable = true)
	private Date dataAlteracao;
	
	@Column(name = "id_medico", nullable = true)
	@JoinColumn(name = "tb_medico", referencedColumnName = "id_medico")
	private Medico medico;

	@Column(name = "id_paciente", nullable = true)
	@JoinColumn(name = "tb_paciente", referencedColumnName = "id_paciente")
	private Paciente paciente;
	
	@Column(nullable = false)
	boolean ativo;
	
	//getters e setters

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

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	

}
