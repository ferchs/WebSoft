/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JPanel;

/**
 *
 * @author ferchs
 */
public class EstudiantesPanel extends javax.swing.JPanel {

    private VentanaPrincipal ventanaPrincipal;
    private JPanel actual;
    /**
     * Creates new form Estudiantes
     */
    public EstudiantesPanel(VentanaPrincipal principal) {
        initComponents();
        ventanaPrincipal=principal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogo1 = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        buscarText = new javax.swing.JLabel();
        agregarText = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        inicioText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogo1.setBackground(new java.awt.Color(101, 166, 148));
        PanelLogo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(102, 102, 102));
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/buscar.png")); // NOI18N
        buscar.setBorderPainted(false);
        buscar.setOpaque(true);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        PanelLogo1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 60, -1));

        agregar.setBackground(new java.awt.Color(102, 102, 102));
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/agregar.png")); // NOI18N
        agregar.setBorderPainted(false);
        agregar.setOpaque(true);
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        PanelLogo1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, -1));

        buscarText.setBackground(new java.awt.Color(255, 255, 255));
        buscarText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        buscarText.setForeground(new java.awt.Color(255, 255, 255));
        buscarText.setText("Buscar");
        PanelLogo1.add(buscarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        agregarText.setBackground(new java.awt.Color(255, 255, 255));
        agregarText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        agregarText.setForeground(new java.awt.Color(255, 255, 255));
        agregarText.setText("Agregar");
        PanelLogo1.add(agregarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        inicio.setBackground(new java.awt.Color(102, 102, 102));
        inicio.setForeground(new java.awt.Color(255, 255, 255));
        inicio.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/inicio.png")); // NOI18N
        inicio.setBorderPainted(false);
        inicio.setOpaque(true);
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        PanelLogo1.add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 60, -1));

        inicioText.setBackground(new java.awt.Color(255, 255, 255));
        inicioText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        inicioText.setForeground(new java.awt.Color(255, 255, 255));
        inicioText.setText("inicio");
        PanelLogo1.add(inicioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        add(PanelLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        BuscarEstudiantePanel buscarEstudiantePanel= new BuscarEstudiantePanel();
        mostarPanel(buscarEstudiantePanel);
    }//GEN-LAST:event_buscarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        AgregarEstudiantePanel agregarEstudiantePanel= new AgregarEstudiantePanel();
        mostarPanel(agregarEstudiantePanel);
    }//GEN-LAST:event_agregarActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        ventanaPrincipal.mostarMenu();
    }//GEN-LAST:event_inicioActionPerformed

    public void mostarPanel(JPanel panel){
//        panelFondo.setVisible(true);
        if(actual!=null){
            remove(actual);
        }
        actual=panel;
        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 810, 580));
//        panelFondo.setVisible(false);
        revalidate();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogo1;
    private javax.swing.JButton agregar;
    private javax.swing.JLabel agregarText;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel buscarText;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel inicioText;
    // End of variables declaration//GEN-END:variables
}
