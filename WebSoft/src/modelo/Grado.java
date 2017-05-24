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
import modelo.entidades.Grados;
import modelo.entidades.GradosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.Materias;

/**
 *
 * @author ferchs
 */
public class Grado extends AbstractFacade{
    private EntityManager em;
    private Grados grado;

    public Grado() {
        super(Grados.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Grados crearGrado(Instituciones institucion,String nombre, ArrayList<Materias> idMaterias){
        grado= new Grados();
        GradosPK idGrado= encontarId(institucion);
        grado.setGradosPK(idGrado);
        grado.setNombre(nombre);
        grado.setMateriasCollection(idMaterias);
        super.create(grado);
        return grado;
    }
    
    private GradosPK encontarId(Instituciones institucion){
        int i=1;
        GradosPK idGrado=new GradosPK();
        idGrado.setInstitucionesnit(institucion.getNit());
        while(true){
            idGrado.setIdGrado(i);
            Grados tmp=(Grados) super.find(idGrado);
            if(tmp==null){
                return idGrado;
            }
            else{
                i++;
            }
        }
    }
    
    public Grados editarGrado(Instituciones institucion,String nombre, ArrayList<Materias> idMaterias){
        grado= buscarGradoPorNombre(nombre);
        em.detach(grado);
        grado.setNombre(nombre);
        grado.setMateriasCollection(idMaterias);
        em.getTransaction().begin();
        em.merge(grado);
        em.getTransaction().commit();
        return grado;
    }
    
    public Grados buscarGradoPorNombre(String nombreGrado){
        List<Grados> grados=super.findAll();
        for(int i=0;i<grados.size();i++){
            String nombre=grados.get(i).getNombre();
            if(nombre.equalsIgnoreCase(nombreGrado)){
                return grados.get(i);
            }
        }
        return null;
    }
    
    public Grados buscarGradoPorId(GradosPK idGrado){
       return (Grados) super.find(idGrado);
    }

    
    public boolean eliminarGrado(String nombreGrado){
        boolean fueEliminado=false;
        Grados grado= buscarGradoPorNombre(nombreGrado);
        try{
              super.remove(grado);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
