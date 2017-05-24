/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferchs
 */
public class ModeloTabla extends DefaultTableModel {
    
    private Class[] types;
    private boolean[] canEdit;
    
    public ModeloTabla(String [] columnas,Class[] types,boolean[] canEdit){
        super(null,columnas);
        this.types=types;
        this.canEdit=canEdit;
    }
    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
}
