/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import modelo.CursoImpartido;
import modelo.Grado;
import modelo.Institucion;
import modelo.MateriaCurso;
import modelo.Matricula;
import modelo.Profesor;
import modelo.entidades.CursosImpartidos;
import modelo.entidades.CursosImpartidosPK;
import modelo.entidades.CursosPK;
import modelo.entidades.Grados;
import modelo.entidades.GradosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.MateriaEnCursoPK;
import modelo.entidades.Materias;
import modelo.entidades.Matriculas;
import modelo.entidades.MatriculasPK;
import modelo.entidades.Profesores;

/**
 *
 * @author ferchs
 */
public class ControlMatriculasPanel {
    
    private Matricula matricula;
    private CursoImpartido cursoImpartido;
    private int idInstitucion;
    private MateriaCurso materiaEnCurso;
    private Grado grado;
    private Profesor profesor;
    
    public ControlMatriculasPanel(){
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        idInstitucion=inst.getNit();
        matricula= new Matricula();
        cursoImpartido=new CursoImpartido();
        materiaEnCurso= new MateriaCurso();
        grado= new Grado();
        profesor= new Profesor();
    }
    
    
    public void crearMatricula(int idGrado, int consecutivo,String idEstudiante){
        matricula.crearMatricula(idInstitucion, idGrado, consecutivo, idEstudiante);
        GradosPK idGrad= new GradosPK();
        idGrad.setInstitucionesnit(idInstitucion);
        idGrad.setIdGrado(idGrado);
        Grados grad=grado.buscarGradoPorId(idGrad);
        List<Materias> materias=(List<Materias>) grad.getMateriasCollection();
        for(int i=0;i<materias.size();i++){
            Materias tmp=materias.get(i);
            materiaEnCurso.crearMateriaEnCurso(idInstitucion, idGrado, consecutivo, idEstudiante, tmp.getCodigoMateria());
        }
    }
    
    public void crearCursoImpartido(int idGrado, int consecutivo,String idprofesor, int idMateria){
       Profesores profe=profesor.buscarProfesorPorId(idprofesor);
       cursoImpartido.crearCursoImpartido(idInstitucion, idGrado, consecutivo,profe, idMateria);  
    }
    
    public Matriculas buscarMatriculaEstudiante(String idEstudiante){
        return matricula.buscarMatriculaEstudiante(idEstudiante);
    }
    
    public ArrayList<CursosImpartidos> buscarCursosImpartidosProfesor(String idProfesor, int idGrado, int consecutivo){
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosInstitucionesnit(idInstitucion);
        idCurso.setConsecutivo(consecutivo);
        idCurso.setGradosidGrado(idGrado);
        return cursoImpartido.buscarCursosImpartidosProfesorIdCurso(idProfesor,idCurso);
    }
    
    public boolean existeCursoImpartido(int idGrado, int consecutivo, int idMateria){
        CursosImpartidosPK idCurso= new CursosImpartidosPK();
        idCurso.setInstitucion(idInstitucion);
        idCurso.setGrado(idGrado);
        idCurso.setConsecutivocurso(consecutivo);
        idCurso.setMateria(idMateria);
        CursosImpartidos curso=(CursosImpartidos) cursoImpartido.find(idCurso);
        if(curso==null){
            return false;
        }
        return true;
    }
    
    public boolean estudianteMatriculado(String idEstudiante){
        return matricula.estudianteMatriculado(idEstudiante);
    }
    
    public boolean profesorMatriculado(String idProfesor){
        return cursoImpartido.profesorMatriculado(idProfesor);
    }
   
    public void editarMatricula(MatriculasPK anterior,MatriculasPK nueva){
        matricula.editarMatricula(anterior, nueva);
        int idGrado=anterior.getGrado();
        MateriaEnCursoPK ant= new MateriaEnCursoPK();
        ant.setCursosGradosInstitucionesnit(anterior.getInstitucion());
        ant.setCursosGradosidGrado(anterior.getGrado());
        ant.setCursosconsecutivo(anterior.getCursosconsecutivo());
        ant.setEstudiantesPersonasnumeroidentificacion(anterior.getEstudiante());
        GradosPK idGrad= new GradosPK();
        idGrad.setInstitucionesnit(anterior.getInstitucion());
        idGrad.setIdGrado(idGrado);
        Grados grad=grado.buscarGradoPorId(idGrad);
        List<Materias> materias=(List<Materias>) grad.getMateriasCollection();
        for(int i=0;i<materias.size();i++){
            Materias tmp=materias.get(i);
           materiaEnCurso.eliminarMateriaEnCurso(ant.getCursosGradosInstitucionesnit(), 
                   ant.getCursosGradosidGrado(), ant.getCursosconsecutivo(),
                   ant.getEstudiantesPersonasnumeroidentificacion(), tmp.getCodigoMateria());
        }
        
        idGrado=nueva.getGrado();
        MateriaEnCursoPK nuev= new MateriaEnCursoPK();
        nuev.setCursosGradosInstitucionesnit(nueva.getInstitucion());
        nuev.setCursosGradosidGrado(nueva.getGrado());
        nuev.setCursosconsecutivo(nueva.getCursosconsecutivo());
        nuev.setEstudiantesPersonasnumeroidentificacion(nueva.getEstudiante());
        idGrad= new GradosPK();
        idGrad.setInstitucionesnit(nueva.getInstitucion());
        idGrad.setIdGrado(idGrado);
        grad=grado.buscarGradoPorId(idGrad);
        materias=(List<Materias>) grad.getMateriasCollection();
        for(int i=0;i<materias.size();i++){
           Materias tmp=materias.get(i);
           materiaEnCurso.crearMateriaEnCurso(nuev.getCursosGradosInstitucionesnit(), 
                   nuev.getCursosGradosidGrado(), nuev.getCursosconsecutivo(),
                   nuev.getEstudiantesPersonasnumeroidentificacion(), tmp.getCodigoMateria());
        }
    }
    
    public void editarCursoImpartido(int idGrado, int consecutivo, String idProfesor, int [] materias){
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosInstitucionesnit(idInstitucion);
        idCurso.setGradosidGrado(idGrado);
        idCurso.setConsecutivo(consecutivo);
        cursoImpartido.editarCursoImpartido(idCurso,idProfesor,materias);
    }
    
    public boolean eliminarMatricula(int idGrado, int consecutivo,String idEstudiante){
        GradosPK idGrad= new GradosPK();
        idGrad.setInstitucionesnit(idInstitucion);
        idGrad.setIdGrado(idGrado);
        Grados grad=grado.buscarGradoPorId(idGrad);
        List<Materias> materias=(List<Materias>) grad.getMateriasCollection();
        for(int i=0;i<materias.size();i++){
            Materias tmp=materias.get(i);
            materiaEnCurso.eliminarMateriaEnCurso(idInstitucion, idGrado, consecutivo, idEstudiante, tmp.getCodigoMateria());
        }
         return matricula.eliminarMatricula(idInstitucion, idGrado, consecutivo, idEstudiante);
    }
    
    public boolean eliminarCursoImpartido(int idGrado, int consecutivo,int idMateria){
        return cursoImpartido.eliminarCursoImpartido(idInstitucion, idGrado, consecutivo,idMateria);
    }
}
