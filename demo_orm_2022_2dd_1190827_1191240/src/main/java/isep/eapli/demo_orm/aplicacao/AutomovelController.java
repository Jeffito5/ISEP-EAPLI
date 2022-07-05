package isep.eapli.demo_orm.aplicacao;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.GrupoAutomovel;
import isep.eapli.demo_orm.persistencia.AutomovelRepositorio;
import isep.eapli.demo_orm.persistencia.AutomovelRepositórioJPAImpl;

import java.util.List;

public class AutomovelController {
    private final AutomovelRepositorio repo;

    public AutomovelController() {
        this.repo = new AutomovelRepositórioJPAImpl();
    }


    public Automovel registarAutomovel(String matricula, int anoFabrico, int anoAquisicao, String cor, double cilidrada, double kmsPercorrido, GrupoAutomovel grupoAutomovel) {
        Automovel automovel = new Automovel(matricula, anoFabrico, anoAquisicao, cor, cilidrada, kmsPercorrido, grupoAutomovel);
        return repo.add(automovel);
    }

    public List<Automovel> listarAutomoveis() {
        return repo.findAll();
    }

    public Automovel procurarAutomovelPorID(long id) {
        return repo.findById(id);
    }
}
