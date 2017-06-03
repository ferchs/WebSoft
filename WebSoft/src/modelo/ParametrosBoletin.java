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
public class ParametrosBoletin {
    private String nombreMateria;
    private String nombreProfesor;
    private String definitiva;
    private String desempeño;

    public ParametrosBoletin(String nombreMateria, String nombreProfesor, String definitiva, String desempeño) {
        this.nombreMateria = nombreMateria;
        this.nombreProfesor = nombreProfesor;
        this.definitiva = definitiva;
        this.desempeño = desempeño;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
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
