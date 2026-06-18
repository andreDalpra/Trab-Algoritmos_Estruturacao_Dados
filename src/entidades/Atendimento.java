package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Atendimento implements Comparable<Atendimento>{

	private Cliente cliente;
	private Date horaEntrada;
	private Date horaInicio;
	private int tempoAtendimento;

	//Duas formas de ordenação:
	private int criterioOrdenacao;
	public static final int TEMPO_ESPERA = 1;
    public static final int ORDEM_CRONOLOGICA = 2;
    
	public Atendimento(Cliente p_cliente, Date p_horaEntrada, Date p_horaInicio, int p_tempoAtendimento) {
		this.cliente = p_cliente;
		this.horaEntrada = p_horaEntrada;
		this.horaInicio = p_horaInicio;
		this.tempoAtendimento = p_tempoAtendimento;
	}
	
	public long calculaTempoEspera() {
		if (horaInicio == null) {
			return 0;
		}
		return (horaInicio.getTime() - horaEntrada.getTime())/ 60000;
	}
	
	public static int tempoAtendimento() {
		// Devolvo um tempo de atendimento entre 2 minutos e 30
	    Random random = new Random();
	    return random.nextInt(29) + 2;
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
	
	public void setCriterioOrdenacao(int p_criterioOrdenacao) {
        this.criterioOrdenacao = p_criterioOrdenacao;
    }

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		
		return "Atendimento [idCliente=" + cliente.getId() + ", tipoCliente=" + cliente.getTipo() + ", horaEntrada="
				+ sdf.format(horaEntrada) + ", horaInicio=" + sdf.format(horaInicio) + ", tempoAtendimento=" + tempoAtendimento + ", Tempo Espera=" + calculaTempoEspera() +"]";
	}

	@Override
    public int compareTo(Atendimento p_outro) {
        if (criterioOrdenacao == TEMPO_ESPERA) {
            return Long.compare(
                calculaTempoEspera(),
                p_outro.calculaTempoEspera()
            );
        }

        return gethoraInicio().compareTo(p_outro.gethoraInicio());
    }
}
