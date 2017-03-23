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
     
    public Administrador() {
        super(Administradores.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void CrearAdministrador(Personas persona, String usuario, String contraseña){
        this.persona.create(persona);
        Administradores admin= new Administradores(usuario,contraseña);
        admin.setPersona(persona);
    }
    
    public void EliminarAdministrador (String usuario, String contraseña ){
        
        super.find(em);
    }
    
    public Administradores BuscarAdministrador(){
        super.find();
    }
    
}
