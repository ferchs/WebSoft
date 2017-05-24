/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Matriculas;
import modelo.entidades.MatriculasPK;

/**
 *
 * @author ferchs
 */
public class Matricula extends AbstractFacade{
    private EntityManager em;
    private Matriculas matricula;

    public Matricula() {
        super(Matriculas.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Matriculas crearMatricula(int idInstitucion,int idGrado, int consecutivo,String idEstudiante){
        MatriculasPK idMtricula= new MatriculasPK();
        idMtricula.setInstitucion(idInstitucion);
        idMtricula.setGrado(idGrado);
        idMtricula.setCursosconsecutivo(consecutivo);
        idMtricula.setEstudiante(idEstudiante);
        matricula= new Matriculas();
        matricula.setMatriculasPK(idMtricula);
        super.create(matricula);
        return matricula;
    }
    
    public Matriculas editarMatricula(MatriculasPK anterior, MatriculasPK nueva){
        matricula= buscarMatriculaPorId(anterior);
        eliminarMatricula(matricula.getMatriculasPK().getInstitucion(),matricula.getMatriculasPK().getGrado(),
                matricula.getMatriculasPK().getCursosconsecutivo(),matricula.getMatriculasPK().getEstudiante());
        matricula= new Matriculas();
        matricula.setMatriculasPK(nueva);
        int institucion=matricula.getMatriculasPK().getInstitucion();
        int grado=matricula.getMatriculasPK().getGrado();
        int consecutivo=matricula.getMatriculasPK().getCursosconsecutivo();
        String idEstudiante=matricula.getMatriculasPK().getEstudiante();
        crearMatricula(institucion,grado,consecutivo,idEstudiante);
        return matricula;
    }
    
    public Matriculas buscarMatriculaPorId(MatriculasPK idMatricula){
       return (Matriculas) super.find(idMatricula);
    }
    
    public Matriculas buscarMatriculaPorId(int idInstitucion,int idGrado, int consecutivo,String idEstudiante){
        MatriculasPK idMtricula= new MatriculasPK();
        idMtricula.setInstitucion(idInstitucion);
        idMtricula.setGrado(idGrado);
        idMtricula.setCursosconsecutivo(consecutivo);
        idMtricula.setEstudiante(idEstudiante);
       return (Matriculas) buscarMatriculaPorId(idMtricula);
    }
    
     public boolean estudianteMatriculado(String idEstudiante){
        boolean matriculado=false;
        List<Matriculas> matriculas=super.findAll();
        for(int i=0;i<matriculas.size();i++){
            Matriculas tmp=matriculas.get(i);
            String id=tmp.getEstudiantes().getPersonas().getNumeroIdentificacion();
            if(id.equals(idEstudiante)){
                return matriculado=true;
            }
        }
        return matriculado;
    }
     
     public Matriculas buscarMatriculaEstudiante(String idEstudiante){
        List<Matriculas> matriculas=super.findAll();
        for(int i=0;i<matriculas.size();i++){
            Matriculas tmp=matriculas.get(i);
            String id=tmp.getEstudiantes().getPersonas().getNumeroIdentificacion();
            if(id.equals(idEstudiante)){
                return tmp;
            }
        }
        return null;
    }

    
    public boolean eliminarMatricula(int idInstitucion,int idGrado, int consecutivo,String idEstudiante){
        boolean fueEliminado=false;
        MatriculasPK idMatricula= new MatriculasPK();
        idMatricula.setInstitucion(idInstitucion);
        idMatricula.setGrado(idGrado);
        idMatricula.setCursosconsecutivo(consecutivo);
        idMatricula.setEstudiante(idEstudiante);
        Matriculas matricula= buscarMatriculaPorId(idMatricula);
        try{
              super.remove(matricula);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }

}
