package entidades;

import estrutura.Pilha;

public class Guiche {

	private int id;
	private TipoGuiche tipo;
	private Pilha historico;
	private TipoCliente ultimoAtendido;

	public Guiche(int p_id, TipoGuiche p_tipo, Pilha p_historico, TipoCliente p_ultimoAtendido) {
		this.id = p_id;
		this.tipo = p_tipo;
		this.historico = p_historico;
		this.ultimoAtendido = p_ultimoAtendido;
	}

	// Metodo registra atendimento, salva e grava o historico na pilha
	public void registraAtendimento(Atendimento p_atendimento) {
		historico.push(p_atendimento);
		ultimoAtendido = p_atendimento.getCliente().getTipo();
	}

	public int getId() {
		return id;
	}

	public void setId(int p_id) {
		this.id = p_id;
	}

	public TipoGuiche getTipo() {
		return tipo;
	}

	public void setTipo(TipoGuiche p_tipo) {
		this.tipo = p_tipo;
	}

	public Pilha getHistorico() {
		return historico;
	}

	public void setHistorico(Pilha p_historico) {
		this.historico = p_historico;
	}

	public TipoCliente getUltimoAtendido() {
		return ultimoAtendido;
	}

	public void setUltimoAtendido(TipoCliente p_ultimoAtendido) {
		this.ultimoAtendido = p_ultimoAtendido;
	}

}
