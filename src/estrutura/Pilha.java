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
		if  (estaVazia()) {
			return null;
		}
		
		Atendimento a = peek();
		topo = topo.getProximo();
		tamanho--;
		return a;
	}
	
	public Atendimento peek() {
		if  (estaVazia()) {
			return null;
		}
		
		return topo.getValor();
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
}
