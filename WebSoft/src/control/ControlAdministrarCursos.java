/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Grado;
import modelo.Institucion;
import modelo.Jornada;
import modelo.Profesor;
import modelo.Salon;
import modelo.entidades.Cursos;
import modelo.entidades.CursosPK;
import modelo.entidades.Grados;
import modelo.entidades.Instituciones;
import modelo.entidades.Jornadas;
import modelo.entidades.Materias;
import modelo.entidades.Profesores;
import modelo.entidades.Salones;

/**
 *
 * @author ferchs
 */
public class ControlAdministrarCursos {
   
    private Salon salon;
    private Jornada jornada;
    private Curso curso;
    private Grado grado;
    private Profesor profesor;
    
    public ControlAdministrarCursos(){
        salon= new Salon();
        jornada= new Jornada();
        curso= new Curso();
        grado= new Grado();
        profesor= new Profesor();
    }
    
    public void agregarCurso(String nombreGrado,int consecutivo, int idSalon, int idJornada, String director){
        Salones salonCurso=salon.buscarSalonPorId(idSalon);
        Jornadas jornadaCurso=jornada.buscarJornadaPorId(idJornada);
        String [] nombreCompleto=director.split(" ");
         Profesores profeCurso=null;
        if(nombreCompleto.length==3){
           profeCurso=profesor.buscarProfesorPorNombre(nombreCompleto[2],"", nombreCompleto[0], nombreCompleto[1]);
        }
        else{
           profeCurso=profesor.buscarProfesorPorNombre(nombreCompleto[2], nombreCompleto[3], nombreCompleto[0], nombreCompleto[1]);
        }
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        curso.crearCurso(grad.getGradosPK().getIdGrado(), consecutivo, salonCurso, jornadaCurso, profeCurso);
    }
    
    public DefaultTableModel obtenerModeloBusquedaCurso(String nombreGrado, int consecutivo){
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        Instituciones inst=instituciones.get(0);
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosidGrado(grad.getGradosPK().getIdGrado());
        idCurso.setConsecutivo(consecutivo);
        idCurso.setGradosInstitucionesnit(inst.getNit());
        Cursos curs=curso.buscarCursoPorId(idCurso);
        return crearModeloConCurso(curs);
    }
    
