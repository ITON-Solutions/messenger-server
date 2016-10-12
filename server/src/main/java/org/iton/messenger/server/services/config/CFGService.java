package org.iton.messenger.server.services.config;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by ITON on 11/23/14.
 */
public class CFGService implements ICFGService {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(CFGService.class);

    private static CFGService instance = null;
    private Configuration config       = null;

    public static CFGService getInstance(){
        if(instance == null){
            try {
                instance = new CFGService();
            } catch (ConfigurationException e) {
                log.error(e.getMessage());
            }
        }
        return instance;
    }

    private CFGService() throws ConfigurationException {
        config = new PropertiesConfiguration("org.iton.messenger.server.properties");
    }

    @Override
    public Configuration getConfiguration() {
        return config;
    }
}
