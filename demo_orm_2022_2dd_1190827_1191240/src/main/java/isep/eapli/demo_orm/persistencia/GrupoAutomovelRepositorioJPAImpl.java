/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.eapli.demo_orm.persistencia;

import isep.eapli.demo_orm.dominio.GrupoAutomovel;

import javax.persistence.*;
import java.util.List;

/**
 * @author eapli
 */
public class GrupoAutomovelRepositorioJPAImpl implements GrupoAutomovelRepositorio {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("DEMO_ORMPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    /**
     * inserts an entity GrupoAutomovel
     *
     * @param grupoAutomovel
     * @return the persisted entity
     */
    @Override
    public GrupoAutomovel add(GrupoAutomovel grupoAutomovel) {
        if (grupoAutomovel == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(grupoAutomovel);
        tx.commit();
        em.close();

        return grupoAutomovel;
    }


    /**
     * reads an entity GrupoAutomovel given its ID
     *
     * @param id
     * @return
     */
    @Override
    public GrupoAutomovel findById(Long id) {
        return getEntityManager().find(GrupoAutomovel.class, id);
    }

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    @Override
    public List<GrupoAutomovel> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM GrupoAutomovel e");
        List<GrupoAutomovel> list = query.getResultList();
        return list;
    }
}
