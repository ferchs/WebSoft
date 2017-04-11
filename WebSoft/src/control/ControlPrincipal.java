/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Administrador;
import vista.InicioSesion;
import vista.RegistroAdministradores;
import vista.VentanaPrincipal;

/**
 *
 * @author ferchs
 */
public class ControlPrincipal {
    
    private VentanaPrincipal ventanaPrincipal;
    private Administrador administrador;
    private InicioSesion iniciosesion;
    private RegistroAdministradores registroAdmins;
    
    public ControlPrincipal(){
        administrador= new Administrador();
    }
    
    public void iniciarPrograma(){
        if(administrador.existenAdministradores()){
            iniciosesion= new InicioSesion();
            iniciosesion.setVisible(true);
        }
        else{
            registroAdmins= new RegistroAdministradores();
            registroAdmins.setVisible(true);
        }
    }
    
    public void mostrarPrincipal(){
        ventanaPrincipal= new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
        iniciosesion.setVisible(false);
        iniciosesion.dispose();
    }
    
}
