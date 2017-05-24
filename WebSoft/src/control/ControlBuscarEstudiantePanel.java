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
import modelo.Estudiante;
import modelo.Persona;
import modelo.entidades.Estudiantes;
import modelo.entidades.RolResponsable;

/**
 *
 * @author ferchs
 */
public class ControlBuscarEstudiantePanel {
    
    private Estudiante estudiante;
    
    public ControlBuscarEstudiantePanel(){
        estudiante= new Estudiante();
    }
    
    public DefaultTableModel obtenerModeloBusqueda(String parametroBusqueda){
            if(isNumeric(parametroBusqueda)){
                Estudiantes estud=estudiante.buscarEstudiantePorId(parametroBusqueda);
                return crearModeloConEstudiante(estud);
            }
            else{
                return crearModeloConEstudiantes(estudiante.buscarEstudiantePorComodin(parametroBusqueda));
            }
    }
    
     public DefaultTableModel obtenerModeloBusquedaMatricula(String parametroBusqueda){
            if(isNumeric(parametroBusqueda)){
                Estudiantes estud=estudiante.buscarEstudiantePorId(parametroBusqueda);
                return crearModeloConEstudianteMatricula(estud);
            }
            else{
                return crearModeloConEstudiantesMatricula(estudiante.buscarEstudiantePorComodin(parametroBusqueda));
            }
    }
    
    public HashMap<String, String> obtenerDatosEstudiante(String idEstudiante){
        HashMap<String, String> datosEstudiante= new HashMap<>();
        Estudiantes estud=estudiante.buscarEstudiantePorId(idEstudiante);
        datosEstudiante.put("idEstudiante",estud.getPersonasnumeroidentificacion());
        datosEstudiante.put("tipoDocumentoEstudiante",estud.getPersonas().getDocumentoIdentidad().getTipo());
        datosEstudiante.put("primerNombreEstudiante",estud.getPersonas().getPrimerNombre());
        datosEstudiante.put("segundoNombreEstudiante",estud.getPersonas().getSegundoNombre());
        datosEstudiante.put("primerApellidoEstudiante",estud.getPersonas().getPrimerApellido());
        datosEstudiante.put("segundoApellidoEstudiante",estud.getPersonas().getSegundoApellido());
        datosEstudiante.put("rhEstudiante",estud.getPersonas().getDocumentoIdentidad().getRh());
        datosEstudiante.put("sexoEstudiante",estud.getPersonas().getDocumentoIdentidad().getSexo());
        datosEstudiante.put("fechaNacimiento",estud.getPersonas().getDocumentoIdentidad().getFechaNacimiento().toString());
        datosEstudiante.put("estratoEstudiante",estud.getPersonas().getInformacionContacto().getEstrato());
        datosEstudiante.put("paisEstudiante",estud.getPersonas().getDocumentoIdentidad().getPaisNacimiento());
        datosEstudiante.put("lugarNacimientoEstudiante",estud.getPersonas().getDocumentoIdentidad().getLugarNacimiento());
        HashMap<String, String> datosFamiliares=obtenerDatosFamiliares(estud);
        datosEstudiante.put("idFamiliar",datosFamiliares.get("idFamiliar"));
        datosEstudiante.put("tipoDocumentoFamiliar",datosFamiliares.get("tipoDocumentoFamiliar"));
        datosEstudiante.put("primerNombreFamiliar",datosFamiliares.get("primerNombreFamiliar"));
        datosEstudiante.put("segundoNombreFamiliar",datosFamiliares.get("segundoNombreFamiliar"));
        datosEstudiante.put("primerApellidoFamiliar",datosFamiliares.get("primerApellidoFamiliar"));
        datosEstudiante.put("segundoApellidoFamiliar",datosFamiliares.get("segundoApellidoFamiliar"));
        datosEstudiante.put("profesionFamiliar",datosFamiliares.get("profesionFamiliar"));
        datosEstudiante.put("parentescoFamiliar",datosFamiliares.get("parentescoFamiliar"));
        datosEstudiante.put("direccionEstudiante",estud.getPersonas().getInformacionContacto().getDireccion());
        datosEstudiante.put("barrioEstudiante",estud.getPersonas().getInformacionContacto().getBarrio());
        datosEstudiante.put("correoEstudiante",estud.getPersonas().getInformacionContacto().getCorreo());
        datosEstudiante.put("telefonoEstudiante",estud.getPersonas().getInformacionContacto().getTelefono());
        datosEstudiante.put("celularEstudiante",estud.getPersonas().getInformacionContacto().getCelular());
        datosEstudiante.put("tipoSalud",estud.getPersonas().getInformacionMedica().getSisben());
        datosEstudiante.put("nombreSaludEstudiante",estud.getPersonas().getInformacionMedica().getNombreEps());
        datosEstudiante.put("nivelSisben",estud.getPersonas().getInformacionMedica().getNivel());
        return datosEstudiante;
    }
    
