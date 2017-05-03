/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Institucion;

/**
 *
 * @author ferchs
 */
public class ControlRegistroInstitucion {
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
    public boolean registrarInstitucion(int nit, String nombre, String direccion, String telefono, String email){
        boolean registroExitoso=true;
        try{
            Institucion institucion= new Institucion();
            institucion.crearInstitucion(nit, nombre, direccion, telefono, email);
        }
        catch(Exception e){
            e.printStackTrace();
            registroExitoso=false;
        }
        return registroExitoso;
    }
    
    public boolean validarEmail(String email){
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
   
}
