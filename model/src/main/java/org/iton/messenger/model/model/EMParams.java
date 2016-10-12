package org.iton.messenger.model.model;

import org.iton.messenger.model.entities.ETParams;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public class EMParams extends EntityModel <ETParams, Integer>{

    public EMParams(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<ETParams> findAll() {
        List<ETParams> params = new ArrayList<>();
        return params;
    }

    public ETParams findByUser(Integer user_id)
    {
        ETParams params = null;
        em = emf.createEntityManager();
        TypedQuery<ETParams> query = em.createQuery("SELECT p FROM ETParams p WHERE p.user_id =:user_id", ETParams.class);
        query.setParameter("user_id", user_id);
        try {
            params = query.getSingleResult();
        } catch ( NoResultException e) {

        } finally {
            if(em.isOpen()) {
                em.close();
            }
        }

        return params;
    }



}
