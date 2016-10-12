package org.iton.messenger.model.engines;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.model.model.EMAuthorization;
import org.iton.messenger.model.model.EMMessage;
import org.iton.messenger.model.model.EMParams;
import org.iton.messenger.model.model.EMUser;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by ITON on 9/6/14.
 */
public class TelegramEngine implements ITelegramEngine {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(TelegramEngine.class);

    private EntityManagerFactory emf;

    private EMUser userModel;
    private EMAuthorization authModel;
    private EMMessage messageModel;
    private EMParams paramsModel;

    public TelegramEngine(){

        this.emf = Persistence.createEntityManagerFactory("iton");

        this.userModel      = new EMUser(emf);
        this.messageModel   = new EMMessage(emf);
        this.paramsModel    = new EMParams(emf);
        this.authModel      = new EMAuthorization(emf);
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    @Override
    public EMUser getUserModel(){
        return userModel;
    }

    @Override
    public EMMessage getMessageModel(){
        return messageModel;
    }

    @Override
    public EMParams getParamsModel(){
        return paramsModel;
    }

    @Override
    public EMAuthorization getAuthorizationModel(){
        return authModel;
    }
}
