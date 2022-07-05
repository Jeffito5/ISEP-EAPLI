package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.Automovel;

import javax.persistence.*;
import java.util.List;

/**
 * @author
 */
public class AutomovelRepositórioJPAImpl implements  AutomovelRepositorio{

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("DEMO_ORMPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    /**
     * inserts an entity GrupoAutomovel
     *
     * @param automovel
     * @return the persisted entity
     */
    @Override
    public Automovel add(Automovel automovel) {
        if (automovel == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(automovel);
        tx.commit();
        em.close();

        return automovel;
    }


    /**
     * reads an entity GrupoAutomovel given its ID
     *
     * @param id
     * @return
     */
    @Override
    public Automovel findById(Long id) {
        return getEntityManager().find(Automovel.class, id);
    }

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    @Override
    public List<Automovel> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM Automovel e");
        List<Automovel> list = query.getResultList();
        return list;
    }
}
