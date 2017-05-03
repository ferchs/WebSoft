/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.DocumentoIdentidad;
import modelo.entidades.Estudiantes;
import modelo.entidades.InformacionContacto;
import modelo.entidades.InformacionMedica;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class Estudiante extends AbstractFacade{
    
    private Estudiantes estudiante;

    public Estudiante() {
        super(Estudiantes.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebSoftPU");
        return emf.createEntityManager();
    }
    
    public void crearEstudiante(Personas persona){
        estudiante= new Estudiantes();
        estudiante.setPersonasnumeroidentificacion(persona.getNumeroIdentificacion());
        estudiante.setPersonas(persona);
        super.create(estudiante);
    }
}
