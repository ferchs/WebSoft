/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Responsable;
import modelo.Roles;
import modelo.entidades.DocumentoIdentidad;
import modelo.entidades.Estudiantes;
import modelo.entidades.InformacionContacto;
import modelo.entidades.InformacionMedica;
import modelo.entidades.Personas;
import modelo.entidades.Rol;

/**
 *
 * @author ferchs
 */
public class ControlAgregarEstudiantePanel {
    
    public boolean agregarEstudiante(String idEstudiante,String tipoDocumentoEstudiante,String primerNombreEstudiante,
            String segundoNombreEstudiante,String primerApellidoEstudiante,String segundoApellidoEstudiante,
            String rhEstudiante,String sexoEstudiante,Date fechaNacimiento, String estratoEstudiante, 
            String paisEstudiante,String lugarNacimientoEstudiante,String idFamiliar,String tipoDocumentoFamiliar,
            String primerNombreFamiliar,String segundoNombreFamiliar,String primerApellidoFamiliar,
            String segundoApellidoFamiliar,String profesionFamiliar,String parentescoFamiliar, String direccionEstudiante,
            String barrioEstudiante,String correoEstudiante,String telefonoEstudiante,String celularEstudiante,
            String tipoSalud,String nombreSaludEstudiante,String nivelSisben){
        
        boolean agregado=true;
        DocumentoIdentidad di= new DocumentoIdentidad();
        di.setPersonasId(idEstudiante);
        di.setFechaNacimiento(fechaNacimiento);
        di.setLugarNacimiento(lugarNacimientoEstudiante);
        di.setPaisNacimiento(paisEstudiante);
        di.setRh(rhEstudiante);
        di.setSexo(sexoEstudiante);
        di.setTipo(tipoDocumentoEstudiante);
        
        InformacionContacto ic= new InformacionContacto();
        ic.setPersonasId(idEstudiante);
        ic.setBarrio(barrioEstudiante);
        ic.setCelular(celularEstudiante);
        ic.setCorreo(correoEstudiante);
        ic.setDireccion(direccionEstudiante);
        ic.setEstrato(estratoEstudiante);
        ic.setTelefono(telefonoEstudiante);
        
        InformacionMedica im= new InformacionMedica();
        im.setPersonasId(idEstudiante);
        im.setSisben(tipoSalud);
        im.setNivel(nivelSisben);
        im.setNombreEps(nombreSaludEstudiante);
        
        try{
        Persona p= new Persona();
        Personas persona=p.crearPersona(idEstudiante, primerNombreEstudiante, segundoNombreEstudiante, primerApellidoEstudiante, segundoApellidoEstudiante, di, ic, im);
        DocumentoIdentidad di2= new DocumentoIdentidad();
        di2.setPersonasId(idFamiliar);
        di2.setTipo(tipoDocumentoFamiliar);
        Personas familiar=p.crearPersona(idFamiliar, primerNombreFamiliar, segundoNombreFamiliar, primerApellidoFamiliar, segundoApellidoFamiliar, di2, null, null);
        Roles roles= new Roles();
        Rol rol=roles.crearRol(parentescoFamiliar);
        Estudiante est= new Estudiante();
        Responsable responsable= new Responsable();
        Estudiantes estudiante=est.crearEstudiante(persona);
        responsable.crearResponsable(rol, familiar, estudiante, profesionFamiliar);
        }
        catch(Exception e){
            e.printStackTrace();
            agregado=false;
        }
        return agregado;
    }
    
    
    
    public String [] generarListadoPaises(){
        String [] locales= Locale.getISOCountries();
        String [] tmp=new String[contarPaisesCortos()+1];
        tmp[0]="Aaa";
        int pos=1;
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            String pais=obj.getDisplayCountry();
            if(pais.length()<26){
                tmp[pos]=pais;
                pos++;
            }
	}
        Arrays.sort(tmp);
        return tmp;
    }
    
    private int contarPaisesCortos(){
        int total=0;
        String [] locales= Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            String pais=obj.getDisplayCountry();
            if(pais.length()<26){
                total++;
            }
	}
        return total;
    }
    
}
