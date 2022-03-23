package edu.mjv.school.projetofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

	// Métodos de Pesquisa derivados (ou Derived Query Methods)
	
	List<Medico> findByCodigoCRMContaining(String infix);

	List<Medico> findByPessoaNomeCompletoContaining(String infix);
	
	List<Medico> findByPessoaCpfContaining(String infix);
	
	List<Medico> findByPessoaRgContaining(String infix);
	
	List<Medico> findByEspecialidadesTituloContaining(String infix);

}
