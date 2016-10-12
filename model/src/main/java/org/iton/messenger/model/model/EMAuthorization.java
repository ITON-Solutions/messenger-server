/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iton.messenger.model.model;

import org.iton.messenger.model.entities.ETAuthorization;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.iton.messenger.proto.secure.CryptoUtils.ToHex;

/**
 *
 * @author ITON
 */
public class EMAuthorization extends EntityModel <ETAuthorization, String> {

    public EMAuthorization(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ETAuthorization findById(byte[] keyId){
        em = emf.createEntityManager();
        ETAuthorization result = findById(ETAuthorization.class, ToHex(keyId));
        if (em.isOpen()) em.close();
        return result;
    }

    public ETAuthorization findById(String keyId){
        return findById(ETAuthorization.class, keyId);
    }


    @Override
    public List<ETAuthorization> findAll() {
        em = emf.createEntityManager();
        TypedQuery<ETAuthorization> query = em.createQuery("SELECT a FROM ETAuthorization a", ETAuthorization.class);
        List<ETAuthorization> result = query.getResultList();
        em.close();
        return result;
    }

    public ETAuthorization findByUser(Integer user_id)
    {
        em = emf.createEntityManager();
        TypedQuery<ETAuthorization> query = em.createQuery("SELECT a FROM ETAuthorization a WHERE a.user.id =:user_id", ETAuthorization.class);
        query.setParameter("user_id", user_id);
        ETAuthorization auth = query.getSingleResult();
        em.close();
        return auth;
    }

    public void deleteById(byte[] key_id, Integer user_id) {
        em = emf.createEntityManager();
        TypedQuery<ETAuthorization> query = em.createQuery("DELETE FROM ETAuthorization a WHERE a.user.id =:user_id AND a.key_id <>:key_id", ETAuthorization.class);
        query.setParameter("user_id", user_id);
        query.setParameter("key_id", ToHex(key_id));
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        query.executeUpdate();
        tr.commit();
        em.close();
    }
}
