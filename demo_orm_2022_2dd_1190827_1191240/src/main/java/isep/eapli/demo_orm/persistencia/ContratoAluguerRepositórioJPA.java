package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.ContratoAluguer;

import javax.persistence.*;
import java.util.List;

/**
 * @author
 */
public class ContratoAluguerRepositórioJPA implements ContratoAluguerRepositorio {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("DEMO_ORMPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public ContratoAluguer add(ContratoAluguer entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();

        return entity;
    }

    @Override
    public void update(ContratoAluguer entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ContratoAluguer aux = em.merge(entity);
        tx.commit();
        em.close();
    }

    @Override
    public ContratoAluguer findById(Long id) {
        return getEntityManager().find(ContratoAluguer.class, id);
    }

    @Override
    public List<ContratoAluguer> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM ContratoAluguer e");
        List<ContratoAluguer> list = query.getResultList();
        return list;
    }

}
