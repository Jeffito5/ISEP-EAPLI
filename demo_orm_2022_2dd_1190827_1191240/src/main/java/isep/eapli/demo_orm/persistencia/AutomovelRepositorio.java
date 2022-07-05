package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.ContratoAluguer;

import java.util.List;

public interface AutomovelRepositorio {

    public Automovel add(Automovel entity);

    public Automovel findById(Long id);

    public List<Automovel> findAll();
}
