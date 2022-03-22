package edu.mjv.school.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mjv.school.projetofinal.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {}
  