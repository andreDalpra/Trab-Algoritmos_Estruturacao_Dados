package entidades;

import java.text.SimpleDateFormat;
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
	
	public long calculaTempoEspera() {
		return (horaInicio.getTime() - horaEntrada.getTime())/ 60000;
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

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		
		return "Atendimento [idCliente=" + cliente.getId() + ", tipoCliente=" + cliente.getTipo() + ", horaEntrada="
				+ sdf.format(horaEntrada) + ", horaInicio=" + sdf.format(horaInicio) + ", tempoAtendimento=" + tempoAtendimento + ", Tempo Espera=" + calculaTempoEspera() +"]";
	}
}
