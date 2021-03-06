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
public class ReportesPanel extends javax.swing.JPanel {

    private VentanaPrincipal ventanaPrincipal;
    private JPanel actual;
    /**
     * Creates new form Estudiantes
     */
    public ReportesPanel(VentanaPrincipal principal) {
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
        generarBoletines = new javax.swing.JButton();
        fichasMatriculas = new javax.swing.JButton();
        agregarText = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        inicioText = new javax.swing.JLabel();
        agregarText1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLogo1.setBackground(new java.awt.Color(101, 166, 148));
        PanelLogo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        generarBoletines.setBackground(new java.awt.Color(102, 102, 102));
        generarBoletines.setForeground(new java.awt.Color(255, 255, 255));
        generarBoletines.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/boletinMini.png")); // NOI18N
        generarBoletines.setBorderPainted(false);
        generarBoletines.setOpaque(true);
        generarBoletines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarBoletinesActionPerformed(evt);
            }
        });
        PanelLogo1.add(generarBoletines, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 60, -1));

        fichasMatriculas.setBackground(new java.awt.Color(102, 102, 102));
        fichasMatriculas.setForeground(new java.awt.Color(255, 255, 255));
        fichasMatriculas.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/fichamatriculaMini.png")); // NOI18N
        fichasMatriculas.setBorderPainted(false);
        fichasMatriculas.setOpaque(true);
        fichasMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fichasMatriculasActionPerformed(evt);
            }
        });
        PanelLogo1.add(fichasMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, -1));

        agregarText.setBackground(new java.awt.Color(255, 255, 255));
        agregarText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        agregarText.setForeground(new java.awt.Color(255, 255, 255));
        agregarText.setText("<html>\n<pre> Generar\nBoletines</pre>\n</html>");
        PanelLogo1.add(agregarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 60, -1));

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

        agregarText1.setBackground(new java.awt.Color(255, 255, 255));
        agregarText1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        agregarText1.setForeground(new java.awt.Color(255, 255, 255));
        agregarText1.setText("<html>\n<pre>  Fichas\nMatriculas</pre>\n</html>");
        PanelLogo1.add(agregarText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 60, -1));

        add(PanelLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void generarBoletinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarBoletinesActionPerformed
        // TODO add your handling code here:
       GenerarBoletinesPanel generarBoletinesPanel= new GenerarBoletinesPanel(this);
       mostarPanel(generarBoletinesPanel);
    }//GEN-LAST:event_generarBoletinesActionPerformed

    private void fichasMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fichasMatriculasActionPerformed
        GenerarFichaMatriculaPanel generarFichaMatriculaPanel= new GenerarFichaMatriculaPanel(this);
        mostarPanel(generarFichaMatriculaPanel);
    }//GEN-LAST:event_fichasMatriculasActionPerformed

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
    private javax.swing.JLabel agregarText;
    private javax.swing.JLabel agregarText1;
    private javax.swing.JButton fichasMatriculas;
    private javax.swing.JButton generarBoletines;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel inicioText;
    // End of variables declaration//GEN-END:variables
}
