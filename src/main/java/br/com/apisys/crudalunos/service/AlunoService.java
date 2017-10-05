package br.com.apisys.crudalunos.service;

import java.util.List;

import br.com.apisys.crudalunos.model.Aluno;

public interface AlunoService {
	
	List<Aluno> obterTodos();
	
	void salvarAluno(Aluno aluno);
	
	Aluno obterPorId(Long id);
	
	void excluirAluno(Long id);
}
