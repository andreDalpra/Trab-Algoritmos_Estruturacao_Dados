package banco;

import java.util.Date;

import entidades.Atendimento;
import entidades.Cliente;
import entidades.Guiche;
import entidades.TipoCliente;
import entidades.TipoGuiche;
import estrutura.Fila;

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

    // Adicione 
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
    	//Acha quem é o proximo atendimento
    	Atendimento a = removerProximo(p_guiche);
    	
    	if (a == null) {
    		//Nao achou ninguem para ser atendido
    		return false;
    	}
    	
    	// Define que o atendimento ira começar
    	a.sethoraInicio(new Date());
    	
    	// Registra o atendimento no guiche
    	p_guiche.registraAtendimento(a);
    	// Remove o atendimento da fila em que ele estava
    	
    	    	    	
    	return true;
    }
    
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
    
}
