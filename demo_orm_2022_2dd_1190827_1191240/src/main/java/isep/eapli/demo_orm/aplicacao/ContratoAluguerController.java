package isep.eapli.demo_orm.aplicacao;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.Cliente;
import isep.eapli.demo_orm.dominio.ContratoAluguer;
import isep.eapli.demo_orm.dominio.GrupoAutomovel;
import isep.eapli.demo_orm.persistencia.ContratoAluguerRepositorio;
import isep.eapli.demo_orm.persistencia.ContratoAluguerRepositórioJPA;

import java.util.List;

/**
 * @author
 */
public class ContratoAluguerController {
    private final ContratoAluguerRepositorio repo;

    public ContratoAluguerController() {
        repo = new ContratoAluguerRepositórioJPA();
    }

    public ContratoAluguer registarContratoAluguer(int tempoDoContrato, Automovel automovel, GrupoAutomovel grupoAutomovel, Cliente cliente) {
        ContratoAluguer contratoAluguer1 = new ContratoAluguer(tempoDoContrato, automovel, grupoAutomovel, cliente);
        return repo.add(contratoAluguer1);
    }

    public List<ContratoAluguer> listarContratosAluguer() {
        return repo.findAll();
    }

    public ContratoAluguer procurarContratosAluguer(long id) {
        return repo.findById(id);
    }

    public void atualizarContratoAluguer(ContratoAluguer contratoAluguer) {
        repo.update(contratoAluguer);
    }
}
