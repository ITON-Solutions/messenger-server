package org.iton.messenger.model.model;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by ITON Solutions on 8/21/16.
 */
public interface IEntityModel<E, K> {

    E save(E entity);

    E update(E entity);

    void remove(E entity);

    public <E> E findById(Class<E> clazz, final K id);

    List<E> findAll();

}
