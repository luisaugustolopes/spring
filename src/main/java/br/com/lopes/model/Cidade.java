package br.com.lopes.model;

import java.util.List;

public class Cidade {
 

	private long id;
	 
	private String nome;
	
	private String estado;

	private List<Endereco> endereco;	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
 
