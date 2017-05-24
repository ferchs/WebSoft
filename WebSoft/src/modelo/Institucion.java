/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Instituciones;

/**
 *
 * @author ferchs
 */
public class Institucion extends AbstractFacade {
    
    private EntityManager em;
    private Instituciones institucion;
    
    
    public Institucion() {
        super(Instituciones.class);
    }
    
    public Instituciones crearInstitucion(int nit, String nombre, String direccion, String telefono, String email){
        
        institucion= new Instituciones();
        institucion.setNit(nit);
        institucion.setNombre(nombre);
        institucion.setDireccion(direccion);
        institucion.setTelefono(telefono);
        institucion.setCorreo(email);
        super.create(institucion);
        return institucion;
    }
    
    public boolean existeInstitucion(){
        return !super.findAll().isEmpty();
    }

    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();    
    }
    
}
