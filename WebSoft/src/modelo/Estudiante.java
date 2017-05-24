/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.entidades.Estudiantes;
import modelo.entidades.Personas;
import modelo.entidades.RolResponsable;

/**
 *
 * @author ferchs
 */
public class Estudiante extends AbstractFacade{
    private EntityManager em;
    private Estudiantes estudiante;

    public Estudiante() {
        super(Estudiantes.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Estudiantes crearEstudiante(Personas persona){
        estudiante= new Estudiantes();
        estudiante.setPersonasnumeroidentificacion(persona.getNumeroIdentificacion());
        estudiante.setPersonas(persona);
        super.create(estudiante);
        return estudiante;
    }
    
    public Estudiantes editarEstudiante(Personas persona){
        estudiante= buscarEstudiantePorId(persona.getNumeroIdentificacion());
        em.detach(estudiante);
        estudiante.setPersonasnumeroidentificacion(persona.getNumeroIdentificacion());
        estudiante.setPersonas(persona);
        em.getTransaction().begin();
        em.merge(estudiante);
        em.getTransaction().commit();
        return estudiante;
    }
    
    public Estudiantes buscarEstudiantePorId(String idEstudiante){
        Estudiantes estudiante=(Estudiantes) super.find(idEstudiante);
        return estudiante;
    }
    
    public ArrayList<Estudiantes> buscarEstudiantePorComodin(String comodin){
        List <Estudiantes> estudiantes=super.findAll();
        ArrayList <Estudiantes> resultadoBusqueda= new ArrayList();
        for(int i=0;i<estudiantes.size();i++){
            StringBuilder nombre= new StringBuilder();
            Estudiantes tmp=buscarEstudiantePorId(estudiantes.get(i).getPersonasnumeroidentificacion());
            nombre.append(tmp.getPersonas().getPrimerNombre());
            nombre.append(tmp.getPersonas().getSegundoNombre());
            nombre.append(tmp.getPersonas().getPrimerApellido());
            nombre.append(tmp.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString().toLowerCase();
            if(nombreCompleto.contains(comodin)){
                resultadoBusqueda.add(tmp);
            }
        }
        return resultadoBusqueda;
    }
    
    public boolean EliminarEstudiante(String idEstudiante){
        boolean fueEliminado=false;
        Estudiantes estud= buscarEstudiantePorId(idEstudiante);
        try{
              super.remove(estud);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
