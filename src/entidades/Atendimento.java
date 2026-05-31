package entidades;

import java.util.Date;

public class Atendimento {

	private Cliente cliente;
	private Date horaEntrada;
	private Date horaInicio;
	private int tempoAtendimento;

	public Atendimento(Cliente p_cliente, Date p_horaEntrada, Date p_horaInicio, int p_tempoAtendimento) {
		this.cliente = p_cliente;
		this.horaEntrada = p_horaEntrada;
		this.horaInicio = p_horaInicio;
		this.tempoAtendimento = p_tempoAtendimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente p_cliente) {
		this.cliente = p_cliente;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date p_horaEntrada) {
		this.horaEntrada = p_horaEntrada;
	}

	public Date gethoraInicio() {
		return horaInicio;
	}

	public void sethoraInicio(Date p_horaInicio) {
		this.horaInicio = p_horaInicio;
	}

	public int getTempoAtendimento() {
		return tempoAtendimento;
	}

	public void setTempoAtendimento(int p_tempoAtendimento) {
		this.tempoAtendimento = p_tempoAtendimento;
	}
}
