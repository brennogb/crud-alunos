package br.com.apisys.crudalunos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.apisys.crudalunos.enums.StatusAluno;
import br.com.apisys.crudalunos.model.Aluno;
import br.com.apisys.crudalunos.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	
	@GetMapping("/new")
	public ModelAndView iniciarCadastroAluno() {
		ModelAndView modelAndView = new ModelAndView("novoAluno");
		modelAndView.addObject("aluno", new Aluno());
		modelAndView.addObject("listaStatus", StatusAluno.values());
		modelAndView.addObject("titulo", "Cadastro do Aluno");
		modelAndView.addObject("fieldBotao", "Cadastrar");
		return modelAndView;
	}
	
	@PostMapping("/save")
	public RedirectView salvar(@Valid Aluno aluno) {
		alunoService.salvarAluno(aluno);
		
		return new RedirectView("/alunos", true);
	}

	@GetMapping
	public ModelAndView obterTodosAlunos() {
		ModelAndView modelAndView = new ModelAndView("listaAlunos");
		modelAndView.addObject("alunos", alunoService.obterTodos());
		return modelAndView;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("novoAluno");
		modelAndView.addObject("aluno", alunoService.obterPorId(id));
		modelAndView.addObject("listaStatus", StatusAluno.values());
		modelAndView.addObject("titulo", "Editar Aluno");
		modelAndView.addObject("fieldBotao", "Alterar");
		return modelAndView;
	}
	
	@GetMapping("/remove/{id}")
	public RedirectView excluir(@PathVariable("id") Long id) {
		alunoService.excluirAluno(id);
		return new RedirectView("/alunos", true);
	}
}
