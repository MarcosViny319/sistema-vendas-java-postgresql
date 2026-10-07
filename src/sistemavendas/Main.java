package sistemavendas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE VENDAS =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Excluir cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    // cadastrar
                    break;

                case 2:
                    clienteDAO.listar();
                    break;

                case 3:
                    // atualizar
                    break;

                case 4:
                    // excluir
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}