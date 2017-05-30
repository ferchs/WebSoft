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
import modelo.entidades.Estudiantes;
import modelo.entidades.MateriaEnCurso;
import modelo.entidades.MateriaEnCursoPK;
import modelo.entidades.Materias;
/**
 *
 * @author ferchs
 */
public class MateriaCurso extends AbstractFacade{
    private EntityManager em;
    private MateriaEnCurso materiaEnCurso;

    public MateriaCurso() {
        super(MateriaEnCurso.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public MateriaEnCurso crearMateriaEnCurso(int idInstitucion,int idGrado, int consecutivo,String idEstudiante,int codigoMateria){
        MateriaEnCursoPK idMateriaEnCurso= new MateriaEnCursoPK();
        idMateriaEnCurso.setCursosGradosInstitucionesnit(idInstitucion);
        idMateriaEnCurso.setCursosGradosidGrado(idGrado);
        idMateriaEnCurso.setCursosconsecutivo(consecutivo);
        idMateriaEnCurso.setEstudiantesPersonasnumeroidentificacion(idEstudiante);
        idMateriaEnCurso.setMateriascodigomateria(codigoMateria);
        materiaEnCurso= new MateriaEnCurso();
        materiaEnCurso.setMateriaEnCursoPK(idMateriaEnCurso);
        super.create(materiaEnCurso);
        return materiaEnCurso;
    }
    
    public MateriaEnCurso editarMateriaEnCurso(MateriaEnCursoPK anterior, MateriaEnCursoPK nueva){
        materiaEnCurso= buscarMateriaEnCursoPorId(anterior);
        eliminarMateriaEnCurso(materiaEnCurso.getMateriaEnCursoPK().getCursosGradosInstitucionesnit(),
                materiaEnCurso.getMateriaEnCursoPK().getCursosGradosidGrado(),
                materiaEnCurso.getMateriaEnCursoPK().getCursosconsecutivo(),
                materiaEnCurso.getMateriaEnCursoPK().getEstudiantesPersonasnumeroidentificacion(),
                materiaEnCurso.getMateriaEnCursoPK().getMateriascodigomateria());
        materiaEnCurso= new MateriaEnCurso();
        materiaEnCurso.setMateriaEnCursoPK(nueva);
        int institucion=materiaEnCurso.getMateriaEnCursoPK().getCursosGradosInstitucionesnit();
        int grado=materiaEnCurso.getMateriaEnCursoPK().getCursosGradosidGrado();
        int consecutivo=materiaEnCurso.getMateriaEnCursoPK().getCursosconsecutivo();
        String idEstudiante=materiaEnCurso.getMateriaEnCursoPK().getEstudiantesPersonasnumeroidentificacion();
        int idMateria=materiaEnCurso.getMateriaEnCursoPK().getMateriascodigomateria();
        crearMateriaEnCurso(institucion,grado,consecutivo,idEstudiante,idMateria);
        return materiaEnCurso;
    }
    
    public MateriaEnCurso buscarMateriaEnCursoPorId(MateriaEnCursoPK idMateriaEnCurso){
       return (MateriaEnCurso) super.find(idMateriaEnCurso);
    }
    
    public MateriaEnCurso buscarMateriaEnCursoPorId(int idInstitucion,int idGrado, int consecutivo,String idEstudiante,int codigoMateria){
        MateriaEnCursoPK materiaEnCurso= new MateriaEnCursoPK();
        materiaEnCurso.setCursosGradosInstitucionesnit(idInstitucion);
        materiaEnCurso.setCursosGradosidGrado(idGrado);
        materiaEnCurso.setCursosconsecutivo(consecutivo);
        materiaEnCurso.setEstudiantesPersonasnumeroidentificacion(idEstudiante);
        materiaEnCurso.setMateriascodigomateria(codigoMateria);
       return (MateriaEnCurso) buscarMateriaEnCursoPorId(materiaEnCurso);
    }
    
    public boolean eliminarMateriaEnCurso(int idInstitucion,int idGrado, int consecutivo,String idEstudiante,int codigoMateria){
        boolean fueEliminado=false;
        MateriaEnCursoPK idMateriaEnCurso= new MateriaEnCursoPK();
        idMateriaEnCurso.setCursosGradosInstitucionesnit(idInstitucion);
        idMateriaEnCurso.setCursosGradosidGrado(idGrado);
        idMateriaEnCurso.setCursosconsecutivo(consecutivo);
        idMateriaEnCurso.setEstudiantesPersonasnumeroidentificacion(idEstudiante);
        idMateriaEnCurso.setMateriascodigomateria(codigoMateria);
        MateriaEnCurso materiaEnCurso= buscarMateriaEnCursoPorId(idMateriaEnCurso);
        try{
              super.remove(materiaEnCurso);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }
    
    public ArrayList<Estudiantes> obtenerEstudiantesMateriaCurso(int idInstitucion,int idGrado, int consecutivo, int idMateria){
        List<MateriaEnCurso> materiasEnCurso= super.findAll();
        ArrayList<Estudiantes> estudiantes=new ArrayList();
        for(int i=0;i<materiasEnCurso.size();i++){
            MateriaEnCurso tmp=materiasEnCurso.get(i);
            if(tmp.getMateriaEnCursoPK().getCursosGradosInstitucionesnit()==idInstitucion &&
                tmp.getMateriaEnCursoPK().getCursosGradosidGrado()==idGrado &&
                tmp.getMateriaEnCursoPK().getCursosconsecutivo()==consecutivo &&
                tmp.getMateriaEnCursoPK().getMateriascodigomateria()==idMateria){
                estudiantes.add(tmp.getEstudiantes());
            }
        }
        return estudiantes;
    }
    
    public ArrayList<Materias> obtenerMateriasEstudianteCurso(int idInstitucion,int idGrado, int consecutivo, String idEstudiante){
        List<MateriaEnCurso> materiasEnCurso= super.findAll();
        ArrayList<Materias> materias=new ArrayList();
        for(int i=0;i<materiasEnCurso.size();i++){
            MateriaEnCurso tmp=materiasEnCurso.get(i);
            if(tmp.getMateriaEnCursoPK().getCursosGradosInstitucionesnit()==idInstitucion &&
                tmp.getMateriaEnCursoPK().getCursosGradosidGrado()==idGrado &&
                tmp.getMateriaEnCursoPK().getCursosconsecutivo()==consecutivo &&
                tmp.getEstudiantes().getPersonas().getDocumentoIdentidad().equals(idEstudiante)){
                materias.add(tmp.getMaterias());
            }
        }
        return materias;
    }

}
