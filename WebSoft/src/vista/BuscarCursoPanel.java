/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlAdministrarCursos;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferchs
 */
public class BuscarCursoPanel extends javax.swing.JPanel  {

    /**
     * Creates new form AgregarEstudiantePanel
     */
    
    protected AdministrarCursosPanel administrarCursosPanel;
    
    public BuscarCursoPanel(AdministrarCursosPanel administrarCursosPanel) {
        controlAdministrarCursos= new ControlAdministrarCursos();
        initComponents();
        jScrollPane1= new JScrollPane();
        this.administrarCursosPanel=administrarCursosPanel;
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
        mostrar = new javax.swing.JButton();
        gradoT = new javax.swing.JLabel();
        grado = new javax.swing.JComboBox<>();
        consecutivoT = new javax.swing.JLabel();
        consecutivo = new javax.swing.JComboBox<>();
        gradoT1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBusqueda.setBackground(new java.awt.Color(102, 102, 102));
        panelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrar.setBackground(new java.awt.Color(101, 166, 148));
        mostrar.setForeground(new java.awt.Color(255, 255, 255));
        mostrar.setText("Mostrar");
        mostrar.setBorderPainted(false);
        mostrar.setOpaque(true);
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });
        panelBusqueda.add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 110, 30));

        gradoT.setBackground(new java.awt.Color(255, 255, 255));
        gradoT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        gradoT.setForeground(new java.awt.Color(255, 255, 255));
        gradoT.setText("Seleccione grado y consecutivo del curso:");
        panelBusqueda.add(gradoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        grado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gradoItemStateChanged(evt);
            }
        });
        cargarGrados();
        panelBusqueda.add(grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        consecutivoT.setBackground(new java.awt.Color(255, 255, 255));
        consecutivoT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        consecutivoT.setForeground(new java.awt.Color(255, 255, 255));
        consecutivoT.setText("Consecutivo:");
        panelBusqueda.add(consecutivoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        consecutivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        consecutivo.setEnabled(false);
        panelBusqueda.add(consecutivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        gradoT1.setBackground(new java.awt.Color(255, 255, 255));
        gradoT1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        gradoT1.setForeground(new java.awt.Color(255, 255, 255));
        gradoT1.setText("Grado:");
        panelBusqueda.add(gradoT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelBusqueda.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 280, -1));

        add(panelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        // TODO add your handling code here:
        int index=consecutivo.getSelectedIndex();
        if(index>0){
        String gradoStr=(String) grado.getSelectedItem();
        String consecutivoStr=(String) consecutivo.getSelectedItem();
        int consecutivoTmp=Integer.parseInt(consecutivoStr);
        DefaultTableModel modelo=controlAdministrarCursos.obtenerModeloBusquedaCurso(gradoStr,consecutivoTmp);
        JTable tablaResultados= new JTable();
        tablaResultados=agregarAccionesBotones(tablaResultados);
        mostrarDatosEnTabla(modelo,tablaResultados);
        }
    }//GEN-LAST:event_mostrarActionPerformed

    private void gradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gradoItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(grado.getSelectedIndex()>0){
                String nombreGrado=(String) grado.getSelectedItem();
                String [] listadoConsecutivos=controlAdministrarCursos.obtenerListadoConsecutivosDeGrado(nombreGrado);
                if(listadoConsecutivos!=null){
                    listadoConsecutivos[0]="Seleccione...";
                    DefaultComboBoxModel grados= new DefaultComboBoxModel(listadoConsecutivos);
                    consecutivo.setModel(grados);
                    consecutivo.setEnabled(true);  
                }
                else{
                    JOptionPane mensaje= new JOptionPane();
                    mensaje.setBackground(new java.awt.Color(102, 102, 102));
                    mensaje.setForeground(Color.white);
                    mensaje.showMessageDialog(null,"No existen cursos creados para el grado "+nombreGrado);
                }
            }
            else{
                    consecutivo.setEnabled(false);
                    consecutivo.setSelectedIndex(0);
                }
        }
    }//GEN-LAST:event_gradoItemStateChanged

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
                    String id=(String) tabla.getModel().getValueAt(fila,0);
                    String [] nombreCurso=id.split("-");
                    String nombreGrado=nombreCurso[0].trim();
                    int consecutivo=Integer.parseInt(nombreCurso[1].trim());
                    if(btn.getActionCommand().equals("editar")){
                        editarCurso(nombreGrado,consecutivo);
                    }
                    if(btn.getActionCommand().equals("eliminar")){
                        int respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar este curso?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(respuesta==0){
                            eliminarCurso(fila,nombreGrado,consecutivo); 
                        }
                    }
                }
            }
        });
        return tabla;
    }
    
   
    public void editarCurso(String nombreGrado,int consecutivo){
        try {
        HashMap<String, String> campos=controlAdministrarCursos.obtenerDatosCurso(nombreGrado,consecutivo);
        EditarCursoPanel ecp= new EditarCursoPanel();
        ecp.llenarCampos(campos);
        administrarCursosPanel.mostarPanel(ecp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarCurso(int fila,String nombreGrado,int consecutivo){
        boolean eliminado=controlAdministrarCursos.eliminarCurso(nombreGrado, consecutivo);
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(25);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(20);
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
    
    private final void cargarGrados(){
        String [] listadoGrados=controlAdministrarCursos.obtenerListadoGrados();
        if(listadoGrados!=null){
        listadoGrados[0]="Seleccione...";
        DefaultComboBoxModel grados= new DefaultComboBoxModel(listadoGrados);
        grado.setModel(grados);
        }
        else{
            listadoGrados=new String[1];
            listadoGrados[0]="Seleccione...";
            DefaultComboBoxModel grados= new DefaultComboBoxModel(listadoGrados);
            grado.setModel(grados);
        }
    }
    
    private ControlAdministrarCursos controlAdministrarCursos;
    private JScrollPane jScrollPane1;
    private JTable ultimoResultadoBusqueda;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> consecutivo;
    private javax.swing.JLabel consecutivoT;
    private javax.swing.JComboBox<String> grado;
    private javax.swing.JLabel gradoT;
    private javax.swing.JLabel gradoT1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mostrar;
    private javax.swing.JPanel panelBusqueda;
    // End of variables declaration//GEN-END:variables
}
