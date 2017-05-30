/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.CursoImpartido;
import modelo.Estudiante;
import modelo.Evaluacion;
import modelo.Examen;
import modelo.Grado;
import modelo.Institucion;
import modelo.Materia;
import modelo.MateriaCurso;
import modelo.entidades.Estudiantes;
import modelo.entidades.Evaluaciones;
import modelo.entidades.Examenes;
import modelo.entidades.ExamenesPK;
import modelo.entidades.Grados;
import modelo.entidades.GradosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.Materias;

/**
 *
 * @author ferchs
 */
public class ControlGestionarExamenes {
    private MateriaCurso materiaEnCurso;
    private Examen examen;
    private Evaluacion evaluacion;
    private CursoImpartido cursoImpartido;
    private Curso curso;
    private Grado grado;
    private Materia materia;
    private Estudiante estudiante;
    private int idInstitucion;
    
    public ControlGestionarExamenes(){
        examen= new Examen();
        evaluacion= new Evaluacion();
        cursoImpartido= new CursoImpartido();
        curso= new Curso();
        materia= new Materia();
        grado= new Grado();
        estudiante= new Estudiante();
        materiaEnCurso= new MateriaCurso();
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        idInstitucion=inst.getNit();
    }
    
    public void crearExamen(int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha,double nota) throws MySQLIntegrityConstraintViolationException {
        examen.crearExamen(idInstitucion, idGrado, consecutivo, idEstudiante, idMateria, tema, fecha, nota);
    }
    
    public boolean eliminarExamen(int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha) {
        return examen.eliminarExamen(idInstitucion, idGrado, consecutivo, idEstudiante, idMateria, tema, fecha);
    }
    
    public Examenes editarExamen(int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha,double nota) {
        return examen.editarExamen(idInstitucion, idGrado, consecutivo, idEstudiante, idMateria, tema, fecha, nota);
    }
    
    public Examenes obtenerExamenPorId(int idGrado,int consecutivo, String idEstudiante, int idMateria, String tema, Date fecha){
        ExamenesPK idExamen=new ExamenesPK();
        idExamen.setEvaluacionesInstitucion(idInstitucion);
        idExamen.setEvaluacionesGrado(idGrado);
        idExamen.setEvaluacionesConsecutivocurso(consecutivo);
        idExamen.setEstudiante(idEstudiante);
        idExamen.setEvaluacionesMateria(idMateria);
        idExamen.setEvaluacionestema(tema);
        idExamen.setFecha(fecha);
        Examenes test= examen.buscarExamenPorId(idExamen);
        return test;
    }
    
