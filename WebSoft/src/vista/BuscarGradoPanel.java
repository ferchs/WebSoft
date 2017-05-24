/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlAdministrarRecursos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferchs
 */
public class BuscarGradoPanel extends javax.swing.JPanel  {

    /**
     * Creates new form AgregarEstudiantePanel
     */
    
    protected AdministrarGradosPanel administrarGradosPanel;
    
    public BuscarGradoPanel(AdministrarGradosPanel administrarGradosPanel) {
        initComponents();
        controlAdministrarGrados= new ControlAdministrarRecursos();
        jScrollPane1= new JScrollPane();
        this.administrarGradosPanel=administrarGradosPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBusqueda = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        barraBusqueda = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBusqueda.setBackground(new java.awt.Color(102, 102, 102));
        panelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(101, 166, 148));
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.setBorderPainted(false);
        buscar.setOpaque(true);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        panelBusqueda.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 110, 30));

        barraBusqueda.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        barraBusqueda.setForeground(new java.awt.Color(204, 204, 204));
        barraBusqueda.setText("Ingrese el nombre del grado");
        barraBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barraBusquedaMouseClicked(evt);
            }
        });
        panelBusqueda.add(barraBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 630, -1));

        add(panelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void barraBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraBusquedaMouseClicked
        // TODO add your handling code here:
        barraBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        barraBusqueda.setText("");
    }//GEN-LAST:event_barraBusquedaMouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        String itemBusquedaStr=barraBusqueda.getText().toLowerCase();
        DefaultTableModel modelo=controlAdministrarGrados.obtenerModeloBusquedaGrado(itemBusquedaStr);
        JTable tablaResultados= new JTable();
        tablaResultados=agregarAccionesBotones(tablaResultados);
        mostrarDatosEnTabla(modelo,tablaResultados);
    }//GEN-LAST:event_buscarActionPerformed

    public void mostrarDatosEnTabla(DefaultTableModel modelo, JTable tabla){
         tabla.setModel(modelo);  
         tabla=aplicarFormatoTabla(tabla);
         ultimoResultadoBusqueda=tabla;
         add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 710, 470));
         revalidate();
         repaint();
    }
     public void mostrarDatosEnTabla(JTable tabla){
         jScrollPane1.setViewportView(tabla);
         add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 710, 470));
         revalidate();
         repaint();
    }
    
    private JTable agregarAccionesBotones(JTable tabla){
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int columna = tabla.columnAtPoint(e.getPoint());
                if (tabla.getModel().getColumnClass(columna).equals(Object.class)) {
                    JButton btn=(JButton) tabla.getModel().getValueAt(fila, columna);
                    String nombreGrado=(String) tabla.getModel().getValueAt(fila,0);
                    
                    if(btn.getActionCommand().equals("editar")){
                        editarGrado(nombreGrado);
                    }
                    if(btn.getActionCommand().equals("eliminar")){
                        int respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar este grado?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(respuesta==0){
                            eliminarGrado(nombreGrado,fila); 
                        }
                    }
                }
            }
        });
        return tabla;
    }
    
   
    public void editarGrado(String nombreGrado){
        try {
        HashMap<String, Object> campos=controlAdministrarGrados.obtenerDatosGrado(nombreGrado);
        EditarGradoPanel egp= new EditarGradoPanel();
        egp.llenarCampos(campos);
        administrarGradosPanel.mostarPanel(egp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarGrado(String nombreGrado,int fila){
        boolean eliminado=controlAdministrarGrados.eliminarGrado(nombreGrado);
        if(eliminado){
            DefaultTableModel modelo=(DefaultTableModel) ultimoResultadoBusqueda.getModel();
            modelo.removeRow(fila);
            mostrarDatosEnTabla(modelo,ultimoResultadoBusqueda);
        }
    }
    
    private JTable aplicarFormatoTabla(JTable tabla){
       tabla.setRowHeight(20);
       tabla.setDefaultRenderer(Object.class, new BotonTablaRender());
       tabla.setGridColor(new java.awt.Color(102, 102, 102));
       tabla.setSelectionBackground(new java.awt.Color(101, 166, 148));
       tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       tabla.setRowSelectionAllowed(true);
       tabla.getTableHeader().setReorderingAllowed(false);
       jScrollPane1.setViewportView(tabla);
       tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(50);

        }
        return tabla;
    }
    
    private DefaultTableModel crearModeloTabla(String [] columnas, Class[] types, Object [][] datos){

        for(int i=0;i<datos.length;i++){
            
        }
         return new javax.swing.table.DefaultTableModel(datos,columnas) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    }
    
    protected void volver(JPanel panel){
    }
    
    private ControlAdministrarRecursos controlAdministrarGrados;
    private JScrollPane jScrollPane1;
    private JTable ultimoResultadoBusqueda;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraBusqueda;
    private javax.swing.JButton buscar;
    private javax.swing.JPanel panelBusqueda;
    // End of variables declaration//GEN-END:variables
}
