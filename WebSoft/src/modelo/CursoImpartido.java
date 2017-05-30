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
import modelo.entidades.CursosImpartidos;
import modelo.entidades.CursosImpartidosPK;
import modelo.entidades.CursosPK;
import modelo.entidades.Profesores;
/**
 *
 * @author ferchs
 */
public class CursoImpartido extends AbstractFacade{
    private EntityManager em;
    private CursosImpartidos cursoImpartido;

    public CursoImpartido() {
        super(CursosImpartidos.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public CursosImpartidos crearCursoImpartido(int idInstitucion,int idGrado, int consecutivo,Profesores profesor, int idMateria){
        CursosImpartidosPK idCursoImpartido= new CursosImpartidosPK();
        idCursoImpartido.setInstitucion(idInstitucion);
        idCursoImpartido.setGrado(idGrado);
        idCursoImpartido.setConsecutivocurso(consecutivo);
        idCursoImpartido.setMateria(idMateria);
        cursoImpartido= new CursosImpartidos();
        cursoImpartido.setCursosImpartidosPK(idCursoImpartido);
        cursoImpartido.setProfesor(profesor);
        super.create(cursoImpartido);
        return cursoImpartido;
    }
    
    public CursosImpartidos editarCursoImpartido(CursosPK idCurso,String idProfesor,int [] materias){
        ArrayList<CursosImpartidos> cursosImpartidosProfesor=buscarCursosImpartidosProfesorIdCurso(idProfesor,idCurso);
        for(int i=0;i<cursosImpartidosProfesor.size();i++){
            CursosImpartidos tmp=cursosImpartidosProfesor.get(i);
            if(!buscarIdMateria(materias,tmp.getCursosImpartidosPK().getMateria())){
                eliminarCursoImpartido(tmp.getCursosImpartidosPK().getInstitucion(),
                        tmp.getCursosImpartidosPK().getGrado(),
                        tmp.getCursosImpartidosPK().getConsecutivocurso(),
                        tmp.getCursosImpartidosPK().getMateria());
            }
        }
       
        return cursoImpartido;
    }
    
    private boolean buscarIdMateria(int [] materias,int idMateria){
        for(int i=0;i<materias.length;i++){
            if(materias[i]==idMateria){
                return true;
            }
        }
        return false;
    }
    
    public CursosImpartidos buscarCursoImpartidoPorId(CursosImpartidosPK idCursoImpartido){
       return (CursosImpartidos) super.find(idCursoImpartido);
    }
    
    public CursosImpartidos buscarCursoImpartidoPorId(int idInstitucion,int idGrado, int consecutivo, int idMateria){
        CursosImpartidosPK idCursoImpartido= new CursosImpartidosPK();
        idCursoImpartido.setInstitucion(idInstitucion);
        idCursoImpartido.setGrado(idGrado);
        idCursoImpartido.setConsecutivocurso(consecutivo);
        idCursoImpartido.setMateria(idMateria);
       return (CursosImpartidos) buscarCursoImpartidoPorId(idCursoImpartido);
    }
    
     public boolean profesorMatriculado(String idProfesor){
        boolean matriculado=false;
        List<CursosImpartidos> cursosImpartidos=super.findAll();
        for(int i=0;i<cursosImpartidos.size();i++){
            CursosImpartidos tmp=cursosImpartidos.get(i);
            String id=tmp.getProfesor().getPersonas().getNumeroIdentificacion();
            if(id.equals(idProfesor)){
                return matriculado=true;
            }
        }
        return matriculado;
    }
     
     public ArrayList<CursosImpartidos> buscarCursosImpartidosProfesorIdCurso(String idProfesor,CursosPK idCurso){
        List<CursosImpartidos> matriculas=super.findAll();
        ArrayList<CursosImpartidos> cursos= new ArrayList<CursosImpartidos>();
        for(int i=0;i<matriculas.size();i++){
            CursosImpartidos tmp=matriculas.get(i);
            String id=tmp.getProfesor().getPersonas().getNumeroIdentificacion();
            if(id.equals(idProfesor) && tmp.getCursos().getCursosPK().equals(idCurso)){
                cursos.add(tmp);
            }
        }
        return cursos;
    }
     

    public boolean eliminarCursoImpartido(int idInstitucion,int idGrado, int consecutivo,int idMateria){
        boolean fueEliminado=false;
        CursosImpartidosPK idCursoImpartido= new CursosImpartidosPK();
        idCursoImpartido.setInstitucion(idInstitucion);
        idCursoImpartido.setGrado(idGrado);
        idCursoImpartido.setConsecutivocurso(consecutivo);
        idCursoImpartido.setMateria(idMateria);
        CursosImpartidos cursoImpartido= buscarCursoImpartidoPorId(idCursoImpartido);
        try{
              super.remove(cursoImpartido);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }
    
    public List<CursosImpartidos> obtenerTodosCursosImpartidos(){
        return super.findAll();
    }

}
