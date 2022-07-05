package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.Automovel;
import isep.eapli.demo_orm.dominio.Cliente;

import javax.persistence.*;
import java.util.List;

public class ClienteRepositorioJPAImpl implements ClienteRepositorio {
    //TODO ver os comentários e os nome dos métodos


    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("DEMO_ORMPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    /**
     * inserts an entity GrupoAutomovel
     *
     * @param cliente
     * @return the persisted entity
     */
    @Override
    public Cliente add(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cliente);
        tx.commit();
        em.close();

        return cliente;
    }


    /**
     * reads an entity GrupoAutomovel given its ID
     *
     * @param id
     * @return
     */
    @Override
    public Cliente findById(String id) {
        return getEntityManager().find(Cliente.class, id);
    }

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM Cliente e");
        List<Cliente> list = query.getResultList();
        return list;
    }
}
