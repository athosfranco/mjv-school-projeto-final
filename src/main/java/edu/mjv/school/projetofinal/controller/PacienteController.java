package edu.mjv.school.projetofinal.controller;

import java.time.LocalDateTime;
import java.util.List;

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

	@GetMapping("/{id}")
	public Paciente getPacienteById(@PathVariable(value = "id") Integer id) {
		System.out.println("Buscando paciente com ID: " + id);
		Paciente paciente = repository.findById(id).orElse(null);
		return paciente;
	}

	@GetMapping("/listarPorMatPlanoDeSaude")
	public List<Paciente> getByCrm(@RequestParam("matricula") String matricula) {
		System.out.println("Listando pacientes pelo código CRM: " + matricula);
		List<Paciente> pacientesEncontrados = repository.findByMatriculaPlanoDeSaudeContaining(matricula);
		return pacientesEncontrados;
	}

	@GetMapping("/listarPorNome")
	public List<Paciente> getByName(@RequestParam("nome") String nome) {
		System.out.println("Listando pacientes pelo nome: " + nome);
		List<Paciente> pacientesEncontrados = repository.findByPessoaNomeCompletoContaining(nome);
		return pacientesEncontrados;
	}
	
	@GetMapping("/listarPorCpf")
	public List<Paciente> getByCpf(@RequestParam("cpf") String cpf) {
		System.out.println("Listando pacientes pelo CPF: " + cpf);
		List<Paciente> pacientesEncontrados = repository.findByPessoaCpfContaining(cpf);
		return pacientesEncontrados;
	}
	
	
	@GetMapping("/listarTodos")
	public List<Paciente> getAllPaciente() {
		List<Paciente> todosPacientes = repository.findAll();
		for (Paciente paciente : todosPacientes) {
			System.out.println("ID: " + paciente.getId() + "// Nome: " + paciente.getPessoa().getNomeCompleto());
		}
		return todosPacientes;
	}
	
	@PostMapping()
	public void gravar(@RequestBody Paciente paciente) {
		System.out.println("Gravando paciente");
		repository.save(paciente);
	}

	@PutMapping(value = "/{id}")
	public void alterar(@PathVariable int id, @RequestBody Paciente paciente) {
		Paciente pacienteAtualizado = repository.findById(id).orElse(null);
		System.out.println("Alterando paciente");
		pacienteAtualizado.setMatriculaPlanoDeSaude(paciente.getMatriculaPlanoDeSaude());
		pacienteAtualizado.setPessoa(paciente.getPessoa());

		repository.save(pacienteAtualizado);
	}
	/*
	@PutMapping(value = "/{id}")
	public void alterar(@PathVariable int id, @RequestBody Paciente paciente) {
		Paciente pacienteAtualizado = repository.findById(id).orElse(null);
		paciente = (Paciente) PersistenceUtils.partialUpdate(pacienteAtualizado, paciente);
		System.out.println("Alterando paciente");
		repository.save(paciente);
	}
	*/

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		Paciente pacientePraSerDeletado = repository.findById(id).orElse(null);
		System.out.println(
				"Excluindo paciente: " + pacientePraSerDeletado.getPessoa().getNomeCompleto() + "(ID: " + id + ")");
		repository.delete(pacientePraSerDeletado);
	}



}
