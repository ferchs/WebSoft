/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JPanel;

/**
 *
 * @author ferchs
 */
public class ControlVentanaPrincipal {
    
    public void salirAplicacion(){
        ControlPrincipal.getInstance().ocultarVentanaPrincipal();
        ControlPrincipal.getInstance().mostrarInicioSesion();
    }
    
}
