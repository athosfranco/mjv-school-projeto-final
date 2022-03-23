package edu.mjv.school.projetofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
	
	// Métodos de Pesquisa derivados (ou Derived Query Methods)
	
	List<Paciente> findByMatriculaPlanoDeSaudeContaining(String infix);

	List<Paciente> findByPessoaNomeCompletoContaining(String infix);
	
	List<Paciente> findByPessoaCpfContaining(String infix);
	
	List<Paciente> findByPessoaRgContaining(String infix);
	
}
  