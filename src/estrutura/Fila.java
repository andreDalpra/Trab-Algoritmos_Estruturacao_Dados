package estrutura;

import entidades.Atendimento;

public class Fila {
   
	private No inicio;
	private No fim;
	private int tamanho;
	
	
	public void inserir(Atendimento p_atendimento) {
		No novo = new No(p_atendimento);
		
		if  (estaVazia()) {
			inicio = novo;
			fim = novo;
		}
		else {
			fim.setProximo(novo);
			fim = novo;
		}
		
		tamanho ++;
	}
	
	public Atendimento remover() {
		if (estaVazia()) {
			return null;
		}
		
		Atendimento a = buscaPrimeiro();
		inicio = inicio.getProximo();
		tamanho --;
		
		//Se era o ultimo restante
		if  (estaVazia()) {
			fim = null;
		}
		
		return a;
	}
	
	public Atendimento buscaPrimeiro() {
		if  (estaVazia()) {
			return null;
		}
		
		return inicio.getValor();
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}

	public No getInicio() {
		return inicio;
	}

	public void setInicio(No inicio) {
		this.inicio = inicio;
	}

	public No getFim() {
		return fim;
	}

	public void setFim(No fim) {
		this.fim = fim;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	
} 
