package edu.mjv.school.projetofinal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer idPessoa;

	@Column(name = "nome_completo", nullable = false, length = 60)
	private String nomeCompleto;

	@Column(name = "nome_pai", nullable = false, length = 60)
	private String nomePai;

	@Column(name = "nome_mae", nullable = false, length = 60)
	private String nomeMae;

	@Column(name = "cpf", nullable = false, length = 11)
	private String CPF;

	@Column(name = "rg", nullable = false, length = 10)
	private String RG;

	@Column(nullable = false, length = 3)
	private int idade;

	@Column(nullable = true, length = 11)
	private String telefone;

	@Column(nullable = true, length = 30)
	private String email;

	@Column(name = "dt_inclusao", nullable = false)
	private Date dataInclusao;

	@Column(name = "dt_alteracao", nullable = true)
	private Date dataAlteracao;

	@Column(nullable = true)
	private List<Consulta> consultas;

	@Column(name = "id_medico", nullable = true)
	@JoinColumn(name = "tb_medico", referencedColumnName = "id_medico")
	private Medico medico;

	@Column(name = "id_paciente", nullable = true)
	@JoinColumn(name = "tb_paciente", referencedColumnName = "id_paciente")
	private Paciente paciente;

	// getters e setters

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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

}
