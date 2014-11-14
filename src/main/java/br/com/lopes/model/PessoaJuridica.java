package br.com.lopes.model;


public class PessoaJuridica extends Pessoa {
 
	private String cnpj;
	
	//private String inscricaoestadual;
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	@Override
	public String toString() {
		return super.toString() + " CNPJ: " + cnpj;
	}
}
 
