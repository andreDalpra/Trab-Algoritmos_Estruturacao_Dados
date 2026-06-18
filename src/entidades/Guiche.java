package entidades;

import estrutura.Pilha;
import estrutura.No;

public class Guiche {

	private int id;
	private TipoGuiche tipo;
	private Pilha historico;
	private TipoCliente ultimoAtendido;

	public Guiche(int p_id, TipoGuiche p_tipo) {
		this.id = p_id;
		this.tipo = p_tipo;
		this.historico = new Pilha();
		this.ultimoAtendido = null;
	}

	// Metodo registra atendimento, salva e grava o historico na pilha
	public void registraAtendimento(Atendimento p_atendimento) {
		historico.push(p_atendimento);
		ultimoAtendido = p_atendimento.getCliente().getTipo();
	}
	
	public int getTotalAtendimentos() {
		return historico.contaNos(); 
	}

	// Retorna para os tipos de clientes atendidos...
	public int getTipoClientesAtendidos(TipoCliente p_tipo) {
	    int l_quantidade = 0;
	    No l_atual = historico.getTopo();

	    while (l_atual != null) {
	        Atendimento a = l_atual.getValor();

	        if (a.getCliente().getTipo() == p_tipo) {
	            l_quantidade++;
	        }

	        l_atual = l_atual.getProximo();
	    }

	    return l_quantidade;
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
