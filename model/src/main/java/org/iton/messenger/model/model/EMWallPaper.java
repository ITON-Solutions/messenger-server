package org.iton.messenger.model.model;

import org.iton.messenger.model.entities.ETWallPaper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public class EMWallPaper extends EntityModel <ETWallPaper, Integer>{

    public EMWallPaper(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<ETWallPaper> findAll() {
        Query q = em.createQuery("select w from ETWallPaper w");
        List<ETWallPaper> result = q.getResultList();
        return result;
    }
}
