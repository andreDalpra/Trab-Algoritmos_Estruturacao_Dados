package estrutura;

import entidades.Atendimento;

public class Pilha {

	private No topo;
	private int tamanho;

	public void push(Atendimento p_atendimento) {
		No novo = new No(p_atendimento);
		novo.setProximo(topo);

		topo = novo;
		tamanho++;
	}

	public Atendimento pop() {
		if (estaVazia()) {
			return null;
		}

		Atendimento a = peek();
		topo = topo.getProximo();
		tamanho--;
		return a;
	}

	public Atendimento peek() {
		if (estaVazia()) {
			return null;
		}

		return topo.getValor();
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}
	
	public int contaNos() {
		return tamanho;
	}

	public No getTopo() {
		return topo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		No atual = topo;

		sb.append("Pilha [topo");

		while (atual != null) {
			sb.append(" -> ");
			sb.append(atual.getValor());
			atual = atual.getProximo();
		}

		sb.append("]");
		return sb.toString();
	}
	
	
}
