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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Grado;
import modelo.Institucion;
import modelo.Jornada;
import modelo.Materia;
import modelo.Salon;
import modelo.entidades.Grados;
import modelo.entidades.Instituciones;
import modelo.entidades.Jornadas;
import modelo.entidades.Materias;
import modelo.entidades.Salones;

/**
 *
 * @author ferchs
 */
public class ControlAdministrarRecursos {
   
    private Salon salon;
    private Jornada jornada;
    private Materia materia;
    private Grado grado;
    
    public ControlAdministrarRecursos(){
        salon= new Salon();
        jornada= new Jornada();
        materia= new Materia();
        grado= new Grado();
    }
    
    public void agregarSalon(int idSalon, String nombre, String piso){
        salon.crearSalon(idSalon, nombre, piso);
    }
    
    public void agregarJornada(int idJornada,String nombre, String horaInicio, String horaFin){
        jornada.crearJornada(idJornada, nombre, horaInicio, horaFin);
    }
    
    public void agregarMateria(int codigo,String nombre){
        materia.crearMateria(codigo, nombre);
    }
    
    public void agregarGrado(String nombre, int[] idMaterias){
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        inst.getNit();
        ArrayList<Materias> materias= new ArrayList();
        for(int i=0; i<idMaterias.length;i++){
            Materias asignatura=(Materias) materia.find(idMaterias[i]);
            materias.add(asignatura);
        }
        grado.crearGrado(inst, nombre, materias);
    }
    
    public DefaultTableModel obtenerModeloBusquedaSalon(int parametroBusqueda){
            Salones espacio=salon.buscarSalonPorId(parametroBusqueda);
            return crearModeloConSalon(espacio);
    }
    
    public DefaultTableModel obtenerModeloBusquedaJornada(int parametroBusqueda){
            Jornadas jorna=jornada.buscarJornadaPorId(parametroBusqueda);
            return crearModeloConJornada(jorna);
    }
    
    public DefaultTableModel obtenerModeloBusquedaMateria(int parametroBusqueda){
            Materias mate=materia.buscarMateriaPorId(parametroBusqueda);
            return crearModeloConMateria(mate);
    }
    
    public DefaultTableModel obtenerModeloBusquedaGrado(String parametroBusqueda){
            Grados grad=grado.buscarGradoPorNombre(parametroBusqueda);
            return crearModeloConGrado(grad);
    }
    
