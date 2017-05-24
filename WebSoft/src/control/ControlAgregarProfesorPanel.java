/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import modelo.Persona;
import modelo.Profesor;
import modelo.entidades.DocumentoIdentidad;
import modelo.entidades.InformacionContacto;
import modelo.entidades.InformacionMedica;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class ControlAgregarProfesorPanel {
    
    public boolean agregarProfesor(String idProfesor,String tipoDocumentoProfesor,String primerNombreProfesor,
            String segundoNombreProfesor,String primerApellidoProfesor,String segundoApellidoProfesor,
            String rhProfesor,String sexoProfesor,Date fechaNacimiento, String estratoProfesor, 
            String paisProfesor,String lugarNacimientoProfesor,String direccionProfesor,String barrioProfesor,
            String correoProfesor,String telefonoProfesor, String celularProfesor,String tipoSalud,
            String nombreSaludProfesor,String tituloProfesor, String institucionProfesor,String nivelSisben){
        
        boolean agregado=true;
        DocumentoIdentidad di= new DocumentoIdentidad();
        di.setPersonasId(idProfesor);
        di.setFechaNacimiento(fechaNacimiento);
        di.setLugarNacimiento(lugarNacimientoProfesor);
        di.setPaisNacimiento(paisProfesor);
        di.setRh(rhProfesor);
        di.setSexo(sexoProfesor);
        di.setTipo(tipoDocumentoProfesor);
        
        InformacionContacto ic= new InformacionContacto();
        ic.setPersonasId(idProfesor);
        ic.setBarrio(barrioProfesor);
        ic.setCelular(celularProfesor);
        ic.setCorreo(correoProfesor);
        ic.setDireccion(direccionProfesor);
        ic.setEstrato(estratoProfesor);
        ic.setTelefono(telefonoProfesor);
        
        InformacionMedica im= new InformacionMedica();
        im.setPersonasId(idProfesor);
        im.setSisben(tipoSalud);
        im.setNivel(nivelSisben);
        im.setNombreEps(nombreSaludProfesor);
        
        try{
        Persona p= new Persona();
        Personas persona=p.crearPersona(idProfesor, primerNombreProfesor, segundoNombreProfesor, primerApellidoProfesor, segundoApellidoProfesor, di, ic, im);
        Profesor profe = new Profesor();
        profe.crearProfesor(persona,tituloProfesor,institucionProfesor);
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
