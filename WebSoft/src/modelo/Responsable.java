/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.Estudiantes;
import modelo.entidades.Personas;
import modelo.entidades.Rol;
import modelo.entidades.RolResponsable;
import modelo.entidades.RolResponsablePK;
import static modelo.entidades.RolResponsable_.rolResponsablePK;

/**
 *
 * @author ferchs
 */
public class Responsable extends AbstractFacade{
    private RolResponsable rolResponsable;

    public Responsable() {
        super(RolResponsable.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return emf.createEntityManager();
    }
    
    public RolResponsable crearResponsable(Rol rol, Personas persona, Estudiantes estudiante,String profesion){
        rolResponsable= new RolResponsable();
        RolResponsablePK id= new RolResponsablePK(rol.getIdRol(),persona.getNumeroIdentificacion(),estudiante.getPersonasnumeroidentificacion());
        id.setEstudiante(estudiante.getPersonasnumeroidentificacion());
        rolResponsable.setRolResponsablePK(id);
        rolResponsable.setProfesion(profesion);
        super.create(rolResponsable);
        return rolResponsable;
    }
    
    public RolResponsable editarResponsable(Rol rol, Personas persona, Personas estudiante,String profesion){
        rolResponsable= new RolResponsable();
        RolResponsablePK id= new RolResponsablePK(rol.getIdRol(),persona.getNumeroIdentificacion(),estudiante.getNumeroIdentificacion());
        id.setEstudiante(estudiante.getNumeroIdentificacion());
        rolResponsable.setRolResponsablePK(id);
        rolResponsable.setProfesion(profesion);
        rolResponsable.setRol(rol);
        super.edit(rolResponsable);
        return rolResponsable;
    }
}
