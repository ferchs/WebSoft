/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlPrincipal;
import control.ControlRegistro;
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
public class RegistroAdministradores extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAdministradores
     */
    public RegistroAdministradores() {
        initComponents();
        controlRegistro= new ControlRegistro();
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
        numeroIDT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuarioT = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        numeroID = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        contraseñaT = new javax.swing.JLabel();
        primerNombreT = new javax.swing.JLabel();
        primerNombre = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        segundoNombreT = new javax.swing.JLabel();
        segundoNombre = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        emailT = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        primerApellidoT = new javax.swing.JLabel();
        primerApellido = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        segundoApellidoT = new javax.swing.JLabel();
        segundoApellido = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        finalizar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        confirmarContraseñaT1 = new javax.swing.JLabel();
        confirmacionContraseña = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pieDePanel.setBackground(new java.awt.Color(101, 166, 148));
        pieDePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Creative Cloud Files/websoft4.png")); // NOI18N
        pieDePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        getContentPane().add(pieDePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 730, 40));

        panelRegistro.setBackground(new java.awt.Color(102, 102, 102));
        panelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numeroIDT.setBackground(new java.awt.Color(255, 255, 255));
        numeroIDT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numeroIDT.setForeground(new java.awt.Color(255, 255, 255));
        numeroIDT.setText("No. Identificacion");
        panelRegistro.add(numeroIDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Administrador");
        panelRegistro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        usuarioT.setBackground(new java.awt.Color(255, 255, 255));
        usuarioT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        usuarioT.setForeground(new java.awt.Color(255, 255, 255));
        usuarioT.setText("Usuario");
        panelRegistro.add(usuarioT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        usuario.setBackground(new java.awt.Color(102, 102, 102));
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setBorder(null);
        usuario.setCaretColor(new java.awt.Color(255, 255, 255));
        usuario.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        usuario.setSelectionColor(new java.awt.Color(255, 255, 255));
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });
        panelRegistro.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 240, 20));

        numeroID.setBackground(new java.awt.Color(102, 102, 102));
        numeroID.setForeground(new java.awt.Color(255, 255, 255));
        numeroID.setText("Id sin puntos (.) ni comas(,)");
        numeroID.setBorder(null);
        numeroID.setCaretColor(new java.awt.Color(255, 255, 255));
        numeroID.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        numeroID.setSelectionColor(new java.awt.Color(255, 255, 255));
        numeroID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroIDMouseClicked(evt);
            }
        });
        numeroID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroIDActionPerformed(evt);
            }
        });
        panelRegistro.add(numeroID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 240, 20));

        jSeparator10.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 240, -1));

        jSeparator11.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 240, -1));

        contraseñaT.setBackground(new java.awt.Color(255, 255, 255));
        contraseñaT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        contraseñaT.setForeground(new java.awt.Color(255, 255, 255));
        contraseñaT.setText("Contraseña");
        panelRegistro.add(contraseñaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        primerNombreT.setBackground(new java.awt.Color(255, 255, 255));
        primerNombreT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        primerNombreT.setForeground(new java.awt.Color(255, 255, 255));
        primerNombreT.setText("Primer Nombre");
        panelRegistro.add(primerNombreT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        primerNombre.setBackground(new java.awt.Color(102, 102, 102));
        primerNombre.setForeground(new java.awt.Color(255, 255, 255));
        primerNombre.setBorder(null);
        primerNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        primerNombre.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        primerNombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        primerNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                primerNombreMouseClicked(evt);
            }
        });
        primerNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerNombreActionPerformed(evt);
            }
        });
        panelRegistro.add(primerNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 240, 20));

        contraseña.setBackground(new java.awt.Color(102, 102, 102));
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setBorder(null);
        contraseña.setCaretColor(new java.awt.Color(255, 255, 255));
        contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contraseñaMouseClicked(evt);
            }
        });
        panelRegistro.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 240, 20));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 240, -1));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 240, -1));

        segundoNombreT.setBackground(new java.awt.Color(255, 255, 255));
        segundoNombreT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        segundoNombreT.setForeground(new java.awt.Color(255, 255, 255));
        segundoNombreT.setText("Segundo Nombre");
        panelRegistro.add(segundoNombreT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        segundoNombre.setBackground(new java.awt.Color(102, 102, 102));
        segundoNombre.setForeground(new java.awt.Color(255, 255, 255));
        segundoNombre.setBorder(null);
        segundoNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        segundoNombre.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        segundoNombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        segundoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segundoNombreMouseClicked(evt);
            }
        });
        segundoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segundoNombreActionPerformed(evt);
            }
        });
        panelRegistro.add(segundoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 240, 20));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 240, -1));

        emailT.setBackground(new java.awt.Color(255, 255, 255));
        emailT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        emailT.setForeground(new java.awt.Color(255, 255, 255));
        emailT.setText("E-Mail");
        panelRegistro.add(emailT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

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
        panelRegistro.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 240, 20));

        jSeparator12.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 240, -1));

        primerApellidoT.setBackground(new java.awt.Color(255, 255, 255));
        primerApellidoT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        primerApellidoT.setForeground(new java.awt.Color(255, 255, 255));
        primerApellidoT.setText("Primer Apellido");
        panelRegistro.add(primerApellidoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        primerApellido.setBackground(new java.awt.Color(102, 102, 102));
        primerApellido.setForeground(new java.awt.Color(255, 255, 255));
        primerApellido.setBorder(null);
        primerApellido.setCaretColor(new java.awt.Color(255, 255, 255));
        primerApellido.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        primerApellido.setSelectionColor(new java.awt.Color(255, 255, 255));
        primerApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                primerApellidoMouseClicked(evt);
            }
        });
        primerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerApellidoActionPerformed(evt);
            }
        });
        panelRegistro.add(primerApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 240, 20));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 240, -1));

        segundoApellidoT.setBackground(new java.awt.Color(255, 255, 255));
        segundoApellidoT.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        segundoApellidoT.setForeground(new java.awt.Color(255, 255, 255));
        segundoApellidoT.setText("Segundo Apellido");
        panelRegistro.add(segundoApellidoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        segundoApellido.setBackground(new java.awt.Color(102, 102, 102));
        segundoApellido.setForeground(new java.awt.Color(255, 255, 255));
        segundoApellido.setBorder(null);
        segundoApellido.setCaretColor(new java.awt.Color(255, 255, 255));
        segundoApellido.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        segundoApellido.setSelectionColor(new java.awt.Color(255, 255, 255));
        segundoApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segundoApellidoMouseClicked(evt);
            }
        });
        segundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segundoApellidoActionPerformed(evt);
            }
        });
        panelRegistro.add(segundoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 240, 20));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 240, -1));

        finalizar.setBackground(new java.awt.Color(101, 166, 148));
        finalizar.setForeground(new java.awt.Color(255, 255, 255));
        finalizar.setText("Finalizar");
        finalizar.setBorderPainted(false);
        finalizar.setOpaque(true);
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });
        panelRegistro.add(finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 130, 40));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRegistro.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 370));

        confirmarContraseñaT1.setBackground(new java.awt.Color(255, 255, 255));
        confirmarContraseñaT1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        confirmarContraseñaT1.setForeground(new java.awt.Color(255, 255, 255));
        confirmarContraseñaT1.setText("Confirma tu contraseña");
        panelRegistro.add(confirmarContraseñaT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        confirmacionContraseña.setBackground(new java.awt.Color(102, 102, 102));
        confirmacionContraseña.setForeground(new java.awt.Color(255, 255, 255));
        confirmacionContraseña.setBorder(null);
        confirmacionContraseña.setCaretColor(new java.awt.Color(255, 255, 255));
        confirmacionContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmacionContraseñaMouseClicked(evt);
            }
        });
        panelRegistro.add(confirmacionContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 240, 20));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelRegistro.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 240, -1));

        getContentPane().add(panelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        // TODO add your handling code here:
        if(validarEntrada()){
            String numDocumento= numeroID.getText();
            String nombre1=primerNombre.getText();
            String nombre2=segundoNombre.getText();
            String apellido1=primerApellido.getText();
            String apellido2=segundoApellido.getText();
            String user=usuario.getText();
            String clave=new String(contraseña.getPassword());
            String correo=email.getText();
            boolean registroExitoso;
            registroExitoso=controlRegistro.registrarAdministrador(numDocumento, nombre1, nombre2, apellido1, apellido2, user, clave,correo);
            JOptionPane mensaje= new JOptionPane();
            if(registroExitoso){
                mensaje.setBackground(new java.awt.Color(102, 102, 102));
                mensaje.setForeground(Color.white);
                mensaje.showMessageDialog(null,"Registro exitoso");
                ControlPrincipal.getInstance().mostrarVentanaRegistroInstitucion();
                ControlPrincipal.getInstance().ocultarVentanaRegistroAdministradores();
            }
            else{
                mensaje.setBackground(new java.awt.Color(102, 102, 102));
                mensaje.setForeground(Color.white);
                mensaje.showMessageDialog(null,"Registro Fallido");
                ControlPrincipal.getInstance().iniciarPrograma();
            }
        }
    }//GEN-LAST:event_finalizarActionPerformed

    public boolean validarEntrada(){
        boolean entradaValida=true;
        if(numeroID.getText().isEmpty()){
           mostrarEntradaErrada(numeroIDT,numeroID,"Debes ingresar un numero documento");
           entradaValida=false;
        }
        else{
            mostrarEntradaNormal(numeroIDT,numeroID);
        }
        if(primerNombre.getText().isEmpty()){
           mostrarEntradaErrada(primerNombreT,primerNombre,"Debes ingresar al menos un nombre");
           entradaValida=false;
        }
        else{
            mostrarEntradaNormal(primerNombreT,primerNombre);
        }
        if(primerApellido.getText().isEmpty()){
           mostrarEntradaErrada(primerApellidoT,primerApellido,"Debes ingresar al menos un nombre");
           entradaValida=false;
        }
        else{
            mostrarEntradaNormal(primerApellidoT,primerApellido);
        }
        if(usuario.getText().isEmpty()){
           mostrarEntradaErrada(usuarioT,usuario,"Debes ingresar un nombre de usuario");
           entradaValida=false;
        }
        else{
            mostrarEntradaNormal(usuarioT,usuario);
        }
        if(contraseña.getPassword().length==0){
           mostrarEntradaErrada(contraseñaT,contraseña,"");
           entradaValida=false;
        }
        else{
            String contraseña1= new String(contraseña.getPassword());
            String contraseña2= new String(confirmacionContraseña.getPassword());
            if(!controlRegistro.validarContraseña(contraseña1, contraseña2)){
                  mostrarEntradaErrada(contraseñaT,contraseña,"");
                  mostrarEntradaErrada(confirmarContraseñaT1,confirmacionContraseña,"");
                  entradaValida=false;
            }
            else{
                mostrarEntradaNormal(contraseñaT,contraseña);
                mostrarEntradaNormal(confirmarContraseñaT1,confirmacionContraseña);
            }
        }
        if(email.getText().isEmpty()){
           mostrarEntradaErrada(emailT,email,"Debes ingresar un email");
           entradaValida=false;
        }
        else{
            if(!controlRegistro.validarEmail(email.getText())){
                  mostrarEntradaErrada(emailT,email,"Email no valido");
                  entradaValida=false;
            }
            else{
                mostrarEntradaNormal(emailT,email);
            }
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

    public JTextField getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(JTextField numeroID) {
        this.numeroID = numeroID;
    }

    public JTextField getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(JTextField primerApellido) {
        this.primerApellido = primerApellido;
    }

    public JTextField getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(JTextField primerNombre) {
        this.primerNombre = primerNombre;
    }

    public JTextField getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(JTextField segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public JTextField getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(JTextField segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    private void primerNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primerNombreActionPerformed

    private void primerNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_primerNombreMouseClicked
        // TODO add your handling code here:
         primerNombre.setText("");
    }//GEN-LAST:event_primerNombreMouseClicked

    private void segundoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_segundoNombreActionPerformed

    private void primerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primerApellidoActionPerformed

    private void segundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segundoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_segundoApellidoActionPerformed

    private void numeroIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroIDActionPerformed

    private void segundoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_segundoNombreMouseClicked
        // TODO add your handling code here:
        segundoNombre.setText("");
    }//GEN-LAST:event_segundoNombreMouseClicked

    private void primerApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_primerApellidoMouseClicked
        // TODO add your handling code here:
        primerApellido.setText("");
    }//GEN-LAST:event_primerApellidoMouseClicked

    private void segundoApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_segundoApellidoMouseClicked
        // TODO add your handling code here:
        segundoApellido.setText("");
    }//GEN-LAST:event_segundoApellidoMouseClicked

    private void numeroIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroIDMouseClicked
        // TODO add your handling code here:
        numeroID.setText("");
    }//GEN-LAST:event_numeroIDMouseClicked

    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMouseClicked
        // TODO add your handling code here:
        usuario.setText("");

    }//GEN-LAST:event_usuarioMouseClicked

    private void contraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaMouseClicked
        // TODO add your handling code here:
        contraseña.setText("");

    }//GEN-LAST:event_contraseñaMouseClicked

    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        // TODO add your handling code here:
        email.setText("");
    }//GEN-LAST:event_emailMouseClicked

    private void confirmacionContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmacionContraseñaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmacionContraseñaMouseClicked

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
    private javax.swing.JPasswordField confirmacionContraseña;
    private javax.swing.JLabel confirmarContraseñaT1;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel contraseñaT;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailT;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField numeroID;
    private javax.swing.JLabel numeroIDT;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel pieDePanel;
    private javax.swing.JTextField primerApellido;
    private javax.swing.JLabel primerApellidoT;
    private javax.swing.JTextField primerNombre;
    private javax.swing.JLabel primerNombreT;
    private javax.swing.JTextField segundoApellido;
    private javax.swing.JLabel segundoApellidoT;
    private javax.swing.JTextField segundoNombre;
    private javax.swing.JLabel segundoNombreT;
    private javax.swing.JTextField usuario;
    private javax.swing.JLabel usuarioT;
    // End of variables declaration//GEN-END:variables
    private ControlRegistro controlRegistro;
}

