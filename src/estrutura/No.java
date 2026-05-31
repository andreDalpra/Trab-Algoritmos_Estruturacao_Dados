//Classe de NO padrao, podera ser usado pra Fila e Pilha e talvez MAPA

package estrutura;

import entidades.Atendimento;

public class No {
	
	private Atendimento valor;
	private No proximo;
	
	public No(Atendimento valor) {
		this.valor = valor;
	}
	
	public Atendimento getValor() {
		return valor;
	}
	public void setValor(Atendimento valor) {
		this.valor = valor;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}	
	
}
