package entidades;

import estrutura.Pilha;

public class Guiche {

	private int id;
	private TipoGuiche tipo;
	private Pilha historico;
	private TipoCliente ultimoAtendido;
	
	public Guiche(int id, TipoGuiche tipo, Pilha historico, TipoCliente ultimoAtendido) {
		this.id = id;
		this.tipo = tipo;
		this.historico = historico;
		this.ultimoAtendido = ultimoAtendido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoGuiche getTipo() {
		return tipo;
	}

	public void setTipo(TipoGuiche tipo) {
		this.tipo = tipo;
	}

	public Pilha getHistorico() {
		return historico;
	}

	public void setHistorico(Pilha historico) {
		this.historico = historico;
	}

	public TipoCliente getUltimoAtendido() {
		return ultimoAtendido;
	}

	public void setUltimoAtendido(TipoCliente ultimoAtendido) {
		this.ultimoAtendido = ultimoAtendido;
	}
	
	
	
}
