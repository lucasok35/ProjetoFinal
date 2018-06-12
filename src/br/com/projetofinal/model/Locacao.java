package br.com.projetofinal.model;

public class Locacao {
	
	private int idlocacao;
	private Double valor;
	private String datalocacao;
	private String datadevolucao;
	public Locacao(int idlocacao, Double valor, String datalocacao, String datadevolucao) {
		this.idlocacao = idlocacao;
		this.valor = valor;
		this.datalocacao = datalocacao;
		this.datadevolucao = datadevolucao;
	}
	public Locacao() {
		super();
	}
	public int getIdlocacao() {
		return idlocacao;
	}
	public void setIdlocacao(int idlocacao) {
		this.idlocacao = idlocacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDatalocacao() {
		return datalocacao;
	}
	public void setDatalocacao(String datalocacao) {
		this.datalocacao = datalocacao;
	}
	public String getDatadevolucao() {
		return datadevolucao;
	}
	public void setDatadevolucao(String datadevolucao) {
		this.datadevolucao = datadevolucao;
	}
	
	
	
}
