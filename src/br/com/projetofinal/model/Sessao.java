package br.com.projetofinal.model;

public class Sessao {
	
	private int idsessao;
	private String descricao;
	private String localizacao;
	public Sessao(int idsessao, String descricao, String localizacao) {
		this.idsessao = idsessao;
		this.descricao = descricao;
		this.localizacao = localizacao;
	}
	public Sessao() {
		
	}
	public int getIdsessao() {
		return idsessao;
	}
	public void setIdsessao(int idsessao) {
		this.idsessao = idsessao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
	
	
}
