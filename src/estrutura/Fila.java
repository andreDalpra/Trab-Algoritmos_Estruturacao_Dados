package estrutura;

import entidades.Atendimento;
import entidades.Cliente;

public class Fila {

	private No inicio;
	private No fim;
	private int tamanho;

	public void inserir(Atendimento p_atendimento) {
		No novo = new No(p_atendimento);

		if (estaVazia()) {
			inicio = novo;
			fim = novo;
		} else {
			fim.setProximo(novo);
			fim = novo;
		}

		tamanho++;
	}

	public Atendimento remover() {
		if (estaVazia()) {
			return null;
		}

		Atendimento a = buscaPrimeiro();
		inicio = inicio.getProximo();
		tamanho--;

		// Se era o ultimo restante
		if (estaVazia()) {
			fim = null;
		}

		return a;
	}

	public Atendimento buscaPrimeiro() {
		if (estaVazia()) {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		No atual = inicio;

		sb.append("Fila [inicio");

		while (atual != null) {
			sb.append(" -> ");
			sb.append(atual.getValor());
			atual = atual.getProximo();
		}

		sb.append("]");
		return sb.toString();
	}
        
        public String toStringConsultarFila() {
            StringBuilder sb = new StringBuilder();
            No atual  = inicio;
            
            if (atual == null) {
                return "Fila Vazia";
            }

            while (atual != null) {
                Atendimento atendimento = atual.getValor();
                Cliente cliente = atendimento.getCliente();
                atual = atual.getProximo();
                sb.append("Cliente: ").append(cliente.getId()).append(" ").append(cliente.getNome());
            }
            
            return sb.toString();
        }

}
