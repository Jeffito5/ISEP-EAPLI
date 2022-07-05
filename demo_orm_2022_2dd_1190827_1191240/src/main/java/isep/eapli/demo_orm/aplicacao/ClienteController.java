package isep.eapli.demo_orm.aplicacao;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.Cliente;
import isep.eapli.demo_orm.dominio.GrupoAutomovel;
import isep.eapli.demo_orm.persistencia.ClienteRepositorio;
import isep.eapli.demo_orm.persistencia.ClienteRepositorioJPAImpl;

import java.util.List;

public class ClienteController {
    private final ClienteRepositorio repo;

    public ClienteController(){
        repo = new ClienteRepositorioJPAImpl();
    }

    public Cliente registarCliente(String nif, String nome, String dataDeNascimento, String email) {
        Cliente cliente = new Cliente(nif, nome, dataDeNascimento,email);
        return repo.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return repo.findAll();
    }

    public Cliente procurarClientePorID(String id) {
        return repo.findById(id);
    }
}
