package br.com.apisys.crudalunos.enums;

public enum StatusAluno {
	
	MATRICULADO(1, "Matrículado"),
	
	TRANCADO(2, "Trancado"), 
	
	JUBILADO(3, "Jubilado");
	
	private int codigo;
	private String descricao;
	
	StatusAluno(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
