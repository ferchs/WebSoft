/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import modelo.CursoImpartido;
import modelo.Institucion;
import modelo.Matricula;
import modelo.entidades.CursosImpartidos;
import modelo.entidades.CursosImpartidosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.Matriculas;
import modelo.entidades.MatriculasPK;

/**
 *
 * @author ferchs
 */
public class ControlMatriculasPanel {
    
    private Matricula matricula;
    private CursoImpartido cursoImpartido;
    private int idInstitucion;
    
    public ControlMatriculasPanel(){
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        idInstitucion=inst.getNit();
        matricula= new Matricula();
        cursoImpartido=new CursoImpartido();
    }
    
    
    public void crearMatricula(int idGrado, int consecutivo,String idEstudiante){
        matricula.crearMatricula(idInstitucion, idGrado, consecutivo, idEstudiante);
    }
    
    public void crearCursoImpartido(int idGrado, int consecutivo,String idProfesor, int idMateria){
        cursoImpartido.crearCursoImpartido(idInstitucion, idGrado, consecutivo, idProfesor, idMateria);
    }
    
    public Matriculas buscarMatriculaEstudiante(String idEstudiante){
        return matricula.buscarMatriculaEstudiante(idEstudiante);
    }
    
    public CursosImpartidos buscarCursoImpartidoProfesor(String idProfesor){
        return cursoImpartido.buscarCursoImpartidoProfesor(idProfesor);
    }
    
    public boolean estudianteMatriculado(String idEstudiante){
        return matricula.estudianteMatriculado(idEstudiante);
    }
    
    public boolean profesorMatriculado(String idProfesor){
        return cursoImpartido.profesorMatriculado(idProfesor);
    }
   
    public void editarMatricula(MatriculasPK anterior,MatriculasPK nueva){
        matricula.editarMatricula(anterior, nueva);
    }
    
    public void editarCursoImpartido(CursosImpartidosPK anterior,CursosImpartidosPK nueva){
        cursoImpartido.editarCursoImpartido(anterior, nueva);
    }
    
    public boolean eliminarMatricula(int idGrado, int consecutivo,String idEstudiante){
        return matricula.eliminarMatricula(idInstitucion, idGrado, consecutivo, idEstudiante);
    }
    
    public boolean eliminarCursoImpartido(int idInstitucion,int idGrado, int consecutivo,String idProfesor, int idMateria){
        return cursoImpartido.eliminarCursoImpartido(idInstitucion, idGrado, consecutivo, idProfesor, idMateria);
    }
}
