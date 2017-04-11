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
public class ControlFlujo {

    private VentanaPrincipal ventanaPrincipal;
    private Administrador administrador;
    private InicioSesion iniciarsesion;
    private RegistroAdministradores registroAdmins;
    
    public ControlFlujo() {
        verificarPrimerUso();
    }
    
    public void verificarPrimerUso(){
        administrador= new Administrador();
        if(administrador.existenAdministradores()){
            iniciarsesion = new InicioSesion();
            iniciarsesion.setVisible(true);
        }
        else{
            registroAdmins= new RegistroAdministradores();
            registroAdmins.setVisible(true);
        }
        
    }
    
}
