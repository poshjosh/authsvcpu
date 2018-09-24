package com.authsvc.pu;

import com.authsvc.pu.entities.App;
import com.authsvc.pu.entities.Apptoken;
import com.authsvc.pu.entities.Appuser;
import com.authsvc.pu.entities.Userstatus;
import com.authsvc.pu.entities.Usertoken;
import com.bc.jpa.dao.functions.EntityManagerFactoryCreator;
import com.bc.jpa.context.PersistenceUnitContext;
import com.bc.jpa.context.eclipselink.PersistenceContextEclipselinkOptimized;
import com.bc.jpa.metadata.PersistenceMetaData;
import com.bc.jpa.dao.sql.MySQLDateTimePatterns;
import com.bc.jpa.dao.sql.SQLDateTimePatterns;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Josh
 */
public class AuthsvcJpaContext extends PersistenceContextEclipselinkOptimized {
    
    public AuthsvcJpaContext() throws URISyntaxException {
        this(Thread.currentThread().getContextClassLoader().getResource("META-INF/persistence.xml").toURI(),
                new MySQLDateTimePatterns());
    }

    public AuthsvcJpaContext(SQLDateTimePatterns dateTimePatterns) {
        super(dateTimePatterns, 
                App.class, Apptoken.class, Appuser.class, Userstatus.class, Usertoken.class);
    }
    
    public AuthsvcJpaContext(URI persistenceConfigUri, SQLDateTimePatterns dateTimePatterns) {
        super(persistenceConfigUri, dateTimePatterns);
    }

    public AuthsvcJpaContext(EntityManagerFactoryCreator emfCreator, SQLDateTimePatterns dateTimePatterns) {
        super(emfCreator, dateTimePatterns, 
                App.class, Apptoken.class, Appuser.class, Userstatus.class, Usertoken.class);
    }

    public AuthsvcJpaContext(URI persistenceConfigUri, EntityManagerFactoryCreator emfCreator, SQLDateTimePatterns dateTimePatterns) {
        super(persistenceConfigUri, emfCreator, dateTimePatterns);
    }

    public AuthsvcJpaContext(PersistenceMetaData metaData, EntityManagerFactoryCreator emfCreator, SQLDateTimePatterns dateTimePatterns) {
        super(metaData, emfCreator, dateTimePatterns);
    }
    
    public PersistenceUnitContext getDefaultContext() {
        return this.getContext(AuthsvcJpaObjectFactory.PERSISTENCE_UNIT_NAME);
    }
}
