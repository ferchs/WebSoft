/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Administrador;
import modelo.entidades.Administradores;

/**
 *
 * @author ferchs
 */
public class IniciarSesionControl {
    
    private Administrador administrador;
    
    public IniciarSesionControl(){
        administrador= new Administrador();
    }
    
    public boolean validarUsuario(String usuario, String contraseña){
        boolean valido=false;
        Administradores admin=administrador.BuscarAdministrador(usuario);
        if(admin!=null){
            if(admin.getContraseña().equals(contraseña)){
                valido=true;
            }
        }
        return valido;
    }
    
    public void recuperarContraseña(){
        
    }
}
