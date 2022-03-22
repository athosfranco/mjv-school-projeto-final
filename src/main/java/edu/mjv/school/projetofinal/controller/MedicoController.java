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


import edu.mjv.school.projetofinal.model.Medico;
import edu.mjv.school.projetofinal.model.Paciente;
import edu.mjv.school.projetofinal.model.Pessoa;
import edu.mjv.school.projetofinal.repository.MedicoRepository;


@RestController
@RequestMapping("/medico")
public class MedicoController {
	@Autowired()
	private MedicoRepository repository;
	
	@PostMapping()
	public void gravar(@RequestBody Medico medico) {
		System.out.println("Gravando medico");
		repository.save(medico);
 
	}
	

	@PutMapping()
	public void alterar(@RequestBody Integer id, Medico medico) {
		System.out.println("Alterando medico");
		System.out.println(medico);

	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		System.out.println("Excluindo dados");
		System.out.println("Id: " + id);

	}
	
	@GetMapping("/filtro")
	public List<Pessoa> filtrar(@RequestParam("nm") String nome) {
		System.out.println("Listando medicos pelo motivo " + nome);
		return null;
	}

	
	@GetMapping("/{id}")
	public Medico getMedicoById(@PathVariable(value = "id") Integer id) {
		System.out.println("Buscando medico com ID: " + id);
		Medico medico = repository.findById(id).orElse(null);	
		return medico;
	}


}