    private ModeloTabla crearModeloConJornada(Jornadas jornada){
        String [] columnas=new String [] {"ID", "NOMBRE JORNADA", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[4];
        if(jornada!=null){
            fila[0]=jornada.getIdJornada();
            fila[1]=jornada.getNombre();
            fila[2]=crearBoton("Editar","editar");
            fila[3]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConSalon(Salones salon){
        String [] columnas=new String [] {"ID", "NOMBRE SALON", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[4];
        if(salon!=null){
            fila[0]=salon.getIdSalon();
            fila[1]=salon.getNombre();
            fila[2]=crearBoton("Editar","editar");
            fila[3]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConMateria(Materias materia){
        String [] columnas=new String [] {"CODIGO", "NOMBRE MATERIA", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[4];
        if(materia!=null){
            fila[0]=materia.getCodigoMateria();
            fila[1]=materia.getNombre();
            fila[2]=crearBoton("Editar","editar");
            fila[3]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    public DefaultTableModel crearModeloAgregarMateria(JTable tabla,int idMateria,String nombre){
        DefaultTableModel modeloTabla=(DefaultTableModel) tabla.getModel();
        Object [] fila= new Object[3];
        fila[0]=idMateria;
        fila[1]=nombre;
        fila[2]=crearBoton("Remover","remover");
        modeloTabla.addRow(fila);
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConGrado(Grados grado){
        String [] columnas=new String [] {"NOMBRE GRADO", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class,java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[3];
        if(grado!=null){
            fila[0]=grado.getNombre();
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
    
    public HashMap<String, String> obtenerDatosSalon(int idSalon){
        HashMap<String, String> datosSalon= new HashMap<>();
        Salones salonn=salon.buscarSalonPorId(idSalon);
        String id=Integer.toString(idSalon);
        datosSalon.put("idSalon",id);
        datosSalon.put("nombreSalon",salonn.getNombre());
        datosSalon.put("pisoSalon",salonn.getPiso());
        return datosSalon;
    }
    
    public HashMap<String, String> obtenerDatosJornada(int idJornada){
        HashMap<String, String> datosJornada= new HashMap<>();
        Jornadas jorna=jornada.buscarJornadaPorId(idJornada);
        String id=Integer.toString(idJornada);
        datosJornada.put("idJornada",id);
        datosJornada.put("nombreJornada",jorna.getNombre());
        datosJornada.put("horaInicio",jorna.getHoraInicio());
        datosJornada.put("horaFin",jorna.getHoraFin());
        return datosJornada;
    }
    
    
    public HashMap<String, String> obtenerDatosMateria(int codigo){
        HashMap<String, String> datosMateria= new HashMap<>();
        Materias mate=materia.buscarMateriaPorId(codigo);
        String id=Integer.toString(codigo);
        datosMateria.put("codigo",id);
        datosMateria.put("nombre",mate.getNombre());
        return datosMateria;
    }
    
    public HashMap<String, Object> obtenerDatosGrado(String nombre){
        HashMap<String, Object> datosMateria= new HashMap<>();
        Grados grad=grado.buscarGradoPorNombre(nombre);
        datosMateria.put("nombreGrado",grad.getNombre());
        List<Materias> materias=(List<Materias>) grad.getMateriasCollection();
        HashMap<String, String> listaMaterias = new HashMap<String, String>();
        for(Materias mate:materias){
            listaMaterias.put(Integer.toString(mate.getCodigoMateria()), mate.getNombre());
        }
        datosMateria.put("materias",listaMaterias);
        return datosMateria;
    }
    
    
    public void editarSalon(int idSalon, String nombre, String piso){
        salon.editarSalon(idSalon, nombre, piso);
    }
    
    public void editarJornada(int idJornada,String nombre, String horaInicio, String horaFin){
        jornada.editarJornada(idJornada, nombre, horaInicio, horaFin);
    }
    
    public void editarMateria(int codigo,String nombre){
        materia.editarMateria(codigo, nombre);
    }
    
    public void editarGrado(String nombre, int[] idMaterias){
        Institucion tmp= new Institucion();
        List<Instituciones> instituciones=tmp.findAll();
        Instituciones inst=instituciones.get(0);
        ArrayList<Materias> materias= new ArrayList();
        for(int i=0; i<idMaterias.length;i++){
            Materias asignatura=(Materias) materia.find(idMaterias[i]);
            materias.add(asignatura);
        }
        grado.editarGrado(inst, nombre, materias);
    }
    
    public boolean eliminarSalon(int idSalon){
        boolean eliminado=salon.eliminarSalon(idSalon);
        return eliminado;
    }
    
    public boolean eliminarJornada(int idJornada){
        boolean eliminado=jornada.eliminarJornada(idJornada);
        return eliminado;
    }
    
    public boolean eliminarMateria(int codigo){
        boolean eliminado=materia.eliminarMateria(codigo);
        return eliminado;
    }
    
    public boolean eliminarGrado(String nombreGrado){
        boolean eliminado=grado.eliminarGrado(nombreGrado);
        return eliminado;
    }
    
    public HashMap<Integer,String> obtenerMaterias(){
        List<Materias> materias=materia.findAll();
        HashMap<Integer,String> datosMaterias= new HashMap<Integer,String>();
        for (Materias materia : materias) {
            int codigoMateria=materia.getCodigoMateria();
            String nombreMateria=materia.getNombre();
            datosMaterias.put(codigoMateria, nombreMateria);
	}
        return datosMaterias;
    }
    
    public String [] generarListadoMaterias(){
         List<Materias> materias=materia.findAll();
        String [] tmp=new String[materias.size()+1];
        tmp[0]="Aaa";
        int pos=1;
        for (Materias materia : materias) {
            String codigo=Integer.toString(materia.getCodigoMateria());
            String nombre=materia.getNombre();
            tmp[pos]=nombre+" - "+codigo;
            pos++;
	}
        Arrays.sort(tmp);
        return tmp;
    }
    
}
