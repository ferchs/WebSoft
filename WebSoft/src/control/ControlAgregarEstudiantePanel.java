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
import modelo.entidades.DocumentoIdentidad;
import modelo.entidades.InformacionContacto;
import modelo.entidades.InformacionMedica;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class ControlAgregarEstudiantePanel {
    
    public void AgregarEstudiante(String idEstudiante,String tipoDocumentoEstudiante,String primerNombreEstudiante,
            String segundoNombreEstudiante,String primerApellidoEstudiante,String segundoApellidoEstudiante,
            String rhEstudiante,String sexoEstudiante,Date fechaNacimiento, String estratoEstudiante, 
            String paisEstudiante,String lugarNacimientoEstudiante,String idFamiliar,String tipoDocumentoFamiliar,
            String primerNombreFamiliar,String segundoNombreFamiliar,String primerApellidoFamiliar,
            String segundoApellidoFamiliar,String profesionFamiliar,String parentescoFamiliar, String direccionEstudiante,
            String barrioEstudiante,String correoEstudiante,String telefonoEstudiante,String celularEstudiante,
            String tipoSalud,String nombreSaludEstudiante,String nivelSisben){
        
        DocumentoIdentidad di= new DocumentoIdentidad();
        di.setPersonasId(idEstudiante);
        di.setFechaNacimiento(fechaNacimiento);
        di.setLugarNacimiento(lugarNacimientoEstudiante);
        di.setPaisNacimiento(paisEstudiante);
        di.setRh(rhEstudiante);
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
        
        Persona p= new Persona();
        Personas persona=p.crearPersona(idEstudiante, primerNombreEstudiante, segundoNombreEstudiante, primerApellidoEstudiante, segundoApellidoEstudiante, di, ic, im);
     
        Estudiante est= new Estudiante();
        est.crearEstudiante(persona);
        
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
