package org.iton.messenger.model.model;

import org.iton.messenger.model.entities.ETContact;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public class EMContact extends EntityModel <ETContact, Integer>{

    public EMContact(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<ETContact> findAll() {
        List<ETContact> contacts = new ArrayList<>();
        return contacts;
    }
}
