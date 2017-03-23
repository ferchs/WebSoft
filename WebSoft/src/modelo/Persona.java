/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class Persona extends AbstractFacade{
    
    private EntityManager em;

    public Persona() {
        super(Personas.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
