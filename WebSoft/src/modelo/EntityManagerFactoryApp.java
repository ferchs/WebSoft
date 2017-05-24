/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ferchs
 */
public class EntityManagerFactoryApp {
    
    private static EntityManagerFactoryApp instance = null;
    
    private static EntityManagerFactory emf;

    protected EntityManagerFactoryApp(){
        emf = Persistence.createEntityManagerFactory("WebSoftPU");
    }
    
    public static EntityManagerFactoryApp getInstance() {
        if(instance == null) {
            instance = new EntityManagerFactoryApp();
        }
      return instance;
   }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
