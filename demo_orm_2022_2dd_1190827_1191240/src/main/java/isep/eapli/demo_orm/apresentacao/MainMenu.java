/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.eapli.demo_orm.apresentacao;

import isep.eapli.demo_orm.util.Console;

/**
 * @author mcn
 */
public class MainMenu {
    public static void mainLoop() {
        GrupoAutomovelUI grupoAutomovelUI = new GrupoAutomovelUI();
        ContratoAluguerUI contratoAluguerUI = new ContratoAluguerUI();
        ClienteUI clienteUI = new ClienteUI();
        AutomovelUI automovelUI = new AutomovelUI();
        int opcao = -1;
        do {
            opcao = menu();

            switch (opcao) {
                case 1:
                    grupoAutomovelUI.registarGA();
                    break;
                case 2:
                    grupoAutomovelUI.listarGAs();
                    break;
                case 3:
                    long number2 = lapr.project.utils.Utils.readLongFromConsole("Insera o id do automóvel.");
                    grupoAutomovelUI.procurarGAPorID(number2);
                    break;
                case 4:
                    contratoAluguerUI.registarCA();
                    break;
                case 5:
                    contratoAluguerUI.listarCAs();
                    break;
                case 6:
                    long number3 = lapr.project.utils.Utils.readLongFromConsole("Insera o id do grupo automóvel.");
                    contratoAluguerUI.procurarCAPorID(number3);
                    break;
                case 7:
                    clienteUI.registarCliente();
                    break;
                case 8:
                    clienteUI.listarClientes();
                    break;
                case 9:
                    String nifCLiente = lapr.project.utils.Utils.readLineFromConsole("Insera o nif do cliente.");
                    clienteUI.procurarClientePorID(nifCLiente);
                    break;
                case 10:
                    automovelUI.registarAutomovel();
                    break;
                case 11:
                    automovelUI.listarAutomoveis();
                    break;
                case 12:
                    long automovelID = lapr.project.utils.Utils.readLongFromConsole("Insera o id do Automovel: ");
                    automovelUI.procurarAutomovelPorID(automovelID);
                    break;
                case 13:
                    long idDoContrato = lapr.project.utils.Utils.readLongFromConsole("Insera o id do Contrato de Aluguer: ");
                    contratoAluguerUI.registarCondutorAutorizado(idDoContrato);
                    break;
                default:
                    System.out.println("opcao não reconhecida.");
                    break;
            }
        } while (opcao != 0);

    }

    private static int menu() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Rent a Car ");
        System.out.println("=============================\n");
        System.out.println("1.Registar Grupo Automóvel.");
        System.out.println("2.Listar todos os Grupos Automóveis.");
        System.out.println("3.Listar todos os Grupos Automóveis por ID.");
        System.out.println("4.Registar um contrato de aluguer.");
        System.out.println("5.Listar todos os contratos de aluguer.");
        System.out.println("6.Procurar um contrato de aluguer por ID.");
        System.out.println("7.Registar um cliente.");
        System.out.println("8.Listar todos os clientes.");
        System.out.println("9.Procurar um cliente por NIF.");
        System.out.println("10.Registar um automovel.");
        System.out.println("11.Listar todos os automoveis.");
        System.out.println("12.Procurar um automovel por ID.");
        System.out.println("13.Adicionar Condutor(es) Autorizado(s).");

        System.out.println("=============================");
        System.out.println("0. Sair\n\n");
        option = Console.readInteger("Por favor escolha opção");
        return option;
    }
}
