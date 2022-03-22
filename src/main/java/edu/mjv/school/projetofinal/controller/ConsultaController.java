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

import edu.mjv.school.projetofinal.model.Consulta;
import edu.mjv.school.projetofinal.model.Medico;
import edu.mjv.school.projetofinal.model.Paciente;
import edu.mjv.school.projetofinal.model.Pessoa;
import edu.mjv.school.projetofinal.repository.ConsultaRepository;
import edu.mjv.school.projetofinal.repository.MedicoRepository;
import edu.mjv.school.projetofinal.repository.PacienteRepository;


@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	@Autowired()
	private ConsultaRepository repository;
	
	@PostMapping()
	public void gravar(@RequestBody Consulta consulta) {
		System.out.println("Gravando consulta");
		repository.save(consulta); 
	}	

	@PutMapping()
	public void alterar(@RequestBody Integer id, Consulta consulta) {
		System.out.println("Alterando consulta");
		System.out.println(consulta);
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		System.out.println("Excluindo dados");
		System.out.println("Id: " + id);

	}
	
	@GetMapping("/filtro")
	public List<Consulta> filtrar(@RequestParam("nm") String nome) {
		System.out.println("Listando pacientes pelo motivo " + nome);
		return null;
	}

	@GetMapping()
	public List<Consulta> listar() {
		System.out.println("Listando dados");
		return null;
		
	}

}
