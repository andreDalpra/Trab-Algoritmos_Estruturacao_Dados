package entidades;

import java.util.Date;

public class Atendimento {
	
	private Cliente cliente;
    private Date horaEntrada;
    private Date horaInicio;
    private int tempoAtendimento;
    
    public Atendimento(Cliente cliente, Date horaEntrada, Date horaInicio, int tempoAtendimento) {
		this.cliente = cliente;
		this.horaEntrada = horaEntrada;
		this.horaInicio = horaInicio;
		this.tempoAtendimento = tempoAtendimento;
	}
    
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Date gethoraInicio() {
		return horaInicio;
	}
	public void sethoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getTempoAtendimento() {
		return tempoAtendimento;
	}
	public void setTempoAtendimento(int tempoAtendimento) {
		this.tempoAtendimento = tempoAtendimento;
	}
}