    private ModeloTabla crearModeloConCurso(Cursos curso){
        String [] columnas=new String [] {"CURSO", "SALON", "JORNADA", "DIRECTOR", "",""};
        boolean[] canEdit = new boolean [] {false, false, false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class, 
            java.lang.String.class,java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[6];
        String nombreCurso=curso.getGrados().getNombre()+"-"+curso.getCursosPK().getConsecutivo();
        StringBuilder nombreDirector= new StringBuilder();
        nombreDirector.append(curso.getDirector().getPersonas().getPrimerNombre());
        nombreDirector.append(" ");
        if(!curso.getDirector().getPersonas().getSegundoNombre().isEmpty()){
            nombreDirector.append(curso.getDirector().getPersonas().getSegundoNombre());
            nombreDirector.append(" ");
        }
        nombreDirector.append(curso.getDirector().getPersonas().getPrimerApellido());
        nombreDirector.append(" ");
        nombreDirector.append(curso.getDirector().getPersonas().getSegundoApellido());  
        if(curso!=null){
            fila[0]=nombreCurso;
            fila[1]=curso.getSalonesidsalon().getNombre();
            fila[2]=curso.getJornadasidjornada().getNombre();
            fila[3]=nombreDirector.toString();
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
    
    public HashMap<String, String> obtenerDatosCurso(String nombreGrado,int consecutivo){
        HashMap<String, String> datosSalon= new HashMap<>();
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        Instituciones inst=instituciones.get(0);
        CursosPK idCurso= new CursosPK();
        idCurso.setGradosidGrado(grad.getGradosPK().getIdGrado());
        idCurso.setConsecutivo(consecutivo);
        idCurso.setGradosInstitucionesnit(inst.getNit());
        Cursos cursoEncontrado=curso.buscarCursoPorId(idCurso);
        datosSalon.put("idGrado",Integer.toString(cursoEncontrado.getGrados().getGradosPK().getIdGrado()));
        datosSalon.put("grado",cursoEncontrado.getGrados().getNombre());
        datosSalon.put("consecutivo",Integer.toString(cursoEncontrado.getCursosPK().getConsecutivo()));
        datosSalon.put("salon",cursoEncontrado.getSalonesidsalon().getNombre());
        datosSalon.put("jornada",cursoEncontrado.getJornadasidjornada().getNombre());
        StringBuilder nombreCompleto= new StringBuilder();
                nombreCompleto.append(cursoEncontrado.getDirector().getPersonas().getPrimerApellido());
                nombreCompleto.append(" ");
                nombreCompleto.append(cursoEncontrado.getDirector().getPersonas().getSegundoApellido());
                nombreCompleto.append(" ");
                nombreCompleto.append(cursoEncontrado.getDirector().getPersonas().getPrimerNombre());
                nombreCompleto.append(" ");
                nombreCompleto.append(cursoEncontrado.getDirector().getPersonas().getSegundoNombre());
        datosSalon.put("director",nombreCompleto.toString());
        return datosSalon;
    }
    
    
    public String [] obtenerListadoGrados(){
        List<Grados> grados=grado.findAll();
        String [] listaGrados=null;
        if(!grados.isEmpty()){
            listaGrados= new String[grados.size()+1];
            listaGrados[0]="0A";
            for(int i=0;i<grados.size();i++){
                listaGrados[i+1]=grados.get(i).getNombre();
            }
            Arrays.sort(listaGrados);  
        }
        return listaGrados;
    }
    
    public String [] obtenerListadoMateriasGrado(String nombreGrado){
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        List<Materias> materias=(List<Materias>) grad.getMateriasCollection();
        String [] listaMaterias=null;
        if(!materias.isEmpty()){
            listaMaterias= new String[materias.size()+1];
            listaMaterias[0]="0A";
            for(int i=0;i<materias.size();i++){
                String codigo=Integer.toString(materias.get(i).getCodigoMateria());
                String nombre=materias.get(i).getNombre();
                listaMaterias[i+1]=nombre+" - "+codigo;
            }
            Arrays.sort(listaMaterias);  
        }
        return listaMaterias;
    }
    
    public String [] obtenerListadoConsecutivosDeGrado(String nombreGrado){
        List<Cursos> cursos=curso.findAll();
        String [] listaConsecutivos=null;
        ArrayList<String> consecutivos= new ArrayList<String>();
        for(int i=0;i<cursos.size();i++){
            if(cursos.get(i).getGrados().getNombre().equalsIgnoreCase(nombreGrado)){
                consecutivos.add(Integer.toString(cursos.get(i).getCursosPK().getConsecutivo()));
            }
        }
        if(!consecutivos.isEmpty()){
            listaConsecutivos=covertirArrayList(consecutivos);
            Arrays.sort(listaConsecutivos);
        }
        return listaConsecutivos;
    }
    
    private String [] covertirArrayList(ArrayList array){
        String [] arreglo=new String[array.size()+1];
        arreglo[0]="0A";
        for(int i=0;i<array.size();i++){
            arreglo[i+1]=(String) array.get(i);
        }
        return arreglo;
    }
    
    public String [] obtenerListadoSalones(){
        List<Salones> salones=salon.findAll();
        String [] listaSalones= null;
        if(!salones.isEmpty()){
            listaSalones= new String[salones.size()+1];
            listaSalones[0]="0A";
            for(int i=0;i<salones.size();i++){
                listaSalones[i+1]=salones.get(i).getNombre();
            }
            Arrays.sort(listaSalones);
        }
        return listaSalones;
    }
    
    public String [] obtenerListadoJornadas(){
        List<Jornadas> jornadas=jornada.findAll();
        String [] listaJornadas=null;
        if(!jornadas.isEmpty()){
        listaJornadas= new String[jornadas.size()+1];
        listaJornadas[0]="0A";
            for(int i=0;i<jornadas.size();i++){
                listaJornadas[i+1]=jornadas.get(i).getNombre();
            }
            Arrays.sort(listaJornadas);
        }
        return listaJornadas;
    }
    
    public String [] obtenerListadoProfesores(){
        List<Profesores> profesores=profesor.findAll();
        String [] listaProfesores= null;
        if(!profesores.isEmpty()){
            listaProfesores= new String[profesores.size()+1];
            listaProfesores[0]="0A";
            for(int i=0;i<profesores.size();i++){
                StringBuilder nombreCompleto= new StringBuilder();
                nombreCompleto.append(profesores.get(i).getPersonas().getPrimerApellido());
                nombreCompleto.append(" ");
                nombreCompleto.append(profesores.get(i).getPersonas().getSegundoApellido());
                nombreCompleto.append(" ");
                nombreCompleto.append(profesores.get(i).getPersonas().getPrimerNombre());
                nombreCompleto.append(" ");
                nombreCompleto.append(profesores.get(i).getPersonas().getSegundoNombre());
                listaProfesores[i+1]=nombreCompleto.toString();
            }
            Arrays.sort(listaProfesores);
        }
        return listaProfesores;
    }
    
    public void editarCurso(String nombreGrado,int consecutivo, int idSalon, int idJornada, String director){
        Salones salonCurso=salon.buscarSalonPorId(idSalon);
        Jornadas jornadaCurso=jornada.buscarJornadaPorId(idJornada);
        String [] nombreCompleto=director.split(" ");
         Profesores profeCurso=null;
        if(nombreCompleto.length==3){
           profeCurso=profesor.buscarProfesorPorNombre(nombreCompleto[2],"", nombreCompleto[0], nombreCompleto[1]);
        }
        else{
           profeCurso=profesor.buscarProfesorPorNombre(nombreCompleto[2], nombreCompleto[3], nombreCompleto[0], nombreCompleto[1]);
        }
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        curso.editarCurso(grad.getGradosPK().getIdGrado(), consecutivo, salonCurso, jornadaCurso, profeCurso);
    }
    
    public boolean eliminarCurso(String nombreGrado,int consecutivo){
        Grados grad=grado.buscarGradoPorNombre(nombreGrado);
        boolean eliminado=curso.eliminarCurso(grad.getGradosPK().getIdGrado(), consecutivo);
        return eliminado;
    }
    
    public int buscarIdSalon(String nombre){
        List<Salones> salones=salon.findAll();
        for(Salones s:salones){
            String nombreSalon=s.getNombre();
            if(nombreSalon.equals(nombre)){
                return s.getIdSalon();
            }
        }
        return 0;
    }
    
    public int buscarIdJornada(String nombre){
        List<Jornadas> jornadas=jornada.findAll();
        for(Jornadas j:jornadas){
            String nombreJornada=j.getNombre();
            if(nombreJornada.equals(nombre)){
                return j.getIdJornada();
            }
        }
        return 0;
    } 
}
