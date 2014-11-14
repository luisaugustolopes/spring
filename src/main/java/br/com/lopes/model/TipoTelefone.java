package br.com.lopes.model;

public enum TipoTelefone {

	FIXO(0), CELULAR(1);

	private int tipoTelefone;

	TipoTelefone(int tipo) {
		tipoTelefone = tipo;
	}
	
	public int getTipo(){
		return tipoTelefone;
	}

}
