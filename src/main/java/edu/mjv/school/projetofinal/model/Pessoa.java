package edu.mjv.school.projetofinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Pessoa {

	@Column(name = "nome_completo", nullable = false, length = 60)
	private String nomeCompleto;

	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(nullable = false, length = 11)
	private String cpf;

	@Column(nullable = false, length = 10)
	private String rg;

	@Column(nullable = true, length = 11)
	private String telefone;

	@Column(nullable = true, length = 30)
	private String email;

	@Embedded
	private Endereco endereco;

	// ============================================
	// getters e setters

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
