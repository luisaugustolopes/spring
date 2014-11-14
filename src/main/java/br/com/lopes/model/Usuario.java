package br.com.lopes.model;

import java.util.Calendar;


public class Usuario{
 
	private long id;
	
	private String logon;
	
	private String email;
	
	private String senha;
	
	private boolean ativo;
	
	private boolean administrador;
	
	private Calendar dataCriacao;

	//private Pessoa pessoa;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogon() {
		return logon;
	}

	public void setLogon(String logon) {		
		this.logon = logon.trim().toUpperCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha= senha ;
	}	
	
	
	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	/*public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}*/
	
	@Override
	public String toString() {
		return logon;
	}
}
 
