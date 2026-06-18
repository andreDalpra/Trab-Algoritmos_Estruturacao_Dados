package entidades;

import estrutura.*;

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

    public int contarAtendimentos(TipoCliente p_tipo) {
        Pilha aux = getHistorico();
        No l_atual = aux.getTopo();
        int control = 0;
        
        //Tive que fazer isso por esse método é chamado no método logo abaixo (calculaTempoMedioEspera)
        if  (p_tipo == null) {
        	return 0;
        }
        
        if (l_atual == null) {
            return 0;
        }

        while (l_atual != null) {
            if (l_atual.getValor().getCliente().getTipo() == p_tipo) {
                control++;
            }
            l_atual = l_atual.getProximo();
        }
        return control;
    }
    
    // Percorre todos os atendimentos feitos e calcula o tempo de espera de cada um e faz a media
    public double calculaTempoMedioEspera(TipoCliente p_tipo) {
    	No l_atual = historico.getTopo();
        long l_tempoTotal = 0;

        while (l_atual != null) {
            Atendimento l_atendimento = l_atual.getValor();

            if (p_tipo == null || l_atendimento.getCliente().getTipo() == p_tipo) {
                l_tempoTotal += l_atendimento.calculaTempoEspera();
            }

            l_atual = l_atual.getProximo();
        }
        
        int l_quantidade = contarAtendimentos(p_tipo);
        
        //Evita divisao por zero
        if  (l_quantidade == 0) {
        	return 0;
        }
        
        //Retona a media simples
        return (double) l_tempoTotal / l_quantidade ;
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
