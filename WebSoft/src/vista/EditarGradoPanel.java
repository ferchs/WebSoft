/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlAdministrarRecursos;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ferchs
 */
public class EditarGradoPanel extends javax.swing.JPanel {

    /**
     * Creates new form AgregarEstudiantePanel
     */
    public EditarGradoPanel() {
      controlAdministrarGrados= new ControlAdministrarRecursos();
      initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInformacionSalon = new javax.swing.JPanel();
        nombreGrado = new javax.swing.JTextField();
        materiasT = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        nombreGradoT = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        materias = new javax.swing.JComboBox<>();
        guardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInformacionSalon.setBackground(new java.awt.Color(102, 102, 102));
        panelInformacionSalon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del grado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInformacionSalon.setForeground(new java.awt.Color(255, 255, 255));
        panelInformacionSalon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreGrado.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        panelInformacionSalon.add(nombreGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 380, -1));

        materiasT.setBackground(new java.awt.Color(255, 255, 255));
        materiasT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        materiasT.setForeground(new java.awt.Color(255, 255, 255));
        materiasT.setText("Materias:");
        panelInformacionSalon.add(materiasT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "MATERIA", "ACCIONES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMaterias);
        if (tablaMaterias.getColumnModel().getColumnCount() > 0) {
            tablaMaterias.getColumnModel().getColumn(0).setResizable(false);
            tablaMaterias.getColumnModel().getColumn(0).setPreferredWidth(120);
            tablaMaterias.getColumnModel().getColumn(1).setResizable(false);
            tablaMaterias.getColumnModel().getColumn(1).setPreferredWidth(210);
            tablaMaterias.getColumnModel().getColumn(2).setResizable(false);
            tablaMaterias.getColumnModel().getColumn(2).setPreferredWidth(120);
        }

        panelInformacionSalon.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, 260));

        nombreGradoT.setBackground(new java.awt.Color(255, 255, 255));
        nombreGradoT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nombreGradoT.setForeground(new java.awt.Color(255, 255, 255));
        nombreGradoT.setText("Nombre:");
        panelInformacionSalon.add(nombreGradoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        agregar.setBackground(new java.awt.Color(101, 166, 148));
        agregar.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("Agregar");
        agregar.setBorderPainted(false);
        agregar.setOpaque(true);
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        panelInformacionSalon.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 90, 20));

        cargarMaterias();
        panelInformacionSalon.add(materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        add(panelInformacionSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 650, 450));

        guardar.setBackground(new java.awt.Color(101, 166, 148));
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.setBorderPainted(false);
        guardar.setOpaque(true);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        boolean validos=validarCamposPanel();
        if(validos){
            String nombreGradoTmp=nombreGrado.getText().trim();
            int [] idMaterias=obtenerIdMaterias();
            controlAdministrarGrados.editarGrado(nombreGradoTmp, idMaterias);
            JOptionPane mensaje= new JOptionPane();
            mensaje.setBackground(new java.awt.Color(102, 102, 102));
            mensaje.setForeground(Color.white);
            mensaje.showMessageDialog(null,"Se ha modificado exitosamente");
            limpiarCampos();
        }
        else{
            JOptionPane mensaje= new JOptionPane();
            mensaje.setBackground(new java.awt.Color(102, 102, 102));
            mensaje.setForeground(Color.white);
            mensaje.showMessageDialog(null,"Debes completar los campos indicados"); 
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        int itemIndex=materias.getSelectedIndex();
        if(itemIndex>0){
          String item=(String) materias.getSelectedItem();
          int index=item.indexOf("-");
          String tmp=item.substring(index+1,item.length()).trim();
          int idMateria=Integer.parseInt(tmp);
          boolean agregada=verificarIdMateriaLista(idMateria);
          if(agregada){
              JOptionPane mensaje= new JOptionPane();
                mensaje.setBackground(new java.awt.Color(102, 102, 102));
                mensaje.setForeground(Color.white);
                mensaje.showMessageDialog(null,"La materia ya fue agregada");
          }
          else{
          String nombre=item.substring(0, index).trim();
          DefaultTableModel modeloTabla=controlAdministrarGrados.crearModeloAgregarMateria(tablaMaterias, idMateria, nombre);
          tablaMaterias.setModel(modeloTabla);
          tablaMaterias=agregarAccionesBotones(tablaMaterias);
          tablaMaterias=aplicarFormatoTabla(tablaMaterias);
          revalidate();
          repaint();
          }
        }
        else{
            JOptionPane mensaje= new JOptionPane();
                mensaje.setBackground(new java.awt.Color(102, 102, 102));
                mensaje.setForeground(Color.white);
                mensaje.showMessageDialog(null,"Debes seleccionar una materia");
        }
    }//GEN-LAST:event_agregarActionPerformed

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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(210);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
        }
        return tabla;
    }
    
    private JTable agregarAccionesBotones(JTable tabla){
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int columna = tabla.columnAtPoint(e.getPoint());
                if (tabla.getModel().getColumnClass(columna).equals(Object.class)) {
                    JButton btn=(JButton) tabla.getModel().getValueAt(fila,columna);
                    if(btn.getActionCommand().equals("remover")){
                        remover(fila); 
                    }
                 
                }
            }
        });
        return tabla;
    }
    
    private boolean verificarIdMateriaLista(int idMateria){
        DefaultTableModel modeloTabla=(DefaultTableModel) tablaMaterias.getModel();
        int [] idMaterias= new int [tablaMaterias.getRowCount()];
        for(int i=0; i<idMaterias.length;i++){
            idMaterias[i]=(int) tablaMaterias.getValueAt(i,0);
        }
        boolean encontrado=false;
        for(int j=0;j<idMaterias.length && !encontrado;j++){
            int id=idMaterias[j];
            if(id==idMateria){
                encontrado=true;
            }
        }
        return encontrado;
    }
    
    private int[] obtenerIdMaterias(){
        DefaultTableModel modeloTabla=(DefaultTableModel) tablaMaterias.getModel();
        int [] idMaterias= new int [tablaMaterias.getRowCount()];
        for(int i=0; i<idMaterias.length;i++){
            idMaterias[i]=(int) tablaMaterias.getValueAt(i,0);
        }
        return idMaterias;
    }
    
    private void remover(int fila){
        DefaultTableModel modeloTabla=(DefaultTableModel) tablaMaterias.getModel();
        modeloTabla.removeRow(fila);
        tablaMaterias.setModel(modeloTabla);  
    }
    
    private boolean validarCamposPanel( ){
        boolean datosCompletos=true;
        if(nombreGrado.getText().isEmpty()){
            nombreGradoT.setForeground(Color.red);
            datosCompletos=false;
        }
        DefaultTableModel modeloTabla=(DefaultTableModel) tablaMaterias.getModel();
        int totalFilas=modeloTabla.getRowCount();
        if(totalFilas==0){
            materiasT.setForeground(Color.red);
            datosCompletos=false;
        }
      return datosCompletos;
    }
    
    private void limpiarCampos(){
        nombreGrado.setText("");
        nombreGradoT.setForeground(Color.WHITE);
        materiasT.setForeground(Color.WHITE);
        materias.setSelectedIndex(0);
        DefaultTableModel modeloTabla=(DefaultTableModel) tablaMaterias.getModel();
        while(tablaMaterias.getRowCount()>0){
            modeloTabla.removeRow(0);
        }
        tablaMaterias.setModel(modeloTabla);
    }
    
    
    public void llenarCampos(HashMap<String, Object> campos) throws ParseException{
        nombreGrado.setText((String) campos.get("nombreGrado"));
        materias.setSelectedIndex(0);
        HashMap<String, String> listaMaterias=(HashMap<String, String>) campos.get("materias");
        for ( Map.Entry<String, String> entry : listaMaterias.entrySet()) {
          DefaultTableModel modeloTabla=controlAdministrarGrados.crearModeloAgregarMateria(tablaMaterias, Integer.parseInt(entry.getKey()), entry.getValue());
          tablaMaterias.setModel(modeloTabla);
          tablaMaterias=agregarAccionesBotones(tablaMaterias);
          tablaMaterias=aplicarFormatoTabla(tablaMaterias);
        }
        revalidate();
        repaint();
    }
    
    private void cargarMaterias(){
        String [] listadoMaterias=controlAdministrarGrados.generarListadoMaterias();
        listadoMaterias[0]="Seleccione...";
        DefaultComboBoxModel materiasModel= new DefaultComboBoxModel(listadoMaterias);
        materias.setModel(materiasModel);
    }
    
    private ControlAdministrarRecursos controlAdministrarGrados;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton guardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> materias;
    private javax.swing.JLabel materiasT;
    private javax.swing.JTextField nombreGrado;
    private javax.swing.JLabel nombreGradoT;
    private javax.swing.JPanel panelInformacionSalon;
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables
}