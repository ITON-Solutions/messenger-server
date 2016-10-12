package org.iton.messenger.model.model;

import org.iton.messenger.model.entities.ETMessage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public class EMMessage extends EntityModel <ETMessage, Integer>{

    public EMMessage(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<ETMessage> findAll() {
        List<ETMessage> messages = new ArrayList<>();
        return messages;
    }

    public void  deleteByIds(List<Integer> ids)
    {
        em = emf.createEntityManager();
        TypedQuery<ETMessage> query = em.createQuery("DELETE FROM ETMessage m WHERE m.id IN :ids", ETMessage.class);
        query.setParameter("ids", ids);
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            query.executeUpdate();
            tr.commit();
        } catch ( NoResultException e) {
            tr.rollback();
        } finally {
            em.close();
        }
    }

    public List<ETMessage> findByUser(Integer user_id, Integer from_id)
    {
        List<ETMessage> messages = new ArrayList<>();
        em = emf.createEntityManager();
        TypedQuery<ETMessage> query = em.createQuery("SELECT m FROM ETMessage m WHERE m.user_id =:user_id AND m.from_id =:from_id", ETMessage.class);
        query.setParameter("user_id", user_id);
        query.setParameter("from_id", from_id);
        try {
            messages = query.getResultList();
        } catch ( NoResultException e) {

        } finally {
            em.close();
        }

        return messages;
    }

    public List<ETMessage> findUnread(Integer user_id, Integer from_id, Integer max_id, Integer offset)
    {
        List<ETMessage> messages = new ArrayList<>();
        em = emf.createEntityManager();
        TypedQuery<ETMessage> query = em.createQuery("SELECT m FROM ETMessage m WHERE m.user_id =:user_id AND m.from_id =:from_id AND m.read_state=:read_state ORDER BY m.date", ETMessage.class);
        query.setParameter("user_id", user_id);
        query.setParameter("from_id", from_id);
        query.setParameter("read_state", 0);

        try {
            messages = query.getResultList();
        } catch ( NoResultException e) {

        } finally {
            em.close();
        }

        return messages;
    }

    public ETMessage findByRandom(Long random_id)
    {
        ETMessage messages = null;
        em = emf.createEntityManager();
        TypedQuery<ETMessage> query = em.createQuery("SELECT m FROM ETMessage m WHERE m.random_id =:random_id", ETMessage.class);
        query.setParameter("random_id", random_id);
        try {
            messages = query.getSingleResult();
        } catch ( NoResultException e) {

        } finally {
            em.close();
        }

        return messages;
    }


}
