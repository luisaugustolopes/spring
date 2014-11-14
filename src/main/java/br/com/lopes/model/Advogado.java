package br.com.lopes.model;

import java.util.List;


public class Advogado {
 
	protected long id;
	
	private String numeroOAB;
	
	private PessoaFisica fisica;
	
	private List<ProcessoJuridico> processosJuridicos;

	//private EscritorioAdvocacia escritorio;

	
	public String getNumeroOAB() {
		return numeroOAB;
	}

	public void setNumeroOAB(String numeroOAB) {
		this.numeroOAB = numeroOAB;
	}

	public PessoaFisica getFisica() {
		return fisica;
	}

	public void setFisica(PessoaFisica fisica) {
		this.fisica = fisica;
	}
	 
}
 
