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
import org.springframework.web.bind.annotation.RestController;

import edu.mjv.school.projetofinal.model.Especialidade;

import edu.mjv.school.projetofinal.repository.EspecialidadeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {
	@Autowired()
	private EspecialidadeRepository repository;

	@PostMapping()
	public void gravar(@RequestBody Especialidade especialidade) {
		System.out.println("Gravando especialidade: " + especialidade.getTitulo());
		repository.save(especialidade);
	}

	@PutMapping()
	public void alterar(@RequestBody Integer id, Especialidade especialidade) {
		System.out.println("Alterando especialidade");
		System.out.println(especialidade);
	}

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		Especialidade espPraSerDeletada = repository.findById(id).orElse(null);
		System.out.println("Excluindo especialidade: " + espPraSerDeletada.getTitulo() + "(ID: " + id + ")");
		repository.delete(espPraSerDeletada);
	}

	@GetMapping("/listarTodos")
	public List<Especialidade> getAllEspecialidade() {
		List<Especialidade> todasEspecialidades = repository.findAll();
		for (Especialidade especialidade : todasEspecialidades) {
			System.out.println("ID: " + especialidade.getId());
		}
		return todasEspecialidades;
	}
}
