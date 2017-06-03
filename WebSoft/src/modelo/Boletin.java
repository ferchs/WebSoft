/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.entidades.Estudiantes;


/**
 *
 * @author ferchs
 */
public class Boletin {
    private Estudiante estudiante;
    private String idEstudiante;
    private ArrayList<ItemBoletin> itemBoletines;
    
    public Boletin(String idEstudiante){
        this.idEstudiante=idEstudiante;
        estudiante= new Estudiante();
        itemBoletines= new ArrayList<ItemBoletin>();
    }
    
    public void agregarItem(String nombreMateria, String profesor, String definitiva, String desempeño){
        ItemBoletin item= new ItemBoletin(nombreMateria,profesor,definitiva,desempeño);
        itemBoletines.add(item);
    }
    
    public ArrayList<ItemBoletin> obtenerItems(){
        return itemBoletines;
    }
    
    public String obtenerNombreEstudiante(){
        Estudiantes student=estudiante.buscarEstudiantePorId(idEstudiante);
        StringBuilder nombreCompleto= new StringBuilder();
        nombreCompleto.append(student.getPersonas().getPrimerNombre());
        nombreCompleto.append(" ");
        String segundoNombre=student.getPersonas().getSegundoNombre();
        if(!segundoNombre.isEmpty()|| segundoNombre==null ){
            nombreCompleto.append(" ");
        }
        nombreCompleto.append(student.getPersonas().getPrimerApellido());
        nombreCompleto.append(" ");
        nombreCompleto.append(student.getPersonas().getSegundoApellido());
        return nombreCompleto.toString();
    }
    
}
