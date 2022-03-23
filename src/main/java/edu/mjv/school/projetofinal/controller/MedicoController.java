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

import edu.mjv.school.projetofinal.model.Medico;

import edu.mjv.school.projetofinal.repository.MedicoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/medicos")
public class MedicoController {
	@Autowired()
	private MedicoRepository repository;	
	
	@GetMapping("/{id}")
	public Medico getMedicoById(@PathVariable(value = "id") Integer id) {
		System.out.println("Buscando medico com ID: " + id);
		Medico medico = repository.findById(id).orElse(null);
		return medico;
	}

	@GetMapping("/listarPorCrm")
	public List<Medico> getByCrm(@RequestParam("crm") String crm) {
		System.out.println("Listando medicos pelo código CRM: " + crm);
		List<Medico> medicosEncontrados = repository.findByCodigoCRMContaining(crm);
		return medicosEncontrados;
	}

	@GetMapping("/listarPorNome")
	public List<Medico> getByName(@RequestParam("nome") String nome) {
		System.out.println("Listando medicos pelo nome: " + nome);
		List<Medico> medicosEncontrados = repository.findByPessoaNomeCompletoContaining(nome);
		return medicosEncontrados;
	}
	
	@GetMapping("/listarPorCpf")
	public List<Medico> getByCpf(@RequestParam("cpf") String cpf) {
		System.out.println("Listando medicos pelo CPF: " + cpf);
		List<Medico> medicosEncontrados = repository.findByPessoaCpfContaining(cpf);
		return medicosEncontrados;
	}
	
	@GetMapping("/listarPorEspecialidade")
	public List<Medico> getByEspecialidade(@RequestParam("especialidade") String especialidade) {
		System.out.println("Listando medicos pela Especialidade: " + especialidade);
		List<Medico> medicosEncontrados = repository.findByEspecialidadesTituloContaining(especialidade);
		return medicosEncontrados;
	}
	
	@GetMapping("/listarTodos")
	public List<Medico> getAllMedico() {
		List<Medico> todosMedicos = repository.findAll();
		for (Medico medico : todosMedicos) {
			System.out.println("ID: " + medico.getId() + "// Nome: " + medico.getPessoa().getNomeCompleto());
		}
		return todosMedicos;
	}
	
	@PostMapping()
	public void gravar(@RequestBody Medico medico) {
		System.out.println("Gravando medico");
		repository.save(medico);
	}

	@PutMapping(value = "/{id}")
	public void alterar(@PathVariable int id, @RequestBody Medico medico) {
		Medico medicoAtualizado = repository.findById(id).orElse(null);
		System.out.println("Alterando medico");
		medicoAtualizado.setCodigoCRM(medico.getCodigoCRM());
		medicoAtualizado.setPessoa(medico.getPessoa());
		medicoAtualizado.setEspecialidades(medico.getEspecialidades());

		repository.save(medicoAtualizado);
	}
	/*
	@PutMapping(value = "/{id}")
	public void alterar(@PathVariable int id, @RequestBody Medico medico) {
		Medico medicoAtualizado = repository.findById(id).orElse(null);
		medico = (Medico) PersistenceUtils.partialUpdate(medicoAtualizado, medico);
		System.out.println("Alterando medico");
		repository.save(medico);
	}
	*/

	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		Medico medicoPraSerDeletado = repository.findById(id).orElse(null);
		System.out.println(
				"Excluindo medico: " + medicoPraSerDeletado.getPessoa().getNomeCompleto() + "(ID: " + id + ")");
		repository.delete(medicoPraSerDeletado);
	}


}
