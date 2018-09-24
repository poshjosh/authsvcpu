/*
 * Copyright 2016 NUROX Ltd.
 *
 * Licensed under the NUROX Ltd Software License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.looseboxes.com/legal/licenses/software.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.authsvc.pu;

import com.authsvc.pu.entities.App;
import com.bc.jpa.dao.JpaObjectFactory;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bc.jpa.dao.Select;
import com.bc.jpa.dao.sql.MySQLDateTimePatterns;

/**
 * @author Josh
 */
public class AuthsvcJpaContextTest {
    
    public AuthsvcJpaContextTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAll() throws IOException, URISyntaxException {
        
        final String name = "META-INF/persistence.xml";
        
        URI uri = URI.create(name);
System.out.println("URI.create: "+uri);

        uri = Thread.currentThread().getContextClassLoader().getResource(name).toURI();
System.out.println("ClassLoader.getResource: "+uri);        
        
//        final AuthsvcJpaContext jpa = new AuthsvcJpaContext();
        
//        final JpaObjectFactory jpaContext = jpa.getDefaultContext();
        try(final JpaObjectFactory jpaContext = new AuthsvcJpaObjectFactory(new MySQLDateTimePatterns())) {
        
            try(Select<App> qb = jpaContext.getDaoForSelect(App.class)) {

                List<App> appList = qb.from(App.class).createQuery().getResultList();

                for(App app:appList) {

System.out.println("App:: ID: "+app.getAppid()+", name: "+app.getUsername()+", email: "+app.getEmailaddress());                
                }
            }
        }
    }
}
