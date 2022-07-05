package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.ContratoAluguer;

import java.util.List;

/**
 * @author
 */
public interface ContratoAluguerRepositorio {

    public ContratoAluguer add(ContratoAluguer entity);

    public ContratoAluguer findById(Long id);

    public List<ContratoAluguer> findAll();

    public void update(ContratoAluguer entity);
}
