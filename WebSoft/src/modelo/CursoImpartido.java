/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.CursosImpartidos;
import modelo.entidades.CursosImpartidosPK;
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
    
    public CursosImpartidos crearCursoImpartido(int idInstitucion,int idGrado, int consecutivo,String idProfesor, int idMateria){
        CursosImpartidosPK idCursoImpartido= new CursosImpartidosPK();
        idCursoImpartido.setInstitucion(idInstitucion);
        idCursoImpartido.setGrado(idGrado);
        idCursoImpartido.setConsecutivocurso(consecutivo);
        idCursoImpartido.setProfesor(idProfesor);
        idCursoImpartido.setMateria(idMateria);
        cursoImpartido= new CursosImpartidos();
        cursoImpartido.setCursosImpartidosPK(idCursoImpartido);
        super.create(cursoImpartido);
        return cursoImpartido;
    }
    
    public CursosImpartidos editarCursoImpartido(CursosImpartidosPK anterior, CursosImpartidosPK nueva){
        cursoImpartido= buscarCursoImpartidoPorId(anterior);
        eliminarCursoImpartido(cursoImpartido.getCursosImpartidosPK().getInstitucion(),cursoImpartido.getCursosImpartidosPK().getGrado(),
                cursoImpartido.getCursosImpartidosPK().getConsecutivocurso(),cursoImpartido.getCursosImpartidosPK().getProfesor(), 
                cursoImpartido.getCursosImpartidosPK().getMateria());
        cursoImpartido= new CursosImpartidos();
        cursoImpartido.setCursosImpartidosPK(nueva);
        int institucion=cursoImpartido.getCursosImpartidosPK().getInstitucion();
        int grado=cursoImpartido.getCursosImpartidosPK().getGrado();
        int consecutivo=cursoImpartido.getCursosImpartidosPK().getConsecutivocurso();
        String idProfesor=cursoImpartido.getCursosImpartidosPK().getProfesor();
        int idMateria=cursoImpartido.getCursosImpartidosPK().getMateria();
        crearCursoImpartido(institucion,grado,consecutivo,idProfesor,idMateria);
        return cursoImpartido;
    }
    
    public CursosImpartidos buscarCursoImpartidoPorId(CursosImpartidosPK idCursoImpartido){
       return (CursosImpartidos) super.find(idCursoImpartido);
    }
    
    public CursosImpartidos buscarCursoImpartidoPorId(int idInstitucion,int idGrado, int consecutivo,String idProfesor, int idMateria){
        CursosImpartidosPK idCursoImpartido= new CursosImpartidosPK();
        idCursoImpartido.setInstitucion(idInstitucion);
        idCursoImpartido.setGrado(idGrado);
        idCursoImpartido.setConsecutivocurso(consecutivo);
        idCursoImpartido.setProfesor(idProfesor);
        idCursoImpartido.setMateria(idMateria);
       return (CursosImpartidos) buscarCursoImpartidoPorId(idCursoImpartido);
    }
    
     public boolean profesorMatriculado(String idProfesor){
        boolean matriculado=false;
        List<CursosImpartidos> cursosImpartidos=super.findAll();
        for(int i=0;i<cursosImpartidos.size();i++){
            CursosImpartidos tmp=cursosImpartidos.get(i);
            String id=tmp.getProfesores().getPersonas().getNumeroIdentificacion();
            if(id.equals(idProfesor)){
                return matriculado=true;
            }
        }
        return matriculado;
    }
     
     public CursosImpartidos buscarCursoImpartidoProfesor(String idProfesor){
        List<CursosImpartidos> matriculas=super.findAll();
        for(int i=0;i<matriculas.size();i++){
            CursosImpartidos tmp=matriculas.get(i);
            String id=tmp.getProfesores().getPersonas().getNumeroIdentificacion();
            if(id.equals(idProfesor)){
                return tmp;
            }
        }
        return null;
    }

    
    public boolean eliminarCursoImpartido(int idInstitucion,int idGrado, int consecutivo,String idProfesor, int idMateria){
        boolean fueEliminado=false;
        CursosImpartidosPK idCursoImpartido= new CursosImpartidosPK();
        idCursoImpartido.setInstitucion(idInstitucion);
        idCursoImpartido.setGrado(idGrado);
        idCursoImpartido.setConsecutivocurso(consecutivo);
        idCursoImpartido.setProfesor(idProfesor);
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

}
