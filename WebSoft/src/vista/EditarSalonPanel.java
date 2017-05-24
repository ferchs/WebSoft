/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlAdministrarRecursos;
import java.awt.Color;
import java.text.ParseException;
import java.util.HashMap;
import javax.swing.JOptionPane;



/**
 *
 * @author ferchs
 */
public class EditarSalonPanel extends javax.swing.JPanel {

    /**
     * Creates new form AgregarEstudiantePanel
     */
    public EditarSalonPanel() {
      initComponents();
      controlAdministrarSalones= new ControlAdministrarRecursos();
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
        nombreSalonT = new javax.swing.JLabel();
        nombreSalon = new javax.swing.JTextField();
        pisoSalonT = new javax.swing.JLabel();
        pisoSalon = new javax.swing.JTextField();
        idSalon = new javax.swing.JTextField();
        idSalonT = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInformacionSalon.setBackground(new java.awt.Color(102, 102, 102));
        panelInformacionSalon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del salon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInformacionSalon.setForeground(new java.awt.Color(255, 255, 255));
        panelInformacionSalon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreSalonT.setBackground(new java.awt.Color(255, 255, 255));
        nombreSalonT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nombreSalonT.setForeground(new java.awt.Color(255, 255, 255));
        nombreSalonT.setText("Nombre:");
        panelInformacionSalon.add(nombreSalonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        nombreSalon.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        panelInformacionSalon.add(nombreSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, -1));

        pisoSalonT.setBackground(new java.awt.Color(255, 255, 255));
        pisoSalonT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        pisoSalonT.setForeground(new java.awt.Color(255, 255, 255));
        pisoSalonT.setText("Piso:");
        panelInformacionSalon.add(pisoSalonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        pisoSalon.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        panelInformacionSalon.add(pisoSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 380, -1));

        idSalon.setEditable(false);
        idSalon.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        idSalon.setForeground(new java.awt.Color(204, 204, 204));
        idSalon.setText("Ingresa un numero");
        idSalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idSalonMouseClicked(evt);
            }
        });
        panelInformacionSalon.add(idSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, -1));

        idSalonT.setBackground(new java.awt.Color(255, 255, 255));
        idSalonT.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        idSalonT.setForeground(new java.awt.Color(255, 255, 255));
        idSalonT.setText("Id Salon:");
        panelInformacionSalon.add(idSalonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        add(panelInformacionSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 410, 280));

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
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        boolean validos=validarCamposPanel();
        if(validos){
            int idSalonTmp=Integer.parseInt(idSalon.getText().trim());
            String nombreSalonTmp=nombreSalon.getText().trim();
            String pisoSalonTmp=pisoSalon.getText().trim();
            controlAdministrarSalones.editarSalon(idSalonTmp, nombreSalonTmp, pisoSalonTmp);
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

    private void idSalonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idSalonMouseClicked
        // TODO add your handling code here:
        idSalon.setForeground(Color.BLACK);
    }//GEN-LAST:event_idSalonMouseClicked

    private boolean validarCamposPanel( ){
        boolean datosCompletos=true;
      if(idSalon.getText().isEmpty()){
          try{
          idSalonT.setForeground(Color.red);
          int idSalonTmp=Integer.parseInt(idSalon.getText().trim());
          }
          catch(Exception e){
            idSalon.setText("El Id debe ser un numero");
            datosCompletos=false;
          }
      }
      if(nombreSalon.getText().isEmpty()){
          nombreSalonT.setForeground(Color.red);
          datosCompletos=false;
      }
      if(pisoSalon.getText().isEmpty()){
          pisoSalonT.setForeground(Color.red);
          datosCompletos=false;
      }
      return datosCompletos;
    }
    
    private void limpiarCampos(){
        idSalon.setText("");
        idSalonT.setForeground(Color.WHITE);
        nombreSalon.setText("");
        nombreSalonT.setForeground(Color.WHITE);
        pisoSalon.setText("");
        pisoSalonT.setForeground(Color.WHITE);
    }
    
    public void llenarCampos(HashMap<String, String> campos) throws ParseException{
        idSalon.setText(campos.get("idSalon"));
        nombreSalon.setText(campos.get("nombreSalon"));
        pisoSalon.setText(campos.get("pisoSalon"));
    }
    private ControlAdministrarRecursos controlAdministrarSalones;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardar;
    private javax.swing.JTextField idSalon;
    private javax.swing.JLabel idSalonT;
    private javax.swing.JTextField nombreSalon;
    private javax.swing.JLabel nombreSalonT;
    private javax.swing.JPanel panelInformacionSalon;
    private javax.swing.JTextField pisoSalon;
    private javax.swing.JLabel pisoSalonT;
    // End of variables declaration//GEN-END:variables
}
