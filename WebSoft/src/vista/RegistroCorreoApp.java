/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlPrincipal;
import control.ControlRegistroCorreoApp;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author ferchs
 */
public class RegistroCorreoApp extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAdministradores
     */
    public RegistroCorreoApp() {
        initComponents();
        controlRegistroCorreoApp= new ControlRegistroCorreoApp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pieDePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRegistro = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        contraseñaT = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        texto = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        siguiente = new javax.swing.JButton();
        emailT = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pieDePanel.setBackground(new java.awt.Color(101, 166, 148));
        pieDePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Creative Cloud Files/websoft4.png")); // NOI18N
        pieDePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        getContentPane().add(pieDePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 410, 570, 40));

        panelRegistro.setBackground(new java.awt.Color(102, 102, 102));
        panelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bienvenido!");
        panelRegistro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        contraseñaT.setBackground(new java.awt.Color(255, 255, 255));
        contraseñaT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        contraseñaT.setForeground(new java.awt.Color(255, 255, 255));
        contraseñaT.setText("Contraseña");
        panelRegistro.add(contraseñaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        contraseña.setBackground(new java.awt.Color(102, 102, 102));
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setBorder(null);
        contraseña.setCaretColor(new java.awt.Color(255, 255, 255));
        contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contraseñaMouseClicked(evt);
            }
        });
        panelRegistro.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 240, 20));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 240, -1));

        texto.setBackground(new java.awt.Color(255, 255, 255));
        texto.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setText("<html> <p align=\"center\">Configura un E-Mail de Gmail para tu WebSoft. Para esto debes ingresar una</p> <p  align=\"center\">direccion de correo de Gmail y su respectiva contraseña.</p> </html>");
        panelRegistro.add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        email.setBackground(new java.awt.Color(102, 102, 102));
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setBorder(null);
        email.setCaretColor(new java.awt.Color(255, 255, 255));
        email.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        email.setSelectionColor(new java.awt.Color(255, 255, 255));
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailMouseClicked(evt);
            }
        });
        panelRegistro.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 240, 20));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 560, -1));

        siguiente.setBackground(new java.awt.Color(101, 166, 148));
        siguiente.setForeground(new java.awt.Color(255, 255, 255));
        siguiente.setText("Siguiente");
        siguiente.setBorderPainted(false);
        siguiente.setOpaque(true);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        panelRegistro.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 130, 40));

        emailT.setBackground(new java.awt.Color(255, 255, 255));
        emailT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        emailT.setForeground(new java.awt.Color(255, 255, 255));
        emailT.setText("E-Mail");
        panelRegistro.add(emailT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 240, -1));

        getContentPane().add(panelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
        if(validarEntrada()){
            String correo=email.getText();
            String clave=new String(contraseña.getPassword());
            boolean inicioExitoso;
            inicioExitoso=controlRegistroCorreoApp.comprobarCredencialesCorreo(correo, clave);
            JOptionPane mensaje= new JOptionPane();
            if(inicioExitoso){
                controlRegistroCorreoApp.almacenarPreferenciasDeCorreo(correo, clave);
                ControlPrincipal.getInstance().mostarVentanaRegistro();
                ControlPrincipal.getInstance().ocultarVentanaRegistroCorreo();
            }
            else{
                mensaje.setBackground(new java.awt.Color(102, 102, 102));
                mensaje.setForeground(Color.white);
                mensaje.showMessageDialog(null,"Comprueba tus credenciales. No se pudo iniciar sesion");
                ControlPrincipal.getInstance().iniciarPrograma();
            }
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        // TODO add your handling code here:
        email.setText("");
    }//GEN-LAST:event_emailMouseClicked

    private void contraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaMouseClicked
        // TODO add your handling code here:
        contraseña.setText("");
    }//GEN-LAST:event_contraseñaMouseClicked
    
    public boolean validarEntrada(){
        boolean entradaValida=true;
        if(email.getText().isEmpty()){
           mostrarEntradaErrada(emailT,email,"Debes ingresar un email");
           entradaValida=false;
        }
        else{
            if(!controlRegistroCorreoApp.validarEmail(email.getText())){
                  mostrarEntradaErrada(emailT,email,"Email no valido");
                  entradaValida=false;
            }
            else{
                mostrarEntradaNormal(emailT,email);
            }
        }
        
        if(contraseña.getPassword().length==0){
           mostrarEntradaErrada(contraseñaT,contraseña,"");
           entradaValida=false;
        }   
        return entradaValida;
    }
    
    public void mostrarEntradaErrada(JLabel titulo, JTextComponent texto, String comentario){
        titulo.setForeground(Color.red);
        texto.setForeground(Color.red);
        texto.setText(comentario);
        panelRegistro.revalidate();
        panelRegistro.repaint();
    }
    
    public void mostrarEntradaNormal(JLabel titulo, JTextComponent texto){
        titulo.setForeground(Color.white);
        texto.setForeground(Color.white);
        panelRegistro.revalidate();
        panelRegistro.repaint();
    }
    public JPasswordField getContraseña() {
        return contraseña;
    }

    public void setContraseña(JPasswordField contraseña) {
        this.contraseña = contraseña;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegistroAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegistroAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegistroAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegistroAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegistroAdministradores().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel contraseñaT;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel pieDePanel;
    private javax.swing.JButton siguiente;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
    private ControlRegistroCorreoApp controlRegistroCorreoApp;
}
