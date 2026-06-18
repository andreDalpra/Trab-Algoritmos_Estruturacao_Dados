package postobancario;

import java.lang.Math;
import java.util.Date;
import java.util.Scanner;

import banco.*;
import entidades.Cliente;
import entidades.TipoCliente;
import java.util.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static PostoBancario postoBancario = new PostoBancario();

    public static void main(String[] args) {
        boolean control = true;

        while (control) {
            montarMenu();
            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    adicionarCliente();
                    break;
                case 2: //ok
                    chamarProximoCliente();
                    break;
                case 3:
                    exibirFilas();
                    break;
                case 4:
                    historicoGuiches();
                    break;
                case 5:
                    relatorioDeAtendimentos();
                    break;
                case 0:
                    control = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void montarMenu() {
        System.out.print("""
                \n=========================================
                     POSTO DE ATENDIMENTO BANCÁRIO
                =========================================
                
                1 - Adicionar Cliente
                2 - Chamar Próximo Cliente
                3 - Exibir Filas
                4 - Exibir Histórico dos Guichês
                5 - Relatório de Atendimentos
                0 - Sair
                
                Escolha uma opção:""" + " ");
    }

    public static boolean adicionarCliente() {
        System.out.println("Informe o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o nome do cliente");
        String nome = scanner.nextLine();

        System.out.println("""
                Tipo do cliente
                1 - Normal
                2 - Preferencial
                0 - Voltar
                Informe a escolha:
                """);
        int opc = scanner.nextInt();

        TipoCliente tipo = null;

        if (opc == 1) {
            tipo = TipoCliente.NORMAL;
        } else if (opc == 2) {
            tipo = TipoCliente.PRIORITARIO;
        } else if (opc == 0) {
            montarMenu();
        } else {
            System.out.println("Tipo Invalido. Operação Cancelada");
            return false;
        }

        Cliente cliente = new Cliente(id, nome, new Date(), tipo);

        if (!cliente.valida()) {
            System.out.println("Dados do cliente invalidos.");
            return false;
        }

        if (postoBancario.adicionarCliente(cliente)) {
            System.out.println("Cliente adicionado com sucesso.");
            return true;
        }

        System.out.println("Nao foi possivel adicionar o cliente.");
        return false;
    }

    public static boolean chamarProximoCliente() {
        System.out.println("""
                === Chamar Proximo Cliente ===
                1 - Preferencial
                2 - Geral 1
                3 - Geral 2
                0 - Voltar
                Informe a opção:
                """);
        int opc = scanner.nextInt();

        boolean chamado = false;

        if (opc == 1) {
            chamado = postoBancario.chamarProximo(banco.PostoBancario.getGuichePreferencial());
        } else if (opc == 2) {
            chamado = postoBancario.chamarProximo(banco.PostoBancario.getGuicheGeral1());
        } else if (opc == 3) {
            chamado = postoBancario.chamarProximo(banco.PostoBancario.getGuicheGeral2());
        } else if (opc == 0) {
            montarMenu();
        } else {
            System.out.println("Opção Invalida. Cancelando Operação");
            return false;
        }

        if (chamado) {
            System.out.println("Cliente chamado com sucesso");
            return true;
        }

        System.out.println("Não ha cliente aguardando");
        return false;
    }

    public static void exibirFilas() {
        System.out.println("\n=== Fila Prioridade ===\n");
        System.out.println(banco.PostoBancario.getFilaPrioridade().toStringConsultarFila()); //TODO: Esta duplicando

        System.out.println("\n=== Fila Normal ===\n");
        System.out.println(banco.PostoBancario.getFilaNormal().toStringConsultarFila());
        System.out.println();
    }

    public static void historicoGuiches() {
        System.out.print("""
                === Historico ===
                1 - Guichê Preferencial
                2 - Guichê geral 1
                3 - Guichê geral 2
                Escolha: """);
        int opc = scanner.nextInt();

        switch (opc) {
            case 1:
                System.out.println("=== Guiche Preferencial ===\n");
                System.out.println(banco.PostoBancario.getGuichePreferencial().getHistorico().toString());
                System.out.println();
                break;
            case 2:
                System.out.println("=== Guiche Geral 1 ===\n");
                System.out.println(banco.PostoBancario.getGuicheGeral1().getHistorico().toString());
                System.out.println();
                break;
            case 3:
                System.out.println("=== Guiche Geral 2 ===\n");
                System.out.println(banco.PostoBancario.getGuicheGeral2().getHistorico().toString());
                System.out.println();
                break;
            default:
                System.out.println("Opção Invalida\n");
                break;
        }
    }

    public static void relatorioDeAtendimentos() {
        /*
        NO FINAL DAR AS OPÇÕES DE LISTAR POR TEMPO DE ESPERA E POR ORDEM CRONOLOGICA
         */
        System.out.println("\n=== Relatorio de Atendimentos ===\n");
        System.out.println("Total de Atendimentos: " + postoBancario.contarAtendimentos());


        System.out.println("\n= Guiche Preferencial =");
        System.out.println("Atendimentos: " + banco.PostoBancario.getGuichePreferencial().getHistorico().getTamanho()); //DAVA PARA PASSAR NULL NO METODO ABAIXO
        System.out.println("Preferencial: " + banco.PostoBancario.getGuichePreferencial().contarAtendimentos(TipoCliente.PRIORITARIO));
        System.out.println("Normais: " + banco.PostoBancario.getGuichePreferencial().contarAtendimentos(TipoCliente.NORMAL));

        System.out.println("\n= Guiche Geral 1 =");
        System.out.println("Atendimentos: " + banco.PostoBancario.getGuicheGeral1().getHistorico().getTamanho());
        System.out.println("Preferencial: " + banco.PostoBancario.getGuicheGeral1().contarAtendimentos(TipoCliente.PRIORITARIO));
        System.out.println("Normais: " + banco.PostoBancario.getGuicheGeral1().contarAtendimentos(TipoCliente.NORMAL));

        System.out.println("\n= Guiche Geral 2 =");
        System.out.println("Atendimentos: " + banco.PostoBancario.getGuicheGeral2().getHistorico().getTamanho());
        System.out.println("Preferencial: " + banco.PostoBancario.getGuicheGeral2().contarAtendimentos(TipoCliente.PRIORITARIO));
        System.out.println("Normais: " + banco.PostoBancario.getGuicheGeral2().contarAtendimentos(TipoCliente.NORMAL));

        System.out.println("Tempo Medio de Espera Total: " + String.format("%.2f", postoBancario.calculaTempoEspera(null) / 6000) + " min");
        System.out.println("Tempo Medio Prioritario: " + String.format("%.2f", postoBancario.calculaTempoEspera(TipoCliente.PRIORITARIO) / 6000) + " min"); //Fazer
        System.out.println("Tempo Medio Normal: " + String.format("%.2f", postoBancario.calculaTempoEspera(TipoCliente.NORMAL) / 6000) + " min"); //Fazer

        System.out.println("""
                \n1 - Listar por Tempo de Espera
                2 - Listar por Ordem Cronologica
                0 - Voltar
                Sua opção:""");
        int opc2 = scanner.nextInt();

        if (opc2 == 1) {
            System.out.println(postoBancario.listarPorTempoDeEspera());
        } else if (opc2 == 2) {
            System.out.println(postoBancario.listarPorOrdemCronologica());
        } else if (opc2 == 0) {
            System.out.println("Saindo");
        }
        montarMenu();
    }
}