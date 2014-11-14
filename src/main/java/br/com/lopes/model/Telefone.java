package br.com.lopes.model;

public class Telefone {

	private long id;

	private String ddd;

	private String numero;

	private TipoTelefone tipoTelefone;

	private Pessoa pessoa;

	/**
	 * Constructor
	 * 
	 */

	public Telefone() {
		setTipoTelefone(TipoTelefone.FIXO); 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isTelefoneValido() {

		// TODO Fazer valida��o do ddd/n�mero
		// considerando 0800 e 4004

		/*
		 * if (ddd.length() <> 3){ return false; } if (numero)
		 */
		return true;

	}
	
	

	@Override
	public String toString() {
		return ddd + '-' + numero;
	}


}
