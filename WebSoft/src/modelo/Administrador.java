/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import modelo.entidades.Administradores;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class Administrador extends AbstractFacade{
    private EntityManager em;
     
     private Persona persona;
     private Criptografia criptografia;
     
    public Administrador() {
        super(Administradores.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void CrearAdministrador(Personas persona, String usuario, String contraseña, String email){
        this.persona.create(persona);
        Administradores admin= new Administradores(usuario,contraseña,email);
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
    
}
