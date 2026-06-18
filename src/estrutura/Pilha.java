package estrutura;

import entidades.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		No atual = getTopo();

        if (atual == null) {
            return "Sem Historico de atendimentos";
        }

		while (atual != null) {
            Atendimento atendimento = atual.getValor();
            Cliente cliente = atendimento.getCliente();

            sb.append("Cliente: ").append(cliente.getId()).append(" ").append(cliente.getNome());
            sb.append("\nChegada: ").append(new SimpleDateFormat("HH:mm").format(atendimento.gethoraInicio()));
            sb.append("\nAtendimento: ").append(new SimpleDateFormat("HH:mm").format(atendimento.getTempoAtendimento()));
            sb.append("\nEspera: ").append(Atendimento.tempoAtendimento()).append(" min");
			atual = atual.getProximo();
		}
		return sb.toString();
	}

    public int getTamanho() {
        return tamanho;
    }
}
