package br.com.apisys.crudalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apisys.crudalunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
