/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Correo;
import modelo.Preferencias;

/**
 *
 * @author ferchs
 */
public class ControlRegistroCorreoApp {
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public boolean comprobarCredencialesCorreo(String email, String contraseña){
        Properties propiedades= new Properties();
        propiedades.setProperty("mail.smtp.auth","true");
        propiedades.setProperty("mail.smtp.starttls.enable","true");
        propiedades.setProperty("mail.smtp.host","smtp.gmail.com");
        propiedades.setProperty("mail.smtp.port","587");
        propiedades.setProperty("mail.user",email);
        propiedades.setProperty("mail.password",contraseña);
        Correo mail = new Correo(propiedades);
        boolean exito= mail.comprobarCredencialesSesion();
        return exito;
    }
    
    public boolean validarEmail(String email){
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public void almacenarPreferenciasDeCorreo(String email, String contraseña){
        Preferencias pref= new Preferencias();
        pref.almacenarPreferencia("WebSoft.correo", email);
        pref.almacenarPreferencia("WebSoft.clave", contraseña);
    }
    
}
