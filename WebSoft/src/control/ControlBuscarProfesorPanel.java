/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Profesor;
import modelo.entidades.Profesores;

/**
 *
 * @author ferchs
 */
public class ControlBuscarProfesorPanel {
    
    private Profesor profesor;
    
    public ControlBuscarProfesorPanel(){
        profesor= new Profesor();
    }
    
    public DefaultTableModel obtenerModeloBusqueda(String parametroBusqueda){
        try{
            Integer.parseInt(parametroBusqueda);
            Profesores profe=profesor.buscarProfesorPorId(parametroBusqueda);
            return crearModeloConProfesor(profe);
        }
        catch(Exception e){
            return crearModeloConProfesores(profesor.buscarProfesorPorComodin(parametroBusqueda));
        }
    }
    
    public DefaultTableModel obtenerModeloBusquedaMatricula(String parametroBusqueda){
            Profesores profe=profesor.buscarProfesorPorId(parametroBusqueda);
            return crearModeloConProfesorMatricula(profe);
    }
    
    public HashMap<String, String> obtenerDatosProfesor(String idProfesor){
        HashMap<String, String> datosProfesor= new HashMap<>();
        Profesores profe=profesor.buscarProfesorPorId(idProfesor);
        datosProfesor.put("idProfesor",profe.getPersonasnumeroidentificacion());
        datosProfesor.put("tipoDocumentoProfesor",profe.getPersonas().getDocumentoIdentidad().getTipo());
        datosProfesor.put("primerNombreProfesor",profe.getPersonas().getPrimerNombre());
        datosProfesor.put("segundoNombreProfesor",profe.getPersonas().getSegundoNombre());
        datosProfesor.put("primerApellidoProfesor",profe.getPersonas().getPrimerApellido());
        datosProfesor.put("segundoApellidoProfesor",profe.getPersonas().getSegundoApellido());
        datosProfesor.put("rhProfesor",profe.getPersonas().getDocumentoIdentidad().getRh());
        datosProfesor.put("sexoProfesor",profe.getPersonas().getDocumentoIdentidad().getSexo());
        datosProfesor.put("fechaNacimiento",profe.getPersonas().getDocumentoIdentidad().getFechaNacimiento().toString());
        datosProfesor.put("estratoProfesor",profe.getPersonas().getInformacionContacto().getEstrato());
        datosProfesor.put("paisProfesor",profe.getPersonas().getDocumentoIdentidad().getPaisNacimiento());
        datosProfesor.put("lugarNacimientoProfesor",profe.getPersonas().getDocumentoIdentidad().getLugarNacimiento());
        datosProfesor.put("direccionProfesor",profe.getPersonas().getInformacionContacto().getDireccion());
        datosProfesor.put("barrioProfesor",profe.getPersonas().getInformacionContacto().getBarrio());
        datosProfesor.put("correoProfesor",profe.getPersonas().getInformacionContacto().getCorreo());
        datosProfesor.put("telefonoProfesor",profe.getPersonas().getInformacionContacto().getTelefono());
        datosProfesor.put("celularProfesor",profe.getPersonas().getInformacionContacto().getCelular());
        datosProfesor.put("tituloProfesor",profe.getTitulo());
        datosProfesor.put("institucionProfesor",profe.getInstitucion());
        datosProfesor.put("tipoSalud",profe.getPersonas().getInformacionMedica().getSisben());
        datosProfesor.put("nombreSaludProfesor",profe.getPersonas().getInformacionMedica().getNombreEps());
        datosProfesor.put("nivelSisben",profe.getPersonas().getInformacionMedica().getNivel());
        return datosProfesor;
    }
    
    private ModeloTabla crearModeloConProfesor(Profesores profe){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE DOCENTE", "", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[5];
        if(profe!=null){
            fila[0]=profe.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(profe.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(profe.getPersonas().getSegundoNombre());
            if(!profe.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(profe.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(profe.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Visualizar","visualizar");
            fila[3]=crearBoton("Editar","editar");
            fila[4]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConProfesorMatricula(Profesores profe){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE DOCENTE", ""};
        boolean[] canEdit = new boolean [] {false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[3];
        if(profe!=null){
            fila[0]=profe.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(profe.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(profe.getPersonas().getSegundoNombre());
            if(!profe.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(profe.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(profe.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Seleccionar","seleccionar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConProfesores(ArrayList<Profesores> profesores){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE DOCENTE", "", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        for(int i=0;i<profesores.size();i++){
            Profesores prof=profesores.get(i);
            Object [] fila= new Object[5];
            fila[0]=prof.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(prof.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(prof.getPersonas().getSegundoNombre());
            if(!prof.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(prof.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(prof.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Visualizar","visualizar");
            fila[3]=crearBoton("Editar","editar");
            fila[4]=crearBoton("Eliminar","eliminar");
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
    
    public boolean eliminarProfesor(String idProfesor){
        Persona p= new Persona();
        return p.eliminarPersona(idProfesor);
    }
 
}
