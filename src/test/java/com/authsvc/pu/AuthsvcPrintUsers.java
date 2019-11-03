/*
 * Copyright 2018 NUROX Ltd.
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
import com.authsvc.pu.entities.Appuser;
import com.bc.jpa.dao.JpaObjectFactory;
import com.bc.jpa.dao.Select;
import com.bc.jpa.dao.functions.GetColumnNames;
import com.bc.jpa.dao.functions.GetEntityClasses;
import com.bc.jpa.dao.sql.MySQLDateTimePatterns;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManagerFactory;

/**
 * @author Chinomso Bassey Ikwuagwu on Nov 12, 2018 9:08:25 AM
 */
public class AuthsvcPrintUsers {
    
    public AuthsvcPrintUsers() { }
    
//    public static void main(String... args) {
//        try{
//            new AuthsvcJpaContextTest().testAll();
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
    
//    @Test
    public void testAll() throws IOException, URISyntaxException {
        
        final String name = "META-INF/persistence.xml";
        
        URI uri = URI.create(name);
System.out.println("URI.create: "+uri);

        uri = Thread.currentThread().getContextClassLoader().getResource(name).toURI();
System.out.println("ClassLoader.getResource: "+uri);        
        
//        final AuthsvcJpaContext jpa = new AuthsvcJpaContext();
        
//        final JpaObjectFactory jpaContext = jpa.getDefaultContext();
        try(final JpaObjectFactory jpaContext = new AuthsvcJpaObjectFactory(new MySQLDateTimePatterns())) {
            
            final EntityManagerFactory emf = jpaContext.getEntityManagerFactory();
            final Set<Class> entityClasses = new GetEntityClasses().apply(emf);
            for(Class entityClass : entityClasses) {
                final List<String> columnNames = new GetColumnNames(emf).apply(entityClass);
                System.out.println("Entity: " + entityClass.getSimpleName() + ", columns: " + columnNames);
            }        
        
            try(Select<App> select = jpaContext.getDaoForSelect(App.class)) {

                final List<App> appList = select.from(App.class).createQuery().getResultList();

                for(App app : appList) {

                    System.out.println("\n\nApp:: ID: "+app.getAppid()+", name: "+
                            app.getUsername()+", email: "+app.getEmailaddress());                
                    
                    try(Select<Appuser> selectUsers = jpaContext.getDaoForSelect(Appuser.class)) {

                        final List<Appuser> userList = selectUsers.from(Appuser.class).createQuery().getResultList();

                        for(Appuser appuser : userList) {
                            
                            System.out.println("Appuser:: ID: " + appuser.getAppuserid() + ", name: " +
                                    appuser.getUsername() + ", email: " + appuser.getEmailaddress());                
                        }
                    }
                }
            }
            
            if(true) {
                return;
            }
            
            try(Select<Appuser> select = jpaContext.getDaoForSelect(Appuser.class)) {
             
                final Map parameters = new HashMap();
                parameters.put("appid", 1);
                parameters.put("emailaddress", "posh.bc@gmail.com");
//                parameters.put("emailAddress", "posh.bc@gmail.com");
                
                select.where(parameters);
                
                final List<Appuser> resultList = select.createQuery().getResultList();
                resultList.stream().forEach((user) -> {
System.out.println("App user ID: " + user.getAppuserid() + ", appid: " + user.getAppid().getAppid() + ", " + user.getEmailaddress());                
                });
            }
        }
    }
}
