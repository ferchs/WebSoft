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
public class RecursosPanel extends javax.swing.JPanel {

    private VentanaPrincipal ventanaPrincipal;
    private JPanel actual;
    /**
     * Creates new form Estudiantes
     */
    public RecursosPanel(VentanaPrincipal principal) {
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
        administrarSalones = new javax.swing.JButton();
        agregarSalonText = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        inicioText = new javax.swing.JLabel();
        gestionarJornadas = new javax.swing.JButton();
        agregarJornadaText = new javax.swing.JLabel();
        gestionarMaterias = new javax.swing.JButton();
        buscarText = new javax.swing.JLabel();
        administrarGrados = new javax.swing.JButton();
        buscarText1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogo1.setBackground(new java.awt.Color(101, 166, 148));
        PanelLogo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        administrarSalones.setBackground(new java.awt.Color(102, 102, 102));
        administrarSalones.setForeground(new java.awt.Color(255, 255, 255));
        administrarSalones.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/salondeclasesMini.png")); // NOI18N
        administrarSalones.setBorderPainted(false);
        administrarSalones.setOpaque(true);
        administrarSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarSalonesActionPerformed(evt);
            }
        });
        PanelLogo1.add(administrarSalones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, -1));

        agregarSalonText.setBackground(new java.awt.Color(255, 255, 255));
        agregarSalonText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        agregarSalonText.setForeground(new java.awt.Color(255, 255, 255));
        agregarSalonText.setText("<html>\n<pre>Administrar\n  Salones</pre>\n</html>");
        PanelLogo1.add(agregarSalonText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

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

        gestionarJornadas.setBackground(new java.awt.Color(102, 102, 102));
        gestionarJornadas.setForeground(new java.awt.Color(255, 255, 255));
        gestionarJornadas.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/jornadaMini.png")); // NOI18N
        gestionarJornadas.setBorderPainted(false);
        gestionarJornadas.setOpaque(true);
        gestionarJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarJornadasActionPerformed(evt);
            }
        });
        PanelLogo1.add(gestionarJornadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 60, -1));

        agregarJornadaText.setBackground(new java.awt.Color(255, 255, 255));
        agregarJornadaText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        agregarJornadaText.setForeground(new java.awt.Color(255, 255, 255));
        agregarJornadaText.setText("<html>\n<pre>Gestionar\nJornadas</pre>\n</html>");
        PanelLogo1.add(agregarJornadaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        gestionarMaterias.setBackground(new java.awt.Color(102, 102, 102));
        gestionarMaterias.setForeground(new java.awt.Color(255, 255, 255));
        gestionarMaterias.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/materiaMini.png")); // NOI18N
        gestionarMaterias.setBorderPainted(false);
        gestionarMaterias.setOpaque(true);
        gestionarMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarMateriasActionPerformed(evt);
            }
        });
        PanelLogo1.add(gestionarMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 60, -1));

        buscarText.setBackground(new java.awt.Color(255, 255, 255));
        buscarText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        buscarText.setForeground(new java.awt.Color(255, 255, 255));
        buscarText.setText("<html>\n<pre> Gestionar\n Materias</pre>\n</html>");
        PanelLogo1.add(buscarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        administrarGrados.setBackground(new java.awt.Color(102, 102, 102));
        administrarGrados.setForeground(new java.awt.Color(255, 255, 255));
        administrarGrados.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/gradosMini.png")); // NOI18N
        administrarGrados.setBorderPainted(false);
        administrarGrados.setOpaque(true);
        administrarGrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarGradosActionPerformed(evt);
            }
        });
        PanelLogo1.add(administrarGrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 60, -1));

        buscarText1.setBackground(new java.awt.Color(255, 255, 255));
        buscarText1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        buscarText1.setForeground(new java.awt.Color(255, 255, 255));
        buscarText1.setText("<html> \n<pre>Administrar  \n  Grados</pre> \n</html>");
        PanelLogo1.add(buscarText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        add(PanelLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void administrarSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarSalonesActionPerformed
        // TODO add your handling code here:
        AdministrarSalonesPanel administrarSalonesPanel= new AdministrarSalonesPanel(this);
        ventanaPrincipal.mostarPanel(administrarSalonesPanel);
    }//GEN-LAST:event_administrarSalonesActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        ventanaPrincipal.mostarMenu();
    }//GEN-LAST:event_inicioActionPerformed

    private void gestionarJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarJornadasActionPerformed
        // TODO add your handling code here:
        GestionarJornadasPanel gestionarJornadasPanel= new GestionarJornadasPanel(this);
        ventanaPrincipal.mostarPanel(gestionarJornadasPanel);
    }//GEN-LAST:event_gestionarJornadasActionPerformed

    private void gestionarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarMateriasActionPerformed
       GestionarMateriasPanel gestionarMateriasPanel= new GestionarMateriasPanel(this);
        ventanaPrincipal.mostarPanel(gestionarMateriasPanel);
    }//GEN-LAST:event_gestionarMateriasActionPerformed

    private void administrarGradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarGradosActionPerformed
        // TODO add your handling code here:
        AdministrarGradosPanel administrarGradosPanel= new AdministrarGradosPanel(this);
        ventanaPrincipal.mostarPanel(administrarGradosPanel);
    }//GEN-LAST:event_administrarGradosActionPerformed

    public void mostrarInicio(){
        ventanaPrincipal.mostarMenu();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogo1;
    private javax.swing.JButton administrarGrados;
    private javax.swing.JButton administrarSalones;
    private javax.swing.JLabel agregarJornadaText;
    private javax.swing.JLabel agregarSalonText;
    private javax.swing.JLabel buscarText;
    private javax.swing.JLabel buscarText1;
    private javax.swing.JButton gestionarJornadas;
    private javax.swing.JButton gestionarMaterias;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel inicioText;
    // End of variables declaration//GEN-END:variables
}