package org.iton.messenger.model.engines;

import org.iton.messenger.model.model.EMAuthorization;
import org.iton.messenger.model.model.EMMessage;
import org.iton.messenger.model.model.EMParams;
import org.iton.messenger.model.model.EMUser;

import javax.persistence.EntityManagerFactory;

/**
 * Created by ITON on 9/6/14.
 */
public interface ITelegramEngine {
    EntityManagerFactory getEntityManagerFactory();

    EMUser getUserModel();

    EMMessage getMessageModel();

    EMParams getParamsModel();

    EMAuthorization getAuthorizationModel();

}
