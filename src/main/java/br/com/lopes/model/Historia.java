package br.com.lopes.model;

import java.util.Calendar;

public class Historia {

	private long numero;
	private String descricao;
	private String resumo;
	private Calendar data;

	
	public Historia(long numero, String descricao, String resumo, Calendar data) {
		super();
		this.numero = numero;
		this.descricao = descricao;
		this.resumo = resumo;
		this.data = data;
	}
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
}
