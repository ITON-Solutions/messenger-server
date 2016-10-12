package org.iton.messenger.server.services.db;


import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.model.engines.ITelegramEngine;
import org.iton.messenger.model.engines.TelegramEngine;

public class DBService implements IDBService {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(DBService.class);

    private static DBService instance = null;
    private final ITelegramEngine engine;

    private DBService(){
        engine = new TelegramEngine();
    }

    public static DBService getInstance(){
        if(instance == null){
            instance = new DBService();
        }
        return instance;
    }

    @Override
    public ITelegramEngine getEngine() {
        return engine;
    }

}
