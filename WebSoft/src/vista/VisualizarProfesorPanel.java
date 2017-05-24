/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JComboBox;


/**
 *
 * @author ferchs
 */
public class VisualizarProfesorPanel extends javax.swing.JPanel {

    /**
     * Creates new form AgregarEstudiantePanel
     */
    public VisualizarProfesorPanel(BuscarProfesorPanel buscarProfesorPanel) {
        initComponents();
        this.buscarProfesorPanel=buscarProfesorPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInformacionAcademica = new javax.swing.JPanel();
        tituloDocenteT = new javax.swing.JLabel();
        tituloDocente = new javax.swing.JTextField();
        institucionDocenteT = new javax.swing.JLabel();
        institucionDocente = new javax.swing.JTextField();
        volver = new javax.swing.JButton();
        panelInformacionDocente = new javax.swing.JPanel();
        primerNombreDocenteT = new javax.swing.JLabel();
        primerNombreDocente = new javax.swing.JTextField();
        segundoNombreDocenteT = new javax.swing.JLabel();
        segundoNombreDocente = new javax.swing.JTextField();
        primerApellidoDocenteT = new javax.swing.JLabel();
        primerApellidoDocente = new javax.swing.JTextField();
        segundoApellidoDocenteT = new javax.swing.JLabel();
        segundoApellidoDocente = new javax.swing.JTextField();
        sexoDocenteT = new javax.swing.JLabel();
        sexoDocente = new javax.swing.JComboBox<>();
        rhDocenteT = new javax.swing.JLabel();
        rhDocente = new javax.swing.JComboBox<>();
        paisDocenteT = new javax.swing.JLabel();
        paisDocente = new javax.swing.JComboBox<>();
        fechaNacimientoT = new javax.swing.JLabel();
        estratoDocenteT = new javax.swing.JLabel();
        estratoDocente = new javax.swing.JComboBox<>();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        lugarNacimientoDocenteT = new javax.swing.JLabel();
        lugarNacimientoDocente = new javax.swing.JTextField();
        idDocente = new javax.swing.JTextField();
        idDocenteT = new javax.swing.JLabel();
        tipoDocumentoDocenteT = new javax.swing.JLabel();
        tipoDocumentoDocente = new javax.swing.JComboBox<>();
        panelDatosMedicos = new javax.swing.JPanel();
        nombreSaludDocenteT = new javax.swing.JLabel();
        nombreSaludDocente = new javax.swing.JTextField();
        tipoSaludT = new javax.swing.JLabel();
        tipoSalud = new javax.swing.JComboBox<>();
        nivelSisbenT = new javax.swing.JLabel();
        nivelSisben = new javax.swing.JComboBox<>();
        panelDatosContacto = new javax.swing.JPanel();
        direccionDocenteT = new javax.swing.JLabel();
        direccionDocente = new javax.swing.JTextField();
        barrioDocenteT = new javax.swing.JLabel();
        barrioDocente = new javax.swing.JTextField();
        correoDocente = new javax.swing.JTextField();
        correoDocenteT = new javax.swing.JLabel();
        telefonoDocenteT = new javax.swing.JLabel();
        celularDocenteT = new javax.swing.JLabel();
        telefonoDocente = new javax.swing.JTextField();
        celularDocente = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInformacionAcademica.setBackground(new java.awt.Color(102, 102, 102));
        panelInformacionAcademica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Academica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInformacionAcademica.setForeground(new java.awt.Color(255, 255, 255));
        panelInformacionAcademica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        tituloDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tituloDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        tituloDocenteT.setText("Titulo:");
        panelInformacionAcademica.add(tituloDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        tituloDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tituloDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloDocenteActionPerformed(evt);
            }
        });
        panelInformacionAcademica.add(tituloDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 430, -1));

        institucionDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        institucionDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        institucionDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        institucionDocenteT.setText("Institucion:");
        panelInformacionAcademica.add(institucionDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 76, -1, -1));

        institucionDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionAcademica.add(institucionDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 95, 430, -1));

        add(panelInformacionAcademica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 460, 130));

        volver.setBackground(new java.awt.Color(101, 166, 148));
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("Volver");
        volver.setBorderPainted(false);
        volver.setOpaque(true);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, -1));

        panelInformacionDocente.setBackground(new java.awt.Color(102, 102, 102));
        panelInformacionDocente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del Docente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInformacionDocente.setForeground(new java.awt.Color(255, 255, 255));
        panelInformacionDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        primerNombreDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        primerNombreDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        primerNombreDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        primerNombreDocenteT.setText("Primer Nombre:");
        panelInformacionDocente.add(primerNombreDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, -1, -1));

        primerNombreDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionDocente.add(primerNombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, 216, -1));

        segundoNombreDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        segundoNombreDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        segundoNombreDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        segundoNombreDocenteT.setText("Segundo Nombre:");
        panelInformacionDocente.add(segundoNombreDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 78, -1, -1));

        segundoNombreDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionDocente.add(segundoNombreDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 99, 216, -1));

        primerApellidoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        primerApellidoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        primerApellidoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        primerApellidoDocenteT.setText("Primer Apellido:");
        panelInformacionDocente.add(primerApellidoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, -1, -1));

        primerApellidoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionDocente.add(primerApellidoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 151, 216, -1));

        segundoApellidoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        segundoApellidoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        segundoApellidoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        segundoApellidoDocenteT.setText("Segundo Apellido:");
        panelInformacionDocente.add(segundoApellidoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 130, -1, -1));

        segundoApellidoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionDocente.add(segundoApellidoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 151, 216, -1));

        sexoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        sexoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        sexoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        sexoDocenteT.setText("Sexo:");
        panelInformacionDocente.add(sexoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        sexoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        sexoDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Masculino", "Femenino" }));
        sexoDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoDocenteActionPerformed(evt);
            }
        });
        panelInformacionDocente.add(sexoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        rhDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        rhDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        rhDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        rhDocenteT.setText("RH:");
        panelInformacionDocente.add(rhDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        rhDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        rhDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
        panelInformacionDocente.add(rhDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        paisDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        paisDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        paisDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        paisDocenteT.setText("Pais Nacimiento:");
        panelInformacionDocente.add(paisDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        paisDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        paisDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        paisDocente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                paisDocenteItemStateChanged(evt);
            }
        });
        panelInformacionDocente.add(paisDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        fechaNacimientoT.setBackground(new java.awt.Color(255, 255, 255));
        fechaNacimientoT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        fechaNacimientoT.setForeground(new java.awt.Color(255, 255, 255));
        fechaNacimientoT.setText("Fecha De Nacimiento:");
        panelInformacionDocente.add(fechaNacimientoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        estratoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        estratoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        estratoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        estratoDocenteT.setText("Estrato:");
        panelInformacionDocente.add(estratoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        estratoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        estratoDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "1", "2", "3", "4", "5", "6" }));
        panelInformacionDocente.add(estratoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        fechaNacimiento.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionDocente.add(fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 170, -1));

        lugarNacimientoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        lugarNacimientoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lugarNacimientoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        lugarNacimientoDocenteT.setText("Lugar Nacimiento:");
        panelInformacionDocente.add(lugarNacimientoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        lugarNacimientoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lugarNacimientoDocente.setText("Seleccione Un Pais");
        lugarNacimientoDocente.setEnabled(false);
        panelInformacionDocente.add(lugarNacimientoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 170, -1));

        idDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelInformacionDocente.add(idDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 47, 216, -1));

        idDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        idDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        idDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        idDocenteT.setText("Numero Identificación:");
        panelInformacionDocente.add(idDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 26, -1, -1));

        tipoDocumentoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        tipoDocumentoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tipoDocumentoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        tipoDocumentoDocenteT.setText("Tipo:");
        panelInformacionDocente.add(tipoDocumentoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 24, -1, -1));

        tipoDocumentoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tipoDocumentoDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Tarjeta Identidad", "Cedula Ciudadania", "Cedula Extranjeria", "Registro Civil" }));
        panelInformacionDocente.add(tipoDocumentoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 45, -1, -1));

        add(panelInformacionDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 460, 300));

        panelDatosMedicos.setBackground(new java.awt.Color(102, 102, 102));
        panelDatosMedicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Medicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosMedicos.setForeground(new java.awt.Color(255, 255, 255));
        panelDatosMedicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreSaludDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        nombreSaludDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        nombreSaludDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        nombreSaludDocenteT.setText("Nombre:");
        panelDatosMedicos.add(nombreSaludDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        nombreSaludDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        nombreSaludDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreSaludDocenteActionPerformed(evt);
            }
        });
        panelDatosMedicos.add(nombreSaludDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 296, -1));

        tipoSaludT.setBackground(new java.awt.Color(255, 255, 255));
        tipoSaludT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tipoSaludT.setForeground(new java.awt.Color(255, 255, 255));
        tipoSaludT.setText("Tipo:");
        panelDatosMedicos.add(tipoSaludT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tipoSalud.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        tipoSalud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "EPS", "SISBEN" }));
        tipoSalud.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoSaludItemStateChanged(evt);
            }
        });
        tipoSalud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoSaludActionPerformed(evt);
            }
        });
        panelDatosMedicos.add(tipoSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        nivelSisbenT.setBackground(new java.awt.Color(255, 255, 255));
        nivelSisbenT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        nivelSisbenT.setForeground(new java.awt.Color(255, 255, 255));
        nivelSisbenT.setText("Nivel:");
        panelDatosMedicos.add(nivelSisbenT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        nivelSisben.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        nivelSisben.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "1", "2" }));
        nivelSisben.setEnabled(false);
        nivelSisben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivelSisbenActionPerformed(evt);
            }
        });
        panelDatosMedicos.add(nivelSisben, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        add(panelDatosMedicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 320, 200));

        panelDatosContacto.setBackground(new java.awt.Color(102, 102, 102));
        panelDatosContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        panelDatosContacto.setForeground(new java.awt.Color(255, 255, 255));
        panelDatosContacto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direccionDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        direccionDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        direccionDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        direccionDocenteT.setText("Dirección:");
        panelDatosContacto.add(direccionDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        direccionDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        direccionDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionDocenteActionPerformed(evt);
            }
        });
        panelDatosContacto.add(direccionDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 296, -1));

        barrioDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        barrioDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        barrioDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        barrioDocenteT.setText("Barrio:");
        panelDatosContacto.add(barrioDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 76, -1, -1));

        barrioDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelDatosContacto.add(barrioDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 95, 296, -1));

        correoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelDatosContacto.add(correoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, 296, -1));

        correoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        correoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        correoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        correoDocenteT.setText("Correo:");
        panelDatosContacto.add(correoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 126, -1, -1));

        telefonoDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        telefonoDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        telefonoDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        telefonoDocenteT.setText("Teléfono:");
        panelDatosContacto.add(telefonoDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 182, -1, -1));

        celularDocenteT.setBackground(new java.awt.Color(255, 255, 255));
        celularDocenteT.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        celularDocenteT.setForeground(new java.awt.Color(255, 255, 255));
        celularDocenteT.setText("Celular:");
        panelDatosContacto.add(celularDocenteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        telefonoDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelDatosContacto.add(telefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 201, 110, -1));

        celularDocente.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        panelDatosContacto.add(celularDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 130, -1));

        add(panelDatosContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 320, 230));
    }// </editor-fold>//GEN-END:initComponents

    public void llenarCampos(HashMap<String, String> campos) throws ParseException{
        idDocente.setText(campos.get("idProfesor"));
        MostrarItem(tipoDocumentoDocente,campos.get("tipoDocumentoProfesor"));
        primerNombreDocente.setText(campos.get("primerNombreProfesor"));
        segundoNombreDocente.setText(campos.get("segundoNombreProfesor"));
        primerApellidoDocente.setText(campos.get("primerApellidoProfesor"));
        segundoApellidoDocente.setText(campos.get("segundoApellidoProfesor"));
        MostrarItem(rhDocente,campos.get("rhProfesor"));
        MostrarItem(sexoDocente,campos.get("sexoProfesor"));
        String fechaNac=campos.get("fechaNacimiento");
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.US);
        Date date = format.parse(fechaNac);
        fechaNacimiento.setDate(date);
        MostrarItem(estratoDocente,campos.get("estratoProfesor"));
        MostrarItem(paisDocente,campos.get("paisProfesor"));
        lugarNacimientoDocente.setText(campos.get("lugarNacimientoProfesor"));
        direccionDocente.setText(campos.get("direccionProfesor"));
        barrioDocente.setText(campos.get("barrioProfesor"));
        correoDocente.setText(campos.get("correoProfesor"));
        telefonoDocente.setText(campos.get("telefonoProfesor"));
        celularDocente.setText(campos.get("celularProfesor"));
        tituloDocente.setText(campos.get("tituloProfesor"));
        institucionDocente.setText(campos.get("institucionProfesor"));
        MostrarItem(tipoSalud,campos.get("tipoSalud"));
        nombreSaludDocente.setText(campos.get("nombreSaludProfesor"));
        MostrarItem(nivelSisben,campos.get("nivelSisben"));
    }
    
    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        buscarProfesorPanel.volver(buscarProfesorPanel);
    }//GEN-LAST:event_volverActionPerformed

    private void sexoDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoDocenteActionPerformed

    private void paisDocenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_paisDocenteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_paisDocenteItemStateChanged

    private void nivelSisbenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivelSisbenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivelSisbenActionPerformed

    private void tipoSaludActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoSaludActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoSaludActionPerformed

    private void tipoSaludItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoSaludItemStateChanged
        // TODO add your handling code here
    }//GEN-LAST:event_tipoSaludItemStateChanged

    private void nombreSaludDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreSaludDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreSaludDocenteActionPerformed

    private void direccionDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionDocenteActionPerformed

    private void tituloDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloDocenteActionPerformed

    
    private void MostrarItem(JComboBox comboBox, String itemSeleccionado){
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {itemSeleccionado}));
    }
    
    private BuscarProfesorPanel buscarProfesorPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barrioDocente;
    private javax.swing.JLabel barrioDocenteT;
    private javax.swing.JTextField celularDocente;
    private javax.swing.JLabel celularDocenteT;
    private javax.swing.JTextField correoDocente;
    private javax.swing.JLabel correoDocenteT;
    private javax.swing.JTextField direccionDocente;
    private javax.swing.JLabel direccionDocenteT;
    private javax.swing.JComboBox<String> estratoDocente;
    private javax.swing.JLabel estratoDocenteT;
    private com.toedter.calendar.JDateChooser fechaNacimiento;
    private javax.swing.JLabel fechaNacimientoT;
    private javax.swing.JTextField idDocente;
    private javax.swing.JLabel idDocenteT;
    private javax.swing.JTextField institucionDocente;
    private javax.swing.JLabel institucionDocenteT;
    private javax.swing.JTextField lugarNacimientoDocente;
    private javax.swing.JLabel lugarNacimientoDocenteT;
    private javax.swing.JComboBox<String> nivelSisben;
    private javax.swing.JLabel nivelSisbenT;
    private javax.swing.JTextField nombreSaludDocente;
    private javax.swing.JLabel nombreSaludDocenteT;
    private javax.swing.JComboBox<String> paisDocente;
    private javax.swing.JLabel paisDocenteT;
    private javax.swing.JPanel panelDatosContacto;
    private javax.swing.JPanel panelDatosMedicos;
    private javax.swing.JPanel panelInformacionAcademica;
    private javax.swing.JPanel panelInformacionDocente;
    private javax.swing.JTextField primerApellidoDocente;
    private javax.swing.JLabel primerApellidoDocenteT;
    private javax.swing.JTextField primerNombreDocente;
    private javax.swing.JLabel primerNombreDocenteT;
    private javax.swing.JComboBox<String> rhDocente;
    private javax.swing.JLabel rhDocenteT;
    private javax.swing.JTextField segundoApellidoDocente;
    private javax.swing.JLabel segundoApellidoDocenteT;
    private javax.swing.JTextField segundoNombreDocente;
    private javax.swing.JLabel segundoNombreDocenteT;
    private javax.swing.JComboBox<String> sexoDocente;
    private javax.swing.JLabel sexoDocenteT;
    private javax.swing.JTextField telefonoDocente;
    private javax.swing.JLabel telefonoDocenteT;
    private javax.swing.JComboBox<String> tipoDocumentoDocente;
    private javax.swing.JLabel tipoDocumentoDocenteT;
    private javax.swing.JComboBox<String> tipoSalud;
    private javax.swing.JLabel tipoSaludT;
    private javax.swing.JTextField tituloDocente;
    private javax.swing.JLabel tituloDocenteT;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}