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
import modelo.entidades.Salones;

/**
 *
 * @author ferchs
 */
public class Salon extends AbstractFacade{
    private EntityManager em;
    private Salones salon;

    public Salon() {
        super(Salones.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Salones crearSalon(int idSalon,String nombre, String piso){
        salon= new Salones();
        salon.setIdSalon(idSalon);
        salon.setNombre(nombre);
        salon.setPiso(piso);
        super.create(salon);
        return salon;
    }
    
    public Salones editarSalon(int idSalon,String nombre, String piso){
        salon= buscarSalonPorId(idSalon);
        em.detach(salon);
        salon.setIdSalon(idSalon);
        salon.setNombre(nombre);
        salon.setPiso(piso);
        em.getTransaction().begin();
        em.merge(salon);
        em.getTransaction().commit();
        return salon;
    }
    
    public Salones buscarSalonPorId(int idSalon){
        Salones salon=(Salones) super.find(idSalon);
        return salon;
    }
    
    public boolean eliminarSalon(int idSalon){
        boolean fueEliminado=false;
        Salones salon= buscarSalonPorId(idSalon);
        try{
              super.remove(salon);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
