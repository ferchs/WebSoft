/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ferchs
 */
public class ItemBoletin {
    
    private String nombreMateria;
    private String profesor;
    private String definitiva;
    private String desempeño;

    public ItemBoletin(String nombreMateria, String profesor, String definitiva, String desempeño) {
        this.nombreMateria = nombreMateria;
        this.profesor = profesor;
        this.definitiva = definitiva;
        this.desempeño = desempeño;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getDefinitiva() {
        return definitiva;
    }

    public void setDefinitiva(String definitiva) {
        this.definitiva = definitiva;
    }

    public String getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(String desempeño) {
        this.desempeño = desempeño;
    }
    
    
    
}
