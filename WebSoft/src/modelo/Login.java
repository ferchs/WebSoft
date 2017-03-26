/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.entidades.Administradores;

/**
 *
 * @author ferchs
 */
public class Login {
    
    private String usuario;
    
    private String contraseña;
    
    private Administradores logueado;

    public Login(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        logueado=null;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean iniciarSesion(String usuario, String contraseña){
        Administrador temporal = new Administrador();
        Administradores administrador=temporal.BuscarAdministrador(usuario);
        if(administrador.getContraseña().equals(contraseña)){
            logueado=administrador;
            return true;
        }
        else{
            return false;
        }
    }
    
    public void cerrarSesion(){
        logueado=null;
    }
    
    public boolean cambiarContraseña(String contraseñaAnterior, String nuevaContraseña){
        boolean cambioexitoso=false;
        if(logueado!=null){
            if(logueado.getContraseña().equals(contraseñaAnterior)){
                logueado.setContraseña(nuevaContraseña);
                Administrador admin = new Administrador();
                admin.edit(admin);
                cambioexitoso=true;
            }
        }
        return cambioexitoso;
    }
    
    public boolean cambiarCorreo(String correoAnterior, String nuevoCorreo){
        boolean cambioexitoso=false;
        if(logueado!=null){
            if(logueado.getContraseña().equals(correoAnterior)){
                logueado.setContraseña(nuevoCorreo);
                Administrador admin = new Administrador();
                admin.edit(admin);
                cambioexitoso=true;
            }
        }
        return cambioexitoso;
    }
    
    public boolean recuperarContraseña(String usuario){
        return true;
    }
    
    
    
    
}
