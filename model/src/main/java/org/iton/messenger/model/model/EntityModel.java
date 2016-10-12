package org.iton.messenger.model.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public abstract class EntityModel <E, K> implements IEntityModel<E, K> {

    protected EntityManagerFactory emf = null;
    protected EntityManager em         = null;

    @Override
    public E save(final E entity) throws PersistenceException {
        em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(entity);
        tr.commit();
        em.close();
        return entity;
    }

    @Override
    public E update(final E entity) {
        em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        E result = em.merge(entity);
        tr.commit();
        em.close();
        return result;
    }

    @Override
    public void remove(final E entity) {
        em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(em.merge(entity));
        tr.commit();
        em.close();
    }

    @Override
    public <E> E findById(Class<E> clazz, final K id) {
        em = emf.createEntityManager();
        E result = em.find(clazz, id);
        if(em.isOpen())  em.close();
        return result;
    }
}
