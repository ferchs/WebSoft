/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class Persona extends AbstractFacade{
        
    private Personas persona;

    public Persona() {
        super(Personas.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebSoftPU");
        return emf.createEntityManager();
    }
    
    public Personas crearPersona(String numeroId, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido){
        persona= new Personas();
        persona.setNumeroIdentificacion(numeroId);
        persona.setPrimerNombre(primerNombre);
        persona.setSegundoNombre(segundoNombre);
        persona.setPrimerApellido(primerApellido);
        persona.setSegundoApellido(segundoApellido);
        super.create(persona);
        return persona;
    }
}
