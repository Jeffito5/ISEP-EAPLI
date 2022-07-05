package isep.eapli.demo_orm.apresentacao;

import isep.eapli.demo_orm.aplicacao.ClienteController;
import isep.eapli.demo_orm.dominio.Cliente;

import java.util.List;

public class ClienteUI {
    private final ClienteController clienteController;

    public ClienteUI(){
        clienteController = new ClienteController();
    }

    public Cliente registarCliente() {
        lapr.project.utils.Utils.print("Será inicializado o processo de registo:");
        String nome = lapr.project.utils.Utils.readLineFromConsole("Indique o nome do cliente: ");
        String nif = lapr.project.utils.Utils.readLineFromConsole("Indique o nif do cliente: ").trim();
        String dataDeNascimento = lapr.project.utils.Utils.readLineFromConsole("Indique a data de nascimento do cliente: ").trim();
        String email = lapr.project.utils.Utils.readLineFromConsole("Indique o email do cliente: ").trim();

        return clienteController.registarCliente(nif, nome, dataDeNascimento,email);
    }

    public void listarClientes() {
        System.out.println("Clientes:");
        List<Cliente> finalList = clienteController.listarClientes();
        for (Cliente cl : finalList)
            System.out.println(cl.toString());
    }

    public void procurarClientePorID(String id) {
        System.out.println("Clientes por id:");
        System.out.println(clienteController.procurarClientePorID(id).toString());
    }

}
