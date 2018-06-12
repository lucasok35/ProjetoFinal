package br.com.projetofinal.model;

public class AcervoLocacao extends Acervo {
	private int idloc;
	private int idac;
	
	public AcervoLocacao(int idloc, int idac) {
		
		this.idloc = idloc;
		this.idac = idac;
	}
	
	public AcervoLocacao() {
		
	}

	public int getIdloc() {
		return idloc;
	}

	public void setIdloc(int idloc) {
		this.idloc = idloc;
	}

	public int getIdac() {
		return idac;
	}

	public void setIdac(int idac) {
		this.idac = idac;
	}
	
	

}
