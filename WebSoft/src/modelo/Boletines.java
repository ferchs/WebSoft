/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.entidades.CursosImpartidos;
import modelo.entidades.Estudiantes;
import modelo.entidades.Evaluaciones;
import modelo.entidades.EvaluacionesPK;
import modelo.entidades.Examenes;
import modelo.entidades.Grados;
import modelo.entidades.GradosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.Materias;
import modelo.entidades.Profesores;

/**
 *
 * @author ferchs
 */
public class Boletines {
    
    private MateriaCurso materiaEnCurso;
    private Grado grado;
    private CursoImpartido cursoImpartido;
    private Examen examen;
    private Evaluacion evaluacion;
    private Profesor profesor;
    private int idInstitucion;
    private ArrayList<Boletin> boletines;
    
    
    public Boletines(){
        materiaEnCurso= new MateriaCurso();
        grado= new Grado();
        cursoImpartido= new CursoImpartido();
        examen= new Examen();
        evaluacion= new Evaluacion();
        profesor= new Profesor();
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        idInstitucion=inst.getNit();
    }
    
    public ArrayList<Boletin> obtenerInformacionBoletines(int idGrado,int consecutivo){
        ArrayList<Boletin> boletines= new ArrayList<Boletin>();
        List<Estudiantes> estudiantes=materiaEnCurso.obtenerEstudiantesEnCurso(idInstitucion, idGrado, consecutivo);
        GradosPK gradoPk= new GradosPK();
        gradoPk.setInstitucionesnit(idInstitucion);
        gradoPk.setIdGrado(idGrado);
        Grados grade=grado.buscarGradoPorId(gradoPk);
        List<Materias> materias=(List<Materias>) grade.getMateriasCollection();
        for(int i=0;i<estudiantes.size();i++){
            Estudiantes student=estudiantes.get(i);
            Boletin boletin= new Boletin(student.getPersonasnumeroidentificacion());
            for(int j=0;j<materias.size();j++){
                Materias materia=materias.get(j);
                String nombreProfesor=buscarNombreProfesorMateria(idGrado,consecutivo,materia.getCodigoMateria());
                double definitiva=calcularDefinitivaMateria(idGrado,consecutivo,materia.getCodigoMateria());
                String rendimiento=obtenerRendimiento(definitiva);
                boletin.agregarItem(materia.getNombre(), nombreProfesor, Double.toString(definitiva), rendimiento);
            }
            boletines.add(boletin);
        }
        return boletines;
    }
    
    private String buscarNombreProfesorMateria(int grado,int consecutivo,int idMateria){
        CursosImpartidos curso=cursoImpartido.buscarCursoImpartidoPorId(idInstitucion,grado,consecutivo,idMateria);
        StringBuilder nombreCompleto= new StringBuilder();
        nombreCompleto.append(curso.getProfesor().getPersonas().getPrimerNombre());
        nombreCompleto.append(" ");
        String segundoNombre=curso.getProfesor().getPersonas().getSegundoNombre();
        if(!segundoNombre.isEmpty()){
            nombreCompleto.append(" ");
        }
        nombreCompleto.append(curso.getProfesor().getPersonas().getPrimerApellido());
        nombreCompleto.append(" ");
        nombreCompleto.append(curso.getProfesor().getPersonas().getSegundoApellido());
        return nombreCompleto.toString();
    }
    
    private double calcularDefinitivaMateria(int grado,int consecutivo,int idMateria){
        List<Examenes> examenes=examen.obtenerExamenesCurso(grado, consecutivo, idMateria);
        double definitiva=0;
        for(int i=0;i<examenes.size();i++){
            Examenes e= examenes.get(i);
            double porcentaje=obtenerPorcentajeEvaluacion(e.getExamenesPK().getEvaluacionesGrado(),
                   e.getExamenesPK().getEvaluacionesConsecutivocurso(), e.getExamenesPK().getEvaluacionesMateria(),
                   e.getExamenesPK().getEvaluacionestema());
            definitiva+=porcentaje*e.getNota();
        }
        return definitiva;
    }
    
    private double obtenerPorcentajeEvaluacion(int grado,int consecutivo,int idMateria, String tema){
        EvaluacionesPK idEvaluacion= new EvaluacionesPK();
        idEvaluacion.setCursosInstitucion(idInstitucion);
        idEvaluacion.setCursosGrado(grado);
        idEvaluacion.setCursosConsecutivocurso(consecutivo);
        idEvaluacion.setCursosMateria(idMateria);
        idEvaluacion.setTema(tema);
        Evaluaciones eva=evaluacion.buscarEvaluacionPorId(idEvaluacion);
        return eva.getPorcentaje();
    }
    
    private String obtenerRendimiento(double nota){
        if(nota>=0 && nota<=1.9){
            return "INFERIOR";
        }
        if(nota>=2 && nota<=2.9){
            return "BAJO";
        }
        if(nota>=3 && nota<=3.7){
            return "MEDIO";
        }
        if(nota>=3.8 && nota<=4.4){
            return "ALTO";
        }
        if(nota>=4.5 && nota<=5){
            return "SUPERIOR";
        }
        return "";
    }
}
