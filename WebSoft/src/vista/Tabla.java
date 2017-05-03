/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ferchs
 */
public class Tabla extends JTable implements ActionListener{
    
    public final static String VISUALIZAR="visualizar";
    public final static String EDITAR="editar";
    public final static String ELIMINAR="eliminar";
    private String [] columnas;
    private Object[][] datos;
    
    public Tabla(String[] columnas,Object[][] datos){
        super(datos,columnas);
        this.columnas=columnas;
        this.datos=datos;
    }
    
    public Tabla(DefaultTableModel modelo){
        super(modelo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VISUALIZAR)){
            System.out.println(VISUALIZAR);
        }
        if(e.getActionCommand().equals(EDITAR)){
            System.out.println(EDITAR);
        }
        if(e.getActionCommand().equals(ELIMINAR)){
            System.out.println(ELIMINAR);
        }
    }
    
}
