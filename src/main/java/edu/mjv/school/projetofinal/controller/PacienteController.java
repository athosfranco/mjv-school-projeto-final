package edu.mjv.school.projetofinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.model.Paciente;

import edu.mjv.school.projetofinal.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired()
	private PacienteRepository repository;

	@PostMapping()
	public void gravar(@RequestBody Paciente paciente) {
		System.out.println("Gravando paciente");
		repository.save(paciente);
	}

	@PutMapping("/alterarDadosPaciente/{id}")
	public void alterar(@PathVariable(value = "id") int id, @RequestBody Paciente pacienteNovo) {
		Optional<Paciente> pacienteAntigo = repository.findById(id);
		
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		System.out.println("Excluindo dados");
		System.out.println("Id: " + id);

	}

	@GetMapping("/filtro")
	public List<Paciente> filtrar(@RequestParam("nm") String nome) {
		System.out.println("Listando pacientes pelo motivo " + nome);
		return null;
	}

	@GetMapping("/{id}")
	public Paciente getPacienteById(@PathVariable(value = "id") Integer id) {
		System.out.println("Buscando paciente com ID: " + id);
		Paciente paciente = repository.findById(id).orElse(null);	
		return paciente;
	}

}
