package banco;

import entidades.Guiche;
import entidades.TipoGuiche;
import estrutura.Fila;

public class PostoBancario {

	private Fila filaPrioridade;
    private Fila filaNormal;

    private Guiche guichePreferencial;
    private Guiche guicheGeral1;
    private Guiche guicheGeral2;
    
    public PostoBancario() {
		this.filaPrioridade = new Fila();
		this.filaNormal = new Fila();
		this.guichePreferencial = new Guiche(1, TipoGuiche.PREFERENCIAL);
		this.guicheGeral1 = new Guiche(2, TipoGuiche.GERAL);
		this.guicheGeral2 = new Guiche(3, TipoGuiche.GERAL);
	}
    
}
