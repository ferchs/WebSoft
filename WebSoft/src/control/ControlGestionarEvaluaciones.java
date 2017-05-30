/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.CursoImpartido;
import modelo.Evaluacion;
import modelo.Grado;
import modelo.Institucion;
import modelo.Materia;
import modelo.entidades.CursosImpartidos;
import modelo.entidades.Evaluaciones;
import modelo.entidades.EvaluacionesPK;
import modelo.entidades.Grados;
import modelo.entidades.GradosPK;
import modelo.entidades.Instituciones;
import modelo.entidades.Materias;

/**
 *
 * @author ferchs
 */
public class ControlGestionarEvaluaciones {
    
    private Evaluacion evaluacion;
    private CursoImpartido cursoImpartido;
    private Curso curso;
    private Grado grado;
    private Materia materia;
    private int idInstitucion;
    
    public ControlGestionarEvaluaciones(){
        evaluacion= new Evaluacion();
        cursoImpartido= new CursoImpartido();
        curso= new Curso();
        materia= new Materia();
        grado= new Grado();
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        idInstitucion=inst.getNit();
    }
    
    public void crearEvaluacion(int idGrado,int consecutivo, int idMateria, String tema, double porcentaje) throws MySQLIntegrityConstraintViolationException{
        evaluacion.crearEvaluacion(idInstitucion, idGrado, consecutivo, idMateria, tema, porcentaje);
    }
    
    public boolean eliminarEvaluacion(int idGrado,int consecutivo, int idMateria, String tema) {
        return evaluacion.eliminarEvaluacion(idInstitucion, idGrado, consecutivo, idMateria,tema);
    }
    
    public Evaluaciones editarEvaluacion(int idGrado,int consecutivo, int idMateria, String tema, double porcentaje) {
        return evaluacion.editarEvaluacion(idInstitucion, idGrado, consecutivo, idMateria, tema, porcentaje);
    }
    
    public Evaluaciones obtenerEvaluacionPorId(int idGrado,int consecutivo, int idMateria, String tema){
        EvaluacionesPK idEvaluacion= new EvaluacionesPK();
        idEvaluacion.setCursosInstitucion(idInstitucion);
        idEvaluacion.setCursosGrado(idGrado);
        idEvaluacion.setCursosConsecutivocurso(consecutivo);
        idEvaluacion.setCursosMateria(idMateria);
        idEvaluacion.setTema(tema);
        Evaluaciones test= evaluacion.buscarEvaluacionPorId(idEvaluacion);
        return test;
    }
    
    public String[] obtenerGradosImpartidos(){
        HashMap<Integer,Integer> idGrados= obtenerIdGradosImpartidos();
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
    
    public String [] obtenerConsecutivosGradosImpartidos(String nombreGrado){
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        int idGrado= grad.getGradosPK().getIdGrado();
        HashMap<Integer,Integer> idConsecutivos= obtenerConsecutivosGradosImpartidos(idGrado);
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
    
    public String [] obtenerMateriasGradosImpartidos(int idGrado, int consecutivo){
        List<CursosImpartidos> cursos=cursoImpartido.obtenerTodosCursosImpartidos();
        String [] nombreMaterias= new String [cursos.size()+1];
        nombreMaterias[0]="0A";
        for(int i=0;i<cursos.size();i++){
            CursosImpartidos tmp=cursos.get(i);
            if(tmp.getCursosImpartidosPK().getGrado()==idGrado &&
                    tmp.getCursosImpartidosPK().getConsecutivocurso()==consecutivo){
                Materias mate= materia.buscarMateriaPorId(tmp.getCursosImpartidosPK().getMateria());
                String codigo=Integer.toString(mate.getCodigoMateria());
                String nombre=mate.getNombre();
                nombreMaterias[i+1]=nombre+" - "+codigo;;
            }
        }
        Arrays.sort(nombreMaterias);
        return nombreMaterias; 
    }
    
    public DefaultTableModel obtenerModeloBusquedaEvaluacion(int idGrado, int consecutivo, int idMateria){
        ArrayList<Evaluaciones> evaluaciones=evaluacion.obtenerEvaluacionesCurso(idGrado, consecutivo, idMateria);
        return crearModeloConEvaluacion(evaluaciones);
    }
    
    private ModeloTabla crearModeloConEvaluacion(ArrayList<Evaluaciones> evaluaciones){
        String [] columnas=new String [] {"TEMA","", ""};
        boolean[] canEdit = new boolean [] {false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        for(int i=0;i<evaluaciones.size();i++){
            Evaluaciones evaluacion=evaluaciones.get(i);
            Object [] fila= new Object[3];
            fila[0]=evaluacion.getEvaluacionesPK().getTema();
            fila[1]=crearBoton("Editar","editar");
            fila[2]=crearBoton("Eliminar","eliminar");
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
    
    private HashMap<Integer,Integer> obtenerIdGradosImpartidos(){
        List<CursosImpartidos> cursos=cursoImpartido.obtenerTodosCursosImpartidos();
        HashMap<Integer,Integer> idGrados= new HashMap<Integer,Integer>();
        for(int i=0;i<cursos.size();i++){
            CursosImpartidos tmp=cursos.get(i);
            try{
                idGrados.put(tmp.getCursosImpartidosPK().getGrado(), tmp.getCursosImpartidosPK().getGrado());
            }
            catch(Exception e){
                
            }
        }
        return idGrados;
    }
    
    private HashMap<Integer,Integer> obtenerConsecutivosGradosImpartidos(int idGrado){
        List<CursosImpartidos> cursos=cursoImpartido.obtenerTodosCursosImpartidos();
        HashMap<Integer,Integer> consecutivos= new HashMap<Integer,Integer>();
        for(int i=0;i<cursos.size();i++){
            CursosImpartidos tmp=cursos.get(i);
            try{
                if(tmp.getCursosImpartidosPK().getGrado()==idGrado){
                    consecutivos.put(tmp.getCursosImpartidosPK().getConsecutivocurso(),
                            tmp.getCursosImpartidosPK().getConsecutivocurso());
                }
            }
            catch(Exception e){
                
            }
        }
        return consecutivos;
    }
}