    public String[] obtenerGradosEvaluaciones(){
        HashMap<Integer,Integer> idGrados= obtenerIdGradosEvaluaciones();
        String [] grados= new String [idGrados.size()+1];
        grados[0]="0A";
        Iterator it = idGrados.entrySet().iterator();
        int i=1;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            Integer id=(Integer) e.getKey();
            GradosPK idGrado= new GradosPK();
            idGrado.setIdGrado(id);
            idGrado.setInstitucionesnit(idInstitucion);
            Grados grad=grado.buscarGradoPorId(idGrado);
            grados[i]=grad.getNombre();
            i++;
        }
        Arrays.sort(grados);
        return grados; 
    }
    
    public String [] obtenerConsecutivosGradosEvaluaciones(String nombreGrado){
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        int idGrado= grad.getGradosPK().getIdGrado();
        HashMap<Integer,Integer> idConsecutivos= obtenerConsecutivosGradosEvaluaciones(idGrado);
        String [] consecutivos= new String [idConsecutivos.size()+1];
        consecutivos[0]="0A";
        Iterator it = idConsecutivos.entrySet().iterator();
        int i=1;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            Integer id=(Integer) e.getKey();
            consecutivos[i]=Integer.toString(id);
            i++;
        }
        Arrays.sort(consecutivos);
        return consecutivos; 
    }
    
    public String [] obtenerMateriasCursoEvaluaciones(int idGrado, int consecutivo){
        HashMap<Integer,Integer> idMaterias= obtenerIdMateriasEvaluaciones();
        String [] materias= new String [idMaterias.size()+1];
        materias[0]="0A";
        Iterator it = idMaterias.entrySet().iterator();
        int i=1;
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            Integer id=(Integer) e.getKey();
            Materias mat=materia.buscarMateriaPorId(id);
            materias[i]=mat.getNombre()+" - "+mat.getCodigoMateria();
            i++;
        }
        Arrays.sort(materias);
        return materias; 
    }
    
    public String [] obtenerTemasCursoEvaluaciones(int idGrado, int consecutivo,int materia){
        List<Evaluaciones> evaluaciones=evaluacion.obtenerTodasEvaluaciones();
        String [] temas= new String [evaluaciones.size()+1];
        temas[0]="0A";
        for(int i=0;i<evaluaciones.size();i++){
            Evaluaciones tmp=evaluaciones.get(i);
            if(tmp.getEvaluacionesPK().getCursosGrado()== idGrado && 
                tmp.getEvaluacionesPK().getCursosConsecutivocurso()== consecutivo &&
                 tmp.getEvaluacionesPK().getCursosMateria() == materia){
               temas[i+1]=tmp.getEvaluacionesPK().getTema();
            }
        }
        return temas;
    }
    
    public String [] obtenerEstudiantesMatriculados(int idGrado, int consecutivo, int idMateria){
        ArrayList<Estudiantes> estudiantes=materiaEnCurso.obtenerEstudiantesMateriaCurso(idInstitucion, idGrado, consecutivo, idMateria);
        String [] nombreEstudiantes= new String [estudiantes.size()+1];
        nombreEstudiantes[0]="0A";
        for(int i=0;i<estudiantes.size();i++){
            Estudiantes tmp=estudiantes.get(i);
            StringBuilder nombre= new StringBuilder();
            nombre.append(tmp.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(tmp.getPersonas().getSegundoApellido());
            nombre.append(" ");
            nombre.append(tmp.getPersonas().getPrimerNombre());
            nombre.append(" ");
            if(!tmp.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(tmp.getPersonas().getSegundoNombre());

            }
            String nombreCompleto= nombre.toString();
            nombreEstudiantes[i+1]=nombreCompleto;
        }
        Arrays.sort(nombreEstudiantes);
        return nombreEstudiantes; 
    }
    
    public String obtenerIdEstudiante(String nombreCompleto){
        String [] nombre=nombreCompleto.split(" ");
        if(nombre.length<4){
            return estudiante.buscarEstudiantePorNombreCompleto(nombre[2],"", nombre[0], nombre[1]);  
        }
        else{
            return estudiante.buscarEstudiantePorNombreCompleto(nombre[2], nombre[3], nombre[0], nombre[1]);
        }
    }
    
    
    public DefaultTableModel obtenerModeloBusquedaExamen(int idGrado, int consecutivo, int idMateria){
        ArrayList<Examenes> examenes=examen.obtenerExamenesCurso(idGrado, consecutivo, idMateria);
        return crearModeloConEvaluacion(examenes);
    }
    
    private ModeloTabla crearModeloConEvaluacion(ArrayList<Examenes> examenes){
        String [] columnas=new String [] {"ID ESTUDIANTE","NOMBRE ESTUDIANTE", "FECHA","TEMA","",""};
        boolean[] canEdit = new boolean [] {false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class,java.lang.String.class,
            java.util.Date.class,java.lang.String.class,java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        for(int i=0;i<examenes.size();i++){
            Examenes examen=examenes.get(i);
            Object [] fila= new Object[6];
            fila[0]=examen.getEstudiantes().getPersonas().getDocumentoIdentidad().getPersonasId();
            StringBuilder nombre= new StringBuilder();
            nombre.append(examen.getEstudiantes().getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(examen.getEstudiantes().getPersonas().getSegundoApellido());
            nombre.append(" ");
            nombre.append(examen.getEstudiantes().getPersonas().getPrimerNombre());
            nombre.append(" ");
            if(!examen.getEstudiantes().getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(examen.getEstudiantes().getPersonas().getSegundoNombre());

            }
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=examen.getExamenesPK().getFecha();
            fila[3]=examen.getExamenesPK().getEvaluacionestema();
            fila[4]=crearBoton("Editar","editar");
            fila[5]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private JButton crearBoton(String texto, String comando){
        JButton boton= new JButton();
        boton.setBackground(new java.awt.Color(101, 166, 148));
        boton.setForeground(new java.awt.Color(255, 255, 255));
        boton.setText(texto);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        boton.setActionCommand(comando);
        return boton;
    }
    
    private HashMap<Integer,Integer> obtenerIdGradosEvaluaciones(){
        List<Evaluaciones> evaluaciones=evaluacion.obtenerTodasEvaluaciones();
        HashMap<Integer,Integer> idGrados= new HashMap<Integer,Integer>();
        for(int i=0;i<evaluaciones.size();i++){
            Evaluaciones tmp=evaluaciones.get(i);
            try{
                idGrados.put(tmp.getEvaluacionesPK().getCursosGrado(), tmp.getEvaluacionesPK().getCursosGrado());
            }
            catch(Exception e){
                
            }
        }
        return idGrados;
    }
    
    private HashMap<Integer,Integer> obtenerConsecutivosGradosEvaluaciones(int idGrado){
        List<Evaluaciones> evaluaciones=evaluacion.obtenerTodasEvaluaciones();
        HashMap<Integer,Integer> consecutivos= new HashMap<Integer,Integer>();
        for(int i=0;i<evaluaciones.size();i++){
            Evaluaciones tmp=evaluaciones.get(i);
            try{
                if(tmp.getEvaluacionesPK().getCursosGrado()==idGrado){
                    consecutivos.put(tmp.getEvaluacionesPK().getCursosConsecutivocurso(),
                            tmp.getEvaluacionesPK().getCursosConsecutivocurso());
                }
            }
            catch(Exception e){
                
            }
        }
        return consecutivos;
    }
    
    private HashMap<Integer,Integer> obtenerIdMateriasEvaluaciones(){
        List<Evaluaciones> evaluaciones=evaluacion.obtenerTodasEvaluaciones();
        HashMap<Integer,Integer> idMaterias= new HashMap<Integer,Integer>();
        for(int i=0;i<evaluaciones.size();i++){
            Evaluaciones tmp=evaluaciones.get(i);
            try{
                idMaterias.put(tmp.getEvaluacionesPK().getCursosMateria(), tmp.getEvaluacionesPK().getCursosMateria());
            }
            catch(Exception e){
                
            }
        }
        return idMaterias;
    }
}
