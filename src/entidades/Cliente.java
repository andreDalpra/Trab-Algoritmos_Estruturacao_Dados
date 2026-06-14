package entidades;

import java.util.Date;

public class Cliente {

	private int id;
	private String nome;
	private Date horaChegada;
	private TipoCliente tipo;
	
	public Cliente(int p_id, String p_nome, Date p_horaChegada, TipoCliente p_tipo) {
		this.id = p_id;
		this.nome = p_nome;
		this.horaChegada = p_horaChegada;
		this.tipo = p_tipo;
	}
	
	// Valida os atributos do cliente
	public boolean valida() {
	    if (id <= 0) {
	        return false;
	    }

	    if (nome == null || nome.trim().isEmpty()) {
	        return false;
	    }

	    if (tipo == null) {
	        return false;
	    }

	    return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
	
}
