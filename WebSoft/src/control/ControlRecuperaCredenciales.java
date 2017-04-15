/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.util.Properties;
import modelo.Administrador;
import modelo.Configuraciones;
import modelo.Correo;
import modelo.entidades.Administradores;

/**
 *
 * @author ferchs
 */
public class ControlRecuperaCredenciales {
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
     
    private Administrador administrador;
        
    public ControlRecuperaCredenciales() {
        this.administrador = new Administrador();
    }
    
    public boolean recuperarCredenciales(String correo){
        boolean recuperadas=false;
        Administradores admin=administrador.BuscarAdministradorPorEmail(correo);
        if(admin!=null){
            File path=new File("");
            String ruta=path.getAbsolutePath();
            Configuraciones configurador= new Configuraciones(ruta+"/configuraciones/Email.txt");
            Properties propiedadesSesion= configurador.obtenerConfiguracionesProperties();
            String emailRemitente=propiedadesSesion.getProperty("mail.user");
            Correo servidorCorreo= new Correo(propiedadesSesion);
            String asunto="Recuperacion Credenciales WebSoft";
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Su nombre de usuario es: "+admin.getUsuario());
            mensaje.append("\n");
            mensaje.append("Su contraseña es: "+admin.getContraseña());
            recuperadas=servidorCorreo.enviarCorreo(emailRemitente,"WebSoft",correo, asunto, mensaje.toString());
        }
        return recuperadas;
    }
}
