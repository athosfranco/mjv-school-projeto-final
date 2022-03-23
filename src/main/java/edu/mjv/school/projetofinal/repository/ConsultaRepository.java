package edu.mjv.school.projetofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Consulta;
import edu.mjv.school.projetofinal.model.Especialidade;
import edu.mjv.school.projetofinal.model.Medico;
import edu.mjv.school.projetofinal.model.Paciente;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
	
	List<Consulta> findByMedicoId(int id);
	
	List<Consulta> findByPacienteId(int id);
}
  