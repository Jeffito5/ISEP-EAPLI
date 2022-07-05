package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.Cliente;

import java.util.List;

public interface ClienteRepositorio {
    public Cliente add(Cliente entity);

    public Cliente findById(String id);

    public List<Cliente> findAll();
}
