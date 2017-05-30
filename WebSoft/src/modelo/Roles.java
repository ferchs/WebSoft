/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Rol;

/**
 *
 * @author ferchs
 */
public class Roles extends AbstractFacade {

    private EntityManager em;

    public Roles() {
        super(Rol.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Rol crearRol(String nombreRol){
        Rol rol= buscarRol(nombreRol);
        if(rol==null){
            rol= new Rol();
            rol.setNombre(nombreRol);
            super.create(rol);
        }
        rol=buscarRol(nombreRol);
        return rol;
    }
    
    public Rol buscarRol(String rol){
        List roles=super.findAll();
        for(int i=0; i< roles.size();i++){
            Rol r= (Rol) roles.get(i);
            if(r.getNombre().equals(rol)){
                return r;
            }
        }
        return null;
    }
    
    
    
}
