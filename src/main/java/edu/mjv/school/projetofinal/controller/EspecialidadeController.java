package edu.mjv.school.projetofinal.controller;

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

import edu.mjv.school.projetofinal.model.Especialidade;
import edu.mjv.school.projetofinal.model.Medico;
import edu.mjv.school.projetofinal.model.Paciente;
import edu.mjv.school.projetofinal.model.Pessoa;
import edu.mjv.school.projetofinal.repository.EspecialidadeRepository;
import edu.mjv.school.projetofinal.repository.MedicoRepository;
import edu.mjv.school.projetofinal.repository.PacienteRepository;


@RestController
@RequestMapping("/especialidade")
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
		System.out.println("Excluindo dados");
		System.out.println("Id: " + id);

	}
	
	@GetMapping("/filtro")
	public List<Especialidade> filtrar(@RequestParam("nm") String nome) {
		System.out.println("Listando especialidades: " + nome);
		return null;
	}

	@GetMapping("/listar")
	public List<Especialidade> listar() {
		System.out.println("Listando dados");
		return null;
		
	}

}
