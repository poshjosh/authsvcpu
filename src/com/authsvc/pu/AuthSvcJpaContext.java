package com.authsvc.pu;

import com.bc.jpa.JpaContextImpl;
import com.bc.jpa.util.PersistenceURISelector;
import com.bc.sql.SQLDateTimePatterns;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Josh
 */
public class AuthSvcJpaContext extends JpaContextImpl {
    
    public static enum userstatus{Unactivated, Activated, Deactivated, Unregistered}

    public AuthSvcJpaContext() throws IOException, URISyntaxException {
        super(Thread.currentThread().getContextClassLoader().getResource("META-INF/persistence.xml").toURI(), 
                new Class[]{userstatus.class});
    }

    public AuthSvcJpaContext(String persistenceFile, PersistenceURISelector.URIFilter uriFilter, SQLDateTimePatterns dateTimePatterns) throws IOException {
        super(persistenceFile, uriFilter, dateTimePatterns, new Class[]{userstatus.class});
    }

    public AuthSvcJpaContext(URI persistenceFile) throws IOException {
        super(persistenceFile, new Class[]{userstatus.class});
    }

    public AuthSvcJpaContext(URI persistenceFile, SQLDateTimePatterns dateTimePatterns) throws IOException {
        super(persistenceFile, dateTimePatterns, new Class[]{userstatus.class});
    }

    public AuthSvcJpaContext(File persistenceFile, SQLDateTimePatterns dateTimePatterns) throws IOException {
        super(persistenceFile, dateTimePatterns, new Class[]{userstatus.class});
    }
}
