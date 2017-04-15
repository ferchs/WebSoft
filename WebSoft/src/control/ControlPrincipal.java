/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Administrador;
import modelo.Preferencias;
import vista.InicioSesion;
import vista.RecuperaCredenciales;
import vista.RegistroAdministradores;
import vista.RegistroCorreoApp;
import vista.VentanaPrincipal;

/**
 *
 * @author ferchs
 */
public class ControlPrincipal {
    
    private static ControlPrincipal instance = null;
    private VentanaPrincipal ventanaPrincipal;
    private Administrador administrador;
    private InicioSesion iniciosesion;
    private RegistroAdministradores registroAdmins;
    private RecuperaCredenciales recuperaCredenciales;
    private RegistroCorreoApp registroCorreoApp;

    
    protected ControlPrincipal(){
        administrador= new Administrador();
    }
    
    public static ControlPrincipal getInstance() {
        if(instance == null) {
            instance = new ControlPrincipal();
        }
      return instance;
   }
    
    public void mostrarVentanaPrincipal(){
        ventanaPrincipal= new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLocationRelativeTo(null);
    }
    
    public void ocultarVentanaPrincipal(){
        ventanaPrincipal.setVisible(false);
        ventanaPrincipal.dispose();
    }
    
    public void mostarVentanaRegistro(){
        registroAdmins= new RegistroAdministradores();
        registroAdmins.setVisible(true);
        registroAdmins.setLocationRelativeTo(null);
    }
    
    public void ocultarVentanaRegistro(){
        registroAdmins.setVisible(false);
        registroAdmins.dispose();
    }
    
    public void mostrarInicioSesion(){
        iniciosesion= new InicioSesion();
        iniciosesion.setVisible(true);
        iniciosesion.setLocationRelativeTo(null);

    }
    
    public void ocultarInicioSesion(){
        iniciosesion.setVisible(false);
        iniciosesion.dispose();
    }
    
    public void mostrarUsuarioEnSesion(String usuario){
        ventanaPrincipal.mostrarUsuarioEnSesion(usuario);
    }
    
    public void mostrarVentanaRecuperacionCredenciales(){
        recuperaCredenciales= new RecuperaCredenciales();
        recuperaCredenciales.setVisible(true);
        recuperaCredenciales.setLocationRelativeTo(null);
    }
    
    public void ocultarVentanaRecuperacionCredenciales(){
        recuperaCredenciales.setVisible(false);
        recuperaCredenciales.dispose();
    }
    
    public void mostrarVentanaRegistroCorreo(){
        registroCorreoApp= new RegistroCorreoApp();
        registroCorreoApp.setVisible(true);
        registroCorreoApp.setLocationRelativeTo(null);
    }
    
    public void ocultarVentanaRegistroCorreo(){
        registroCorreoApp.setVisible(false);
        registroCorreoApp.dispose();
    }
    
    public void iniciarPrograma(){
        Preferencias pref= new Preferencias();
        String correo=pref.obtenerPreferencia("WebSoft.correo");
        String clave=pref.obtenerPreferencia("WebSoft.clave");
        if(correo==null || clave==null){
            mostrarVentanaRegistroCorreo();
        }
        else{
            if(administrador.existenAdministradores()){
            mostrarInicioSesion();
            }
            else{
                mostrarVentanaRegistroCorreo();
            }
        }
    }
}
