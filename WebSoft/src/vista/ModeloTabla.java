/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferchs
 */
public class ModeloTabla extends DefaultTableModel{
    
    private String [] columnas;
    private Object[][] datos;
    
    public ModeloTabla(String [] columnas,Object[][] datos){
        super(datos,columnas);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
  
}
