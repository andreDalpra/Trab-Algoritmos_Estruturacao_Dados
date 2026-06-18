package banco;

import java.util.Date;

import entidades.Atendimento;
import entidades.Cliente;
import entidades.Guiche;
import entidades.TipoCliente;
import entidades.TipoGuiche;
import estrutura.Fila;
import estrutura.No;

public class PostoBancario {

	private static Fila filaPrioridade;
    private static Fila filaNormal;

    private static Guiche guichePreferencial;
    private static Guiche guicheGeral1;
    private static Guiche guicheGeral2;
    
    public PostoBancario() {
		filaPrioridade = new Fila();
		filaNormal = new Fila();
        guichePreferencial = new Guiche(1, TipoGuiche.PREFERENCIAL);
		guicheGeral1 = new Guiche(2, TipoGuiche.GERAL);
		guicheGeral2 = new Guiche(3, TipoGuiche.GERAL);
	}

    // Adiciona Cliente em uma das filas
    public boolean adicionarCliente(Cliente p_cliente) {
    	//Se for cliente normal
    	if  (p_cliente.getTipo() == TipoCliente.NORMAL) {
    		Atendimento a = new Atendimento(p_cliente, new Date(), null, Atendimento.tempoAtendimento());
    		filaNormal.inserir(a);
    		return true;
    	}
    	else if (p_cliente.getTipo() == TipoCliente.PRIORITARIO) {
    		Atendimento a = new Atendimento(p_cliente, new Date(), null, Atendimento.tempoAtendimento());
    		filaPrioridade.inserir(a);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    // Chama o proximo atendimento, calculando tempo de espera, gravando historico no guiche:
    public boolean chamarProximo(Guiche p_guiche) {    	
    	//Acha quem é o proximo atendimento e ja remove da fila
    	Atendimento a = removerProximo(p_guiche);
    	
    	if (a == null) {
    		//Nao achou ninguem para ser atendido
    		return false;
    	}
    	
    	// Define que o atendimento ira começar
    	a.sethoraInicio(new Date());
    	
    	// Registra o atendimento no guiche
    	p_guiche.registraAtendimento(a);
    	    	    	
    	return true;
    }
    
    // Ve quem é o proximo 
    private Atendimento removerProximo(Guiche p_guiche) {
        if (p_guiche.getTipo() == TipoGuiche.PREFERENCIAL) {
            if (!filaPrioridade.estaVazia()) {
                return filaPrioridade.remover();
            }

            return filaNormal.remover();
        }

        if (p_guiche.getUltimoAtendido() == TipoCliente.PRIORITARIO) {
            if (!filaNormal.estaVazia()) {
                return filaNormal.remover();
            }

            return filaPrioridade.remover();
        }

        if (!filaPrioridade.estaVazia()) {
            return filaPrioridade.remover();
        }

        return filaNormal.remover();
    }

    //Conta quanto cada guiche teve de atendimentos
    public int contarAtendimentos() {
        int control = 0;

        control += getGuichePreferencial().getHistorico().getTamanho();
        control += getGuicheGeral1().getHistorico().getTamanho();
        control += getGuicheGeral2().getHistorico().getTamanho();

        return control;
    }
    
    public double calculaTempoEspera(TipoCliente p_tipo) {
    	//Poderia usar o metodo de cima mas ficou com preguica de mexer para aceitar p_tipo ....
        if (p_tipo == null) {
            No atual = null;
            No[] atuais = {guichePreferencial.getHistorico().getTopo(), guicheGeral1.getHistorico().getTopo(), guicheGeral2.getHistorico().getTopo()};
            double time = 0;

            for (No no : atuais) {
                atual = no;
                while(atual != null) {
                    time = time + atual.getValor().calculaTempoEspera();
                    atual = atual.getProximo();
                }
            }
            return time / contarAtendimentos();
        }

        int l_qtd1 = guichePreferencial.contarAtendimentos(p_tipo);
        int l_qtd2 = guicheGeral1.contarAtendimentos(p_tipo);
        int l_qtd3 = guicheGeral2.contarAtendimentos(p_tipo);

        //Acumula todos os atendimentos
        int l_quantidadeTotal = contarAtendimentos();

        if (l_quantidadeTotal == 0) {
            return 0;
        }
        
        //Faz a media ponderada 
        double l_tempoTotal =
            guichePreferencial.calculaTempoMedioEspera(p_tipo) * l_qtd1 +
            guicheGeral1.calculaTempoMedioEspera(p_tipo) * l_qtd2 +
            guicheGeral2.calculaTempoMedioEspera(p_tipo) * l_qtd3;

        return l_tempoTotal / l_quantidadeTotal;
    }

    public String listarPorTempoDeEspera() {
        StringBuilder sb = new StringBuilder();
        int totalAtendimentos = contarAtendimentos();

        if (totalAtendimentos == 0) {
            return "Nenhum atendimento registrado.";
        }

        Atendimento[] atendimentos = new Atendimento[totalAtendimentos];
        int control = 0;

        No[] atuais = {
                (guichePreferencial.getHistorico() != null) ? guichePreferencial.getHistorico().getTopo() : null,
                (guicheGeral1.getHistorico() != null) ? guicheGeral1.getHistorico().getTopo() : null,
                (guicheGeral2.getHistorico() != null) ? guicheGeral2.getHistorico().getTopo() : null
        };

        for (No no : atuais) {
            No atual = no;
            while (atual != null) {
                if (atual.getValor() != null && control < atendimentos.length) {
                    atendimentos[control] = atual.getValor();
                    control++;
                }
                atual = atual.getProximo();
            }
        }

        for (int i = 0; i < atendimentos.length - 1; i++) {
            for (int j = 0; j < atendimentos.length - i - 1; j++) {
                // Se o atendimento 'j' tiver menos tempo que o 'j+1', eles trocam de lugar
                if (atendimentos[j].calculaTempoEspera() < atendimentos[j + 1].calculaTempoEspera()) {
                    Atendimento temp = atendimentos[j];
                    atendimentos[j] = atendimentos[j + 1];
                    atendimentos[j + 1] = temp;
                }
            }
        }
        sb.append("= Lista de Atendimentos por Tempo de Espera =\n");
        for (Atendimento a : atendimentos) {
            if (a != null) {
                sb.append(a.toString())
                        .append(" | Tempo de Espera: ")
                        .append(a.calculaTempoEspera())
                        .append(" min\n");
            }
        }

        return sb.toString();
    }

    public String listarPorOrdemCronologica() {
        StringBuilder sb = new StringBuilder();
        int totalAtendimentos = contarAtendimentos();

        if (totalAtendimentos == 0) {
            return "Nenhum atendimento registrado.";
        }

        Atendimento[] atendimentos = new Atendimento[totalAtendimentos];
        int control = 0;

        No[] atuais = {
                (guichePreferencial.getHistorico() != null) ? guichePreferencial.getHistorico().getTopo() : null,
                (guicheGeral1.getHistorico() != null) ? guicheGeral1.getHistorico().getTopo() : null,
                (guicheGeral2.getHistorico() != null) ? guicheGeral2.getHistorico().getTopo() : null
        };

        for (No no : atuais) {
            No atual = no;
            while (atual != null) {
                if (atual.getValor() != null && control < atendimentos.length) {
                    atendimentos[control] = atual.getValor();
                    control++;
                }
                atual = atual.getProximo();
            }
        }

        for (int i = 0; i < atendimentos.length - 1; i++) {
            for (int j = 0; j < atendimentos.length - i - 1; j++) {

                Date dataJ = atendimentos[j].gethoraInicio();
                Date dataProxima = atendimentos[j + 1].gethoraInicio();

                if (dataJ != null && dataProxima != null && dataJ.after(dataProxima)) {
                    Atendimento temp = atendimentos[j];
                    atendimentos[j] = atendimentos[j + 1];
                    atendimentos[j + 1] = temp;
                }
            }
        }

        sb.append("= Lista de Atendimentos por Ordem Cronológica =\n");
        for (Atendimento a : atendimentos) {
            if (a != null) {
                sb.append(a.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    // ******************
    // GETTERS E SETTERS
    //******************

	public static Fila getFilaPrioridade() {
		return filaPrioridade;
	}

	public static void setFilaPrioridade(Fila filaPrioridade) {
		PostoBancario.filaPrioridade = filaPrioridade;
	}

	public static Fila getFilaNormal() {
		return filaNormal;
	}

	public static void setFilaNormal(Fila filaNormal) {
		PostoBancario.filaNormal = filaNormal;
	}

	public static Guiche getGuichePreferencial() {
		return guichePreferencial;
	}

	public static void setGuichePreferencial(Guiche guichePreferencial) {
		PostoBancario.guichePreferencial = guichePreferencial;
	}

	public static Guiche getGuicheGeral1() {
		return guicheGeral1;
	}

	public static void setGuicheGeral1(Guiche guicheGeral1) {
		PostoBancario.guicheGeral1 = guicheGeral1;
	}

	public static Guiche getGuicheGeral2() {
		return guicheGeral2;
	}

	public static void setGuicheGeral2(Guiche guicheGeral2) {
		PostoBancario.guicheGeral2 = guicheGeral2;
	}
    
    
    
}
