package org.iton.messenger.model.model;

import org.iton.messenger.model.entities.ETUser;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public class EMUser extends EntityModel <ETUser, Integer> {

    public EMUser(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<ETUser> findAll() {
        em = emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM ETUser u");
        List<ETUser> result = q.getResultList();
        em.close();
        return result;
    }

    public ETUser findByPhone(String phone) {
        ETUser user = null;
        em = emf.createEntityManager();
        TypedQuery<ETUser> query = em.createQuery("SELECT u FROM ETUser u WHERE u.phone =:phone", ETUser.class);
        query.setParameter("phone", phone);
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {

        } finally {
            em.close();
        }

        return user;
    }

    public ETUser findLikePhone(String phone) {
        ETUser user = null;
        em = emf.createEntityManager();
        TypedQuery<ETUser> query = em.createQuery("SELECT u FROM ETUser u WHERE u.phone LIKE :phone", ETUser.class);
        query.setParameter("phone", "%" + phone);
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {

        } finally {
            em.close();
        }

        return user;
    }

    public Integer getId() {

        BigInteger result = BigInteger.valueOf(0);

        em = emf.createEntityManager();
        Query query = em.createNativeQuery(
                "SELECT tables.AUTO_INCREMENT " +
                "FROM INFORMATION_SCHEMA.TABLES tables " +
                "WHERE tables.TABLE_SCHEMA = DATABASE() AND tables.TABLE_NAME ='" + ETUser.class.getAnnotation(Table.class).name() + "'");
        try {
            result = (BigInteger) query.getSingleResult();
        } catch (NoResultException e) {

        } finally {
            em.close();
        }
        return result.intValue();
    }
}
