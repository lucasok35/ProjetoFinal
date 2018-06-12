package br.com.projetofinal.model;

public class Acervo {
	
	private int idacervo;
	private String titulo;
	private String genero;
	private int qtdestoque;
	public Acervo(int idacervo, String titulo, String genero, int qtdestoque) {
		super();
		this.idacervo = idacervo;
		this.titulo = titulo;
		this.genero = genero;
		this.qtdestoque = qtdestoque;
	}
	public Acervo() {
		
	}
	public int getIdacervo() {
		return idacervo;
	}
	public void setIdacervo(int idacervo) {
		this.idacervo = idacervo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getQtdestoque() {
		return qtdestoque;
	}
	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}
	
	

	
	
	
	
	
}
