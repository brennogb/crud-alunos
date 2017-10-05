package br.com.apisys.crudalunos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisys.crudalunos.model.Aluno;
import br.com.apisys.crudalunos.repository.AlunoRepository;
import br.com.apisys.crudalunos.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public List<Aluno> obterTodos() {
		return alunoRepository.findAll();
	}

	@Override
	public void salvarAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}

	@Override
	public Aluno obterPorId(Long id) {
		return alunoRepository.findOne(id);
	}

	@Override
	public void excluirAluno(Long id) {
		alunoRepository.delete(id);
	}
}
