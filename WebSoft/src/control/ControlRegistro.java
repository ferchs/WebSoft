/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Administrador;
import modelo.Persona;
import modelo.entidades.Administradores;
import modelo.entidades.Personas;

/**
 *
 * @author ferchs
 */
public class ControlRegistro {
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
     
    private Administrador administrador;

    public ControlRegistro() {
        this.administrador = new Administrador();
    }
    
    public boolean registrarAdministrador(String numeroId, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String usuario, String contraseña, String email){
        boolean registroExitoso=true;
        try{
            Persona persona= new Persona();
            Personas person=persona.crearPersona(numeroId, primerNombre, segundoNombre, primerApellido, segundoApellido, null,null,null);
            Administrador admin= new Administrador();
            admin.crearAdministrador(person, usuario, contraseña, email);
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
    
    public boolean validarContraseña(String contraseña1, String contraseña2){
        boolean valida=false;
        if(contraseña1.equals(contraseña2)){
            valida=true;
        }
        return valida;
    }
    
    public void eliminarAdministrador(){
        
    }
    
}
