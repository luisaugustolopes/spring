package br.com.lopes.model;

import java.util.Calendar;

public class Documento {
 
	private Long id;
	 
	private String nome;
	 
	private int tipoDocumento;
	 
	private String caminho;
	 
	private int tamanho;
	 
	private Calendar dataCriacao;
	 
	private Calendar dataModificacao;
	 
	private Usuario proprietario;
	 
	private Usuario usuarioModificacao;
	 
	private Usuario usuario;	 
	 
	private DocumentoProcessoJuridico documentoProcesso;
	 
}
 
