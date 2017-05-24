/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.Administradores;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class Administrador extends AbstractFacade{
    private EntityManager em;
    private Criptografia criptografia;
    private Administradores admin;
     
    public Administrador() {
        super(Administradores.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public void crearAdministrador(Personas persona, String usuario, String contraseña, String email){
        
        admin= new Administradores();
        admin.setUsuario(usuario);
        admin.setContraseña(contraseña);
        admin.setEmail(email);
        admin.setPersona(persona);
        super.create(admin);
    }
    
    public boolean EliminarAdministrador (String cedula, String usuario, String contraseña ){
        boolean fueEliminado=false;
          Administradores admin= BuscarAdministrador(usuario);
          if(admin!=null){
              String documentoIdentidad=admin.getPersona().getNumeroIdentificacion();
                if(admin.getContraseña().equals(contraseña) && documentoIdentidad.equals(cedula)){
                    super.remove(admin);
                    fueEliminado=true;
                } 
          }
          return fueEliminado;
    }
    
    public Administradores BuscarAdministrador(String usuario){
        return (Administradores) super.find(usuario);
    }
    
    public Administradores BuscarAdministradorPorEmail(String email){
        List<Administradores> administradores=super.findAll();
        for(Administradores admin : administradores){
            if(admin.getEmail().equals(email)){
                return admin;
            }
        }
        return null;
    }
    
    public boolean existenAdministradores(){
        return !super.findAll().isEmpty();
    }
    
    
}
