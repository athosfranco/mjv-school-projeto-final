package edu.mjv.school.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.model.Consulta;
import edu.mjv.school.projetofinal.model.Medico;
import edu.mjv.school.projetofinal.repository.ConsultaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	@Autowired()
	private ConsultaRepository repository;

	@PostMapping()
	public void gravar(@RequestBody Consulta consulta) {
		System.out.println("Gravando consulta");
		repository.save(consulta);
	}
	
	@GetMapping("/{id}")
	public Consulta getConsultaById(@PathVariable(value = "id") Integer id) {
		System.out.println("Buscando consulta com ID: " + id);
		Consulta consulta = repository.findById(id).orElse(null);
		return consulta;
	}

	@PutMapping(value = "/{id}")
	public void alterar(@PathVariable int id, @RequestBody Consulta consulta) {
		Consulta consultaAtualizada = repository.findById(id).orElse(null);
		System.out.println("Alterando consulta");
		consultaAtualizada.setMotivo(consulta.getMotivo());
		consultaAtualizada.setPrescricao(consulta.getPrescricao());
		consultaAtualizada.setMedico(consulta.getMedico());
		consultaAtualizada.setPaciente(consulta.getPaciente());
		consultaAtualizada.setValorConsulta(consulta.getValorConsulta());

		repository.save(consultaAtualizada);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		Consulta consultaDeletada = repository.findById(id).orElse(null);
		System.out.println(
				"Excluindo consulta");
		repository.delete(consultaDeletada);
	}

	@GetMapping("/listarTodos")
	public List<Consulta> getAllMedico() {
		List<Consulta> todasConsultas = repository.findAll();
		for (Consulta consulta : todasConsultas) {
			System.out.println("ID: " + consulta.getIdConsulta());
		}
		return todasConsultas;
	}

	@GetMapping("/listarPorMedico")
	public List<Consulta> getByMedico(@RequestParam("idMedico") int id) {
		System.out.println("Buscando todas as consultas realizadas pelo médico com o ID #" + id);
		List<Consulta> todasConsultas = repository.findByMedicoId(id);
		return todasConsultas;
	}

	@GetMapping("/listarPorPaciente")
	public List<Consulta> getByPaciente(@RequestParam("idPaciente") int id) {
		System.out.println("Buscando todas as consultas do paciente com o ID #" + id);
		List<Consulta> todasConsultas = repository.findByPacienteId(id);
		return todasConsultas;
	}

}
