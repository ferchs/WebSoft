/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.entidades.Cursos;
import modelo.entidades.CursosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.Jornadas;
import modelo.entidades.Profesores;
import modelo.entidades.Salones;

/**
 *
 * @author ferchs
 */
public class Curso extends AbstractFacade{
    private EntityManager em;
    private Cursos curso;
    private int IdInstitucion;
    
    public Curso() {
        super(Cursos.class);
        Institucion institucion= new Institucion();
        Instituciones colegio=(Instituciones) institucion.findAll().get(0);
        IdInstitucion= colegio.getNit();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = (EntityManagerFactory) EntityManagerFactoryApp.getInstance().getEntityManagerFactory();
        return em=emf.createEntityManager();
    }
    
    public Cursos crearCurso(int grado,int consecutivo, Salones Salon, Jornadas jornada, Profesores director){
        curso= new Cursos();
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosInstitucionesnit(IdInstitucion);
        idCurso.setGradosidGrado(grado);
        idCurso.setConsecutivo(consecutivo);
        curso.setCursosPK(idCurso);
        curso.setSalonesidsalon(Salon);
        curso.setJornadasidjornada(jornada);
        curso.setDirector(director);
        super.create(curso);
        return curso;
    }
    
    public Cursos editarCurso(int grado,int consecutivo, Salones Salon, Jornadas jornada, Profesores director){
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosInstitucionesnit(IdInstitucion);
        idCurso.setGradosidGrado(grado);
        idCurso.setConsecutivo(consecutivo);
        curso= buscarCursoPorId(idCurso);
        em.detach(curso);
        curso.setSalonesidsalon(Salon);
        curso.setJornadasidjornada(jornada);
        curso.setDirector(director);
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        return curso;
    }
    
    public Cursos buscarCursoPorId(CursosPK idCurso){
        Cursos curso=(Cursos) super.find(idCurso);
        return curso;
    }
    
//    public ArrayList<Profesores> buscarProfesorPorComodin(String comodin){
//        List <Profesores> profesores=super.findAll();
//        ArrayList <Profesores> resultadoBusqueda= new ArrayList();
//        for(int i=0;i<profesores.size();i++){
//            StringBuilder nombre= new StringBuilder();
//            Profesores tmp=buscarProfesorPorId(profesores.get(i).getPersonasnumeroidentificacion());
//            nombre.append(tmp.getPersonas().getPrimerNombre());
//            nombre.append(tmp.getPersonas().getSegundoNombre());
//            nombre.append(tmp.getPersonas().getPrimerApellido());
//            nombre.append(tmp.getPersonas().getSegundoApellido());
//            String nombreCompleto= nombre.toString().toLowerCase();
//            if(nombreCompleto.contains(comodin)){
//                resultadoBusqueda.add(tmp);
//            }
//        }
//        return resultadoBusqueda;
//    }
    
    public boolean eliminarCurso(int idGrado, int consecutivo ){
        boolean fueEliminado=false;
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosInstitucionesnit(IdInstitucion);
        idCurso.setGradosidGrado(idGrado);
        idCurso.setConsecutivo(consecutivo);
        Cursos curso=buscarCursoPorId(idCurso);
        try{
              super.remove(curso);
              fueEliminado=true;
              return fueEliminado;
        }
        catch(Exception e){
            e.printStackTrace();
            return fueEliminado;
        }
    }
}
