/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Materias;


/**
 *
 * @author ferchs
 */
public class Materia extends AbstractFacade{
    private EntityManager em;
    private Materias materia;

    public Materia() {
        super(Materias.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Materias crearMateria(int codigo,String nombre){
        materia= new Materias();
        materia.setCodigoMateria(codigo);
        materia.setNombre(nombre);
        super.create(materia);
        return materia;
    }
    
    public Materias editarMateria(int codigo,String nombre){
        materia= buscarMateriaPorId(codigo);
        em.detach(materia);
        materia.setNombre(nombre);
        em.getTransaction().begin();
        em.merge(materia);
        em.getTransaction().commit();
        return materia;
    }
    
    public Materias buscarMateriaPorId(int codigo){
        Materias materia=(Materias) super.find(codigo);
        return materia;
    }
    
    public boolean eliminarMateria(int codigo){
        boolean fueEliminado=false;
        Materias materia= buscarMateriaPorId(codigo);
        try{
              super.remove(materia);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
