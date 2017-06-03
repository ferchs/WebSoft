/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Examenes;
import modelo.entidades.ExamenesPK;

/**
 *
 * @author ferchs
 */
public class Examen extends AbstractFacade{
    private EntityManager em;
    private Examenes examen;

    public Examen() {
        super(Examenes.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Examenes crearExamen(int institucion, int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha,double nota) throws MySQLIntegrityConstraintViolationException {
        examen= new Examenes();
        ExamenesPK idExamen=new ExamenesPK();
        idExamen.setEvaluacionesInstitucion(institucion);
        idExamen.setEvaluacionesGrado(idGrado);
        idExamen.setEvaluacionesConsecutivocurso(consecutivo);
        idExamen.setEstudiante(idEstudiante);
        idExamen.setEvaluacionesMateria(idMateria);
        idExamen.setEvaluacionestema(tema);
        idExamen.setFecha(fecha);
        examen.setExamenesPK(idExamen);
        examen.setNota(nota);
        super.create(examen);
        return examen;
    }
    
    public Examenes editarExamen(int institucion, int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha,double nota){
        ExamenesPK idExamen=new ExamenesPK();
        idExamen.setEvaluacionesInstitucion(institucion);
        idExamen.setEvaluacionesGrado(idGrado);
        idExamen.setEvaluacionesConsecutivocurso(consecutivo);
        idExamen.setEstudiante(idEstudiante);
        idExamen.setEvaluacionesMateria(idMateria);
        idExamen.setEvaluacionestema(tema);
        idExamen.setFecha(fecha);
        Examenes examen=buscarExamenPorId(idExamen);
        em.detach(examen);
        examen.setNota(nota);
        em.getTransaction().begin();
        em.merge(examen);
        em.getTransaction().commit();
        return examen;
    }
    
    public Examenes buscarExamenPorId(ExamenesPK idExamen){
       return (Examenes) super.find(idExamen);
    }

    
    public boolean eliminarExamen(int institucion, int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha){
        boolean fueEliminado=false;
        ExamenesPK idExamen=new ExamenesPK();
        idExamen.setEvaluacionesInstitucion(institucion);
        idExamen.setEvaluacionesGrado(idGrado);
        idExamen.setEvaluacionesConsecutivocurso(consecutivo);
        idExamen.setEstudiante(idEstudiante);
        idExamen.setEvaluacionesMateria(idMateria);
        idExamen.setEvaluacionestema(tema);
        idExamen.setFecha(fecha);
        Examenes examen= buscarExamenPorId(idExamen);
        try{
              super.remove(examen);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }
    
    public ArrayList<Examenes> obtenerExamenesCurso(int idGrado, int consecutivo, int materia){
        List<Examenes> examenes=super.findAll();
        ArrayList<Examenes> respuesta= new ArrayList<Examenes>();
        for(int i=0;i<examenes.size();i++){
           Examenes tmp= examenes.get(i);
           if(tmp.getExamenesPK().getEvaluacionesGrado()==idGrado &&
           tmp.getExamenesPK().getEvaluacionesConsecutivocurso()==consecutivo &&
           tmp.getExamenesPK().getEvaluacionesMateria()==materia){
               respuesta.add(tmp);
           }
        }
        return respuesta;
    }
}

