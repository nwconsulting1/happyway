/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

/**
 *
 * @author Lucas de Andrade
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("happywaywebPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void fechaEntityManager(){
        emf.close();
    }
}
