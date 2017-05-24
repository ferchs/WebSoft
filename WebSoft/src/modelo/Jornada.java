/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Jornadas;


/**
 *
 * @author ferchs
 */
public class Jornada extends AbstractFacade{
    private EntityManager em;
    private Jornadas jornada;

    public Jornada() {
        super(Jornadas.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Jornadas crearJornada(int idJornada,String nombre, String horaInicio, String horaFin){
        jornada= new Jornadas();
        jornada.setIdJornada(idJornada);
        jornada.setNombre(nombre);
        jornada.setHoraInicio(horaInicio);
        jornada.setHoraFin(horaFin);
        super.create(jornada);
        return jornada;
    }
    
    public Jornadas editarJornada(int idJornada,String nombre, String horaInicio, String horaFin){
        jornada= buscarJornadaPorId(idJornada);
        em.detach(jornada);
        jornada.setIdJornada(idJornada);
        jornada.setNombre(nombre);
        jornada.setHoraInicio(horaInicio);
        jornada.setHoraFin(horaFin);
        em.getTransaction().begin();
        em.merge(jornada);
        em.getTransaction().commit();
        return jornada;
    }
    
    public Jornadas buscarJornadaPorId(int idJornada){
        Jornadas jornada=(Jornadas) super.find(idJornada);
        return jornada;
    }
    
    public boolean eliminarJornada(int idJornada){
        boolean fueEliminado=false;
        Jornadas jornada= buscarJornadaPorId(idJornada);
        try{
              super.remove(jornada);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
