package postobancario;

import banco.*;
import entidades.*;
import estrutura.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PostoBancario postoBancario = new PostoBancario();

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                =========================================
                     POSTO DE ATENDIMENTO BANCÁRIO
                =========================================

                1 - Adicionar Cliente
                2 - Chamar Próximo Cliente
                3 - Exibir Filas
                4 - Exibir Histórico dos Guichês
                5 - Relatório de Atendimentos
                6 - Sair

                Escolha uma opção:
                                """);
        int opc = scanner.nextInt();

        switch (opc) {
            case 1:
                System.out.println("""
                        === Chamar Próximo ===
                        1 - Guichê preferencial
                        2 - Guichê geral 1
                        3 - Guichê geral 2
                        0 - Voltar
                        """);
                int opcChamarProx = scanner.nextInt();
                switch (opcChamarProx) {
                    case 1:
                        guichePreferencial.
                        break;

                    default:
                        break;
                }

                break;
            case 2:
                // Metodo para chamar o proximo na fila
                break;
            case 3:
                // Colocar os toString()
                break;
            case 4:
                System.out.println("""
                        === Historico ===
                        1 - Guichê Preferencial
                        2 - Guichê geral 1
                        3 - Guichê gerla 2
                        4 - Todos

                        Escolha:
                        """);
                break;
            case 5:
                System.out.println("""
                        === Relatório Atendimentos ===
                        RELATORIO...
                        """);
                System.out.println("""
                        1 - Listar por tempo de espera
                        2 - Listar por ordem cronológica
                        0 - Voltar
                        """);
            default:
                break;
        }

        scanner.close();

    }
}
