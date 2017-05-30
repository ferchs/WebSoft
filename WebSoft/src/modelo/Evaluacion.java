/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Evaluaciones;
import modelo.entidades.EvaluacionesPK;

/**
 *
 * @author ferchs
 */
public class Evaluacion extends AbstractFacade{
    private EntityManager em;
    private Evaluaciones evaluacion;

    public Evaluacion() {
        super(Evaluaciones.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Evaluaciones crearEvaluacion(int institucion, int idGrado,int consecutivo, int idMateria, String tema, double porcentaje) throws MySQLIntegrityConstraintViolationException {
        evaluacion= new Evaluaciones();
        EvaluacionesPK idEvaluacion=new EvaluacionesPK();
        idEvaluacion.setCursosInstitucion(institucion);
        idEvaluacion.setCursosGrado(idGrado);
        idEvaluacion.setCursosConsecutivocurso(consecutivo);
        idEvaluacion.setCursosMateria(idMateria);
        idEvaluacion.setTema(tema);
        evaluacion.setEvaluacionesPK(idEvaluacion);
        evaluacion.setPorcentaje(porcentaje);
        super.create(evaluacion);
        return evaluacion;
    }
    
    public Evaluaciones editarEvaluacion(int institucion, int idGrado,int consecutivo, int idMateria, String tema, double porcentaje){
        EvaluacionesPK idEvaluacion=new EvaluacionesPK();
        idEvaluacion.setCursosInstitucion(institucion);
        idEvaluacion.setCursosGrado(idGrado);
        idEvaluacion.setCursosConsecutivocurso(consecutivo);
        idEvaluacion.setCursosMateria(idMateria);
        idEvaluacion.setTema(tema);
        Evaluaciones evaluacion=buscarEvaluacionPorId(idEvaluacion);
        em.detach(evaluacion);
        evaluacion.setPorcentaje(porcentaje);
        em.getTransaction().begin();
        em.merge(evaluacion);
        em.getTransaction().commit();
        return evaluacion;
    }
    
    public Evaluaciones buscarEvaluacionPorId(EvaluacionesPK idEvaluacion){
       return (Evaluaciones) super.find(idEvaluacion);
    }

    
    public boolean eliminarEvaluacion(int institucion, int idGrado,int consecutivo, int idMateria, String tema){
        boolean fueEliminado=false;
        EvaluacionesPK idEvaluacion=new EvaluacionesPK();
        idEvaluacion.setCursosInstitucion(institucion);
        idEvaluacion.setCursosGrado(idGrado);
        idEvaluacion.setCursosConsecutivocurso(consecutivo);
        idEvaluacion.setCursosMateria(idMateria);
        idEvaluacion.setTema(tema);
        Evaluaciones evaluacion= buscarEvaluacionPorId(idEvaluacion);
        try{
              super.remove(evaluacion);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }
    
    public ArrayList<Evaluaciones> obtenerEvaluacionesCurso(int idGrado, int consecutivo, int materia){
        List<Evaluaciones> evaluaciones=super.findAll();
        ArrayList<Evaluaciones> respuesta= new ArrayList<Evaluaciones>();
        for(int i=0;i<evaluaciones.size();i++){
           Evaluaciones tmp= evaluaciones.get(i);
           if(tmp.getEvaluacionesPK().getCursosGrado()==idGrado &&
           tmp.getEvaluacionesPK().getCursosConsecutivocurso()==consecutivo &&
           tmp.getEvaluacionesPK().getCursosMateria()==materia){
               respuesta.add(tmp);
           }
        }
        return respuesta;
    }
    
    public List<Evaluaciones> obtenerTodasEvaluaciones(){
        return super.findAll();
    }

}
