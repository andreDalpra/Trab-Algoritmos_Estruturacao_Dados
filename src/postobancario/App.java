package postobancario;

import java.util.Date;
import java.util.Scanner;

import banco.PostoBancario;
import entidades.Cliente;
import entidades.TipoCliente;

public class App {

	// Variavel da classe de regras e validações.
	private static PostoBancario posto = new PostoBancario();
	// Variavel da Scanner
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Menu(posto);		
	}
	
	private static void Menu(PostoBancario p_posto) {
		int l_opcao = -1;
		
		System.out.println("Bem Vindo ao Sistema de Posto Bancário");
		while (l_opcao != 0) {
			montaMenu();
			l_opcao = validaOpcao();
			
			if (l_opcao == 1) {
				adicionarCliente();
			}
			else if(l_opcao == 2){
				chamarProximoCliente();
			}
			else {
				System.out.println("Opção Inválida. Escolha entre as opções.");
			}
		}
		System.out.println("FIM DA EXECUÇÃO");
		System.exit(0);
	}

	// Monta o Menu do Sistema
	private static void montaMenu() {
		System.out.println();
		System.out.println("Escolha uma das opções");
		System.out.println("1 - Adicionar Cliente");
		System.out.println("2 - Chamar Próximo");
		System.out.println("3 - Total Atendimentospo de Cliente");
		System.out.println("4 - Adicionar Cliente por Guiche");
		System.out.println("5 - Consulta Filas");
		System.out.println("6 - Atendimentos por tipo de Cliente");
		
		System.out.println("0 - Sair do Sistema");
	}
	
	// Adicionar o cliente nas filas
	private static boolean adicionarCliente() {
	    System.out.print("ID do cliente: ");
	    int id = sc.nextInt();
	    sc.nextLine();

	    System.out.print("Nome do cliente: ");
	    String nome = sc.nextLine();

	    System.out.println("Tipo do cliente:");
	    System.out.println("1 - Normal");
	    System.out.println("2 - Prioritario");
	    System.out.print("Opcao: ");
	    int tipoOpcao = sc.nextInt();
	    sc.nextLine();

	    TipoCliente tipo;

	    if (tipoOpcao == 1) {
	        tipo = TipoCliente.NORMAL;
	    } else if (tipoOpcao == 2) {
	        tipo = TipoCliente.PRIORITARIO;
	    } else {
	        System.out.println("Tipo invalido. Cliente nao adicionado.");
	        return false;
	    }

	    Cliente cliente = new Cliente(id, nome, new Date(), tipo);

	    if (!cliente.valida()) {
	        System.out.println("Dados do cliente invalidos.");
	        return false;
	    }

	    if (posto.adicionarCliente(cliente)) {
	        System.out.println("Cliente adicionado com sucesso.");
	        return true;
	    }

	    System.out.println("Nao foi possivel adicionar o cliente.");
	    return false;
	}
	
	// Chama o proximo cliente a ser atendido
	private static boolean chamarProximoCliente() {
		System.out.println("Escolha o guiche:");
	    System.out.println("1 - Guiche Preferencial");
	    System.out.println("2 - Guiche Geral 1");
	    System.out.println("3 - Guiche Geral 2");
	    System.out.print("Opcao: ");

	    int opcao = sc.nextInt();
	    sc.nextLine();

	    boolean l_chamado;

	    if (opcao == 1) {
	    	l_chamado = posto.chamarProximo(posto.getGuichePreferencial());
	    } else if (opcao == 2) {
	    	l_chamado = posto.chamarProximo(posto.getGuicheGeral1());
	    } else if (opcao == 3) {
	    	l_chamado = posto.chamarProximo(posto.getGuicheGeral2());
	    } else {
	        System.out.println("Guiche invalido.");
	        return false;
	    }

	    if (l_chamado) {
	        System.out.println("Cliente chamado com sucesso.");
	        return true;
	    }

	    System.out.println("Nao ha clientes aguardando.");
	    return false;
	}
	
	// Valida a opcao que o usuario escolheu
	private static int validaOpcao() {
		System.out.println("Opcao: ");
		
		if (!sc.hasNextInt()) {
			sc.nextLine();
			return -1;
		}
		
		int l_opcao = sc.nextInt();
		sc.nextLine();
		
		return l_opcao;
	}
	
}
