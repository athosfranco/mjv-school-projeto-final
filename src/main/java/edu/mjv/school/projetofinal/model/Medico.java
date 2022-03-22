package edu.mjv.school.projetofinal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medico_id")
	private Integer id;

	@Embedded
	private Pessoa pessoa;

	@Column(nullable = false, length = 10)
	private String codigoCRM;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "medico_id")
	private List<Especialidade> especialidades;

	@Column(name = "dt_inclusao", nullable = false)
	private LocalDate dataInclusao;

	@Column(name = "dt_alteracao", nullable = true)
	private LocalDate dataAlteracao;

	// ============================================
	// getters e setters

	public String getCodigoCRM() {
		return codigoCRM;
	}

	public void setCodigoCRM(String codigoCRM) {
		this.codigoCRM = codigoCRM;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}	

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
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
