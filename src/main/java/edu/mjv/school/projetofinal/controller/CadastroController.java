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

import edu.mjv.school.projetofinal.model.Cadastro;
import edu.mjv.school.projetofinal.repository.CadastroRepository;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
	@Autowired()
	private CadastroRepository repository;
	
	@PostMapping()
	public void gravar(@RequestBody Cadastro cadastro) {
		System.out.println("Gravando registro");
		System.out.println("cadastro: " + cadastro.getNome());
		repository.save(cadastro);
 
	}
	@PutMapping()
	public void alterar(@RequestBody Integer id, Cadastro cadastro) {
		System.out.println("Alterando registros");
		System.out.println(cadastro);

	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		System.out.println("Excluindo dados");
		System.out.println("Id: " + id);

	}
	
	@GetMapping("/filtro")
	public List<Cadastro> filtrar(@RequestParam("nm") String nome) {
		System.out.println("Listando cadastros pelo nome " + nome);
		return null;
	}

	@GetMapping()
	public List<Cadastro> listar() {
		System.out.println("Listando dados");
		return null;
		
	}
}
