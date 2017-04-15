/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.prefs.Preferences;

/**
 *
 * @author ferchs
 */
public class Preferencias {
    
    private Preferences preferences;
    
    public Preferencias(){
    preferences = Preferences.userNodeForPackage(Preferencias.class);
    }

  public void almacenarPreferencia(String llave, String valor) {
    preferences.put(llave, valor);
  }

  public String obtenerPreferencia(String llave) {
    return preferences.get(llave, null);
  }

}
