package estrutura;

import entidades.*;

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

        if (atual == null) {
            return "Sem Historico de atendimentos";
        }

		while (atual != null) {
            Atendimento atendimento = atual.getValor();
            Cliente cliente = atendimento.getCliente();

            sb.append("Cliente: ").append(cliente.getId()).append(" ").append(cliente.getNome());
            sb.append("Chegada: ").append(atendimento.getHoraEntrada());
            sb.append("Atendimento: ").append(atendimento.gethoraInicio());
            sb.append("Espera: ").append(Atendimento.tempoAtendimento());
            sb.append("\n");
			atual = atual.getProximo();
		}
		return sb.toString();
	}

    public int getTamanho() {
        return tamanho;
    }
}
