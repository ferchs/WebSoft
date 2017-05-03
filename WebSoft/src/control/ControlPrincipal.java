/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Administrador;
import modelo.Institucion;
import modelo.Preferencias;
import vista.EstudiantesPanel;
import vista.InicioSesion;
import vista.RecuperaCredenciales;
import vista.RegistroAdministradores;
import vista.RegistroCorreoApp;
import vista.RegistroInstitucion;
import vista.VentanaPrincipal;

/**
 *
 * @author ferchs
 */
public class ControlPrincipal {
    
    private static ControlPrincipal instance = null;
    private VentanaPrincipal ventanaPrincipal;
    private Administrador administrador;
    private Institucion institucion;
    private InicioSesion iniciosesion;
    private RegistroAdministradores registroAdmins;
    private RecuperaCredenciales recuperaCredenciales;
    private RegistroCorreoApp registroCorreoApp;
    private RegistroInstitucion registroInstitucion;

    
    protected ControlPrincipal(){
        administrador= new Administrador();
        institucion= new Institucion();
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
    
    public void mostarVentanaRegistroAdministradores(){
        registroAdmins= new RegistroAdministradores();
        registroAdmins.setVisible(true);
        registroAdmins.setLocationRelativeTo(null);
    }
    
    public void ocultarVentanaRegistroAdministradores(){
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
    
    public void mostrarVentanaRegistroInstitucion(){
        registroInstitucion= new RegistroInstitucion();
        registroInstitucion.setVisible(true);
        registroInstitucion.setLocationRelativeTo(null);
    }
    
    public void ocultarVentanaRegistroInstitucion(){
        registroInstitucion.setVisible(false);
        registroInstitucion.dispose();
    }
    
    
    public void iniciarPrograma(){
        if(institucion.existeInstitucion()){
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
        else{
           mostrarVentanaRegistroInstitucion();  
        }
    }
}
