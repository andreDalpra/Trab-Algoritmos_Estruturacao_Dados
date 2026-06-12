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
    
    public boolean adicionarCliente(Cliente p_cliente) {
    	//Se for cliente normal
    	if  (p_cliente.getTipo() == TipoCliente.NORMAL) {
    		Atendimento a = new Atendimento(p_cliente, new Date(), null, 0);
    		filaNormal.inserir(a);
    		return true;
    	}
    	else if (p_cliente.getTipo() == TipoCliente.PRIORITARIO) {
    		Atendimento a = new Atendimento(p_cliente, new Date(), null, 0);
    		filaPrioridade.inserir(a);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public Atendimento chamarProximo(Guiche p_guiche) {
    	//Vejo qual o tipo do guiche
    	if  (p_guiche.getTipo() == TipoGuiche.PREFERENCIAL) {
    		//Atende a fila preferencial somente se nao for nulo      
    	}
    }
    
}