    private HashMap<String, String> obtenerDatosFamiliares(Estudiantes estudiante){
        HashMap<String, String> datosFamiliares= new HashMap<>();
        Object [] rolesResponsables=estudiante.getRolResponsableCollection().toArray();
        RolResponsable rolResponsable=(RolResponsable) rolesResponsables[0];
        datosFamiliares.put("idFamiliar", rolResponsable.getPersonas().getNumeroIdentificacion());
        datosFamiliares.put("tipoDocumentoFamiliar", rolResponsable.getPersonas().getDocumentoIdentidad().getTipo());
        datosFamiliares.put("primerNombreFamiliar", rolResponsable.getPersonas().getPrimerNombre());
        datosFamiliares.put("segundoNombreFamiliar", rolResponsable.getPersonas().getSegundoNombre());
        datosFamiliares.put("primerApellidoFamiliar", rolResponsable.getPersonas().getPrimerApellido());
        datosFamiliares.put("segundoApellidoFamiliar", rolResponsable.getPersonas().getSegundoApellido());
        datosFamiliares.put("profesionFamiliar", rolResponsable.getProfesion());
        datosFamiliares.put("parentescoFamiliar", rolResponsable.getRol().getNombre());
        return datosFamiliares;
    }

    
    private ModeloTabla crearModeloConEstudiante(Estudiantes estudiante){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE ESTUDIANTE", "", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[5];
        if(estudiante!=null){
            fila[0]=estudiante.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(estudiante.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(estudiante.getPersonas().getSegundoNombre());
            if(!estudiante.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(estudiante.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(estudiante.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Visualizar","visualizar");
            fila[3]=crearBoton("Editar","editar");
            fila[4]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConEstudianteMatricula(Estudiantes estudiante){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE ESTUDIANTE", ""};
        boolean[] canEdit = new boolean [] {false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        Object [] fila= new Object[3];
        if(estudiante!=null){
            fila[0]=estudiante.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(estudiante.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(estudiante.getPersonas().getSegundoNombre());
            if(!estudiante.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(estudiante.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(estudiante.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Seleccionar","seleccionar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConEstudiantes(ArrayList<Estudiantes> estudiantes){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE ESTUDIANTE", "", "", ""};
        boolean[] canEdit = new boolean [] {false, false, false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        for(int i=0;i<estudiantes.size();i++){
            Estudiantes est=estudiantes.get(i);
            Object [] fila= new Object[5];
            fila[0]=est.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(est.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(est.getPersonas().getSegundoNombre());
            if(!est.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(est.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(est.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Visualizar","visualizar");
            fila[3]=crearBoton("Editar","editar");
            fila[4]=crearBoton("Eliminar","eliminar");
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    private ModeloTabla crearModeloConEstudiantesMatricula(ArrayList<Estudiantes> estudiantes){
        String [] columnas=new String [] {"IDENTIFICACION", "NOMBRE ESTUDIANTE", ""};
        boolean[] canEdit = new boolean [] {false, false, false};
        Class[] tipos = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.Object.class};
        ModeloTabla modeloTabla= new ModeloTabla(columnas,tipos,canEdit);
        for(int i=0;i<estudiantes.size();i++){
            Estudiantes est=estudiantes.get(i);
            Object [] fila= new Object[3];
            fila[0]=est.getPersonasnumeroidentificacion();
            StringBuilder nombre= new StringBuilder();
            nombre.append(est.getPersonas().getPrimerNombre());
            nombre.append(" ");
            nombre.append(est.getPersonas().getSegundoNombre());
            if(!est.getPersonas().getSegundoNombre().isEmpty()){
                nombre.append(" ");
            }
            nombre.append(est.getPersonas().getPrimerApellido());
            nombre.append(" ");
            nombre.append(est.getPersonas().getSegundoApellido());
            String nombreCompleto= nombre.toString();
            fila[1]=nombreCompleto;
            fila[2]=crearBoton("Seleccionar","seleccionar");
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
    
    public boolean eliminarEstudiante(String idEstudiante){
        Persona p= new Persona();
        return p.eliminarPersona(idEstudiante);
    }
    
    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
 
}
