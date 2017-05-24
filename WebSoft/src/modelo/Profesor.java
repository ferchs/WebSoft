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
import modelo.entidades.Personas;
import modelo.entidades.Profesores;

/**
 *
 * @author ferchs
 */
public class Profesor extends AbstractFacade{
    private EntityManager em;
    private Profesores profesor;

    public Profesor() {
        super(Profesores.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Profesores crearProfesor(Personas persona,String titulo, String institucion){
        profesor= new Profesores();
        profesor.setPersonasnumeroidentificacion(persona.getNumeroIdentificacion());
        profesor.setPersonas(persona);
        profesor.setTitulo(titulo);
        profesor.setInstitucion(institucion);
        super.create(profesor);
        return profesor;
    }
    
    public Profesores editarProfesor(Personas persona,String titulo, String institucion){
        profesor= buscarProfesorPorId(persona.getNumeroIdentificacion());
        em.detach(profesor);
        profesor.setPersonasnumeroidentificacion(persona.getNumeroIdentificacion());
        profesor.setPersonas(persona);
        profesor.setTitulo(titulo);
        profesor.setInstitucion(institucion);
        em.getTransaction().begin();
        em.merge(profesor);
        em.getTransaction().commit();
        return profesor;
    }
    
    public Profesores buscarProfesorPorId(String idProfesor){
        Profesores profe=(Profesores) super.find(idProfesor);
        return profe;
    }
    
    public ArrayList<Profesores> buscarProfesorPorComodin(String comodin){
        List <Profesores> profesores=super.findAll();
        ArrayList <Profesores> resultadoBusqueda= new ArrayList();
        for(int i=0;i<profesores.size();i++){
            StringBuilder nombre= new StringBuilder();
            Profesores tmp=buscarProfesorPorId(profesores.get(i).getPersonasnumeroidentificacion());
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
    
    public Profesores buscarProfesorPorNombre(String primerNombre,String segundoNombre, String primerApellido, String segundoApellido){
        Profesor profe= new Profesor();
        boolean encontrado=false;
        List<Profesores> profesores=profe.findAll();
        Profesores profesorTmp=null;
        for(int i=0;i<profesores.size() && !encontrado;i++){
            profesorTmp=profesores.get(i);
            String pmrNombre=profesorTmp.getPersonas().getPrimerNombre();
            String sdoNombre=profesorTmp.getPersonas().getSegundoNombre();
            String pmrApellido=profesorTmp.getPersonas().getPrimerApellido();
            String sdoApellido=profesorTmp.getPersonas().getSegundoApellido();
            if(primerNombre.equalsIgnoreCase(pmrNombre) && segundoNombre.equalsIgnoreCase(sdoNombre) 
                && primerApellido.equalsIgnoreCase(pmrApellido) && segundoApellido.equalsIgnoreCase(sdoApellido) ){
                encontrado=true;
            }
        }
        return profesorTmp;
    }
    
    public boolean eliminarProfesor(String idProfesor){
        boolean fueEliminado=false;
        Profesores profe= buscarProfesorPorId(idProfesor);
        try{
              super.remove(profe);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
