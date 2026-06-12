package entidades;

import java.util.Date;

public class Cliente {

	private int id;
	private String nome;
	private Date horaChegada;
	private TipoCliente tipo;
	
	public Cliente(int id, Date horaChegada, TipoCliente tipo) {
		this.id = id;
		this.horaChegada = horaChegada;
		this.tipo = tipo;
	}
	
	public boolean valida() {
		//TODO: IMPLEMENTAR VALIDA()
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
