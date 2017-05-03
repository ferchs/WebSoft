/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlMenu;


/**
 *
 * @author ferchs
 */
public class MenuPanel extends javax.swing.JPanel {

    private VentanaPrincipal ventanaPrincipal;
    private EstudiantesPanel estudiantesPanel;
    private ProfesoresPanel profesoresPanel;
    private MatriculasPanel matriculasPanel;
    private CursosPanel cursosPanel;
    private RecursosFisicosPanel recursosFisicosPanel;
    private ReportesPanel reportesPanel;
    /**
     * Creates new form Menu
     */
    public MenuPanel(VentanaPrincipal principal) {
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

        estudiantes = new javax.swing.JButton();
        textoEstudiantes = new javax.swing.JLabel();
        profesores = new javax.swing.JButton();
        textoProfesores = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        matriculas = new javax.swing.JButton();
        textoMatriculas = new javax.swing.JLabel();
        cursos = new javax.swing.JButton();
        textoCursos = new javax.swing.JLabel();
        recursosFisicos = new javax.swing.JButton();
        textoRecursosFisicos = new javax.swing.JLabel();
        Reportes = new javax.swing.JButton();
        textoReportes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estudiantes.setBackground(new java.awt.Color(102, 102, 102));
        estudiantes.setForeground(new java.awt.Color(255, 255, 255));
        estudiantes.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/estudiantes.png")); // NOI18N
        estudiantes.setAutoscrolls(true);
        estudiantes.setBorderPainted(false);
        estudiantes.setOpaque(true);
        estudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudiantesActionPerformed(evt);
            }
        });
        add(estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 190, 160));

        textoEstudiantes.setBackground(new java.awt.Color(101, 166, 148));
        textoEstudiantes.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textoEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        textoEstudiantes.setText("Estudiantes");
        add(textoEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        profesores.setBackground(new java.awt.Color(102, 102, 102));
        profesores.setForeground(new java.awt.Color(255, 255, 255));
        profesores.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/profesores.png")); // NOI18N
        profesores.setAutoscrolls(true);
        profesores.setBorderPainted(false);
        profesores.setOpaque(true);
        profesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesoresActionPerformed(evt);
            }
        });
        add(profesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 190, 160));

        textoProfesores.setBackground(new java.awt.Color(255, 255, 255));
        textoProfesores.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textoProfesores.setForeground(new java.awt.Color(255, 255, 255));
        textoProfesores.setText("Profesores");
        add(textoProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 880, -1));

        matriculas.setBackground(new java.awt.Color(102, 102, 102));
        matriculas.setForeground(new java.awt.Color(255, 255, 255));
        matriculas.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/matirculas.png")); // NOI18N
        matriculas.setAutoscrolls(true);
        matriculas.setBorderPainted(false);
        matriculas.setOpaque(true);
        matriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculasActionPerformed(evt);
            }
        });
        add(matriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 190, 160));

        textoMatriculas.setBackground(new java.awt.Color(255, 255, 255));
        textoMatriculas.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textoMatriculas.setForeground(new java.awt.Color(255, 255, 255));
        textoMatriculas.setText("Matriculas");
        add(textoMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, -1, -1));

        cursos.setBackground(new java.awt.Color(102, 102, 102));
        cursos.setForeground(new java.awt.Color(255, 255, 255));
        cursos.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/cursos.png")); // NOI18N
        cursos.setAutoscrolls(true);
        cursos.setBorderPainted(false);
        cursos.setOpaque(true);
        cursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursosActionPerformed(evt);
            }
        });
        add(cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 190, 160));

        textoCursos.setBackground(new java.awt.Color(255, 255, 255));
        textoCursos.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textoCursos.setForeground(new java.awt.Color(255, 255, 255));
        textoCursos.setText("Cursos");
        add(textoCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, -1));

        recursosFisicos.setBackground(new java.awt.Color(102, 102, 102));
        recursosFisicos.setForeground(new java.awt.Color(255, 255, 255));
        recursosFisicos.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/recursosfisicos.png")); // NOI18N
        recursosFisicos.setAutoscrolls(true);
        recursosFisicos.setBorderPainted(false);
        recursosFisicos.setOpaque(true);
        recursosFisicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recursosFisicosActionPerformed(evt);
            }
        });
        add(recursosFisicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 180, 160));

        textoRecursosFisicos.setBackground(new java.awt.Color(255, 255, 255));
        textoRecursosFisicos.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textoRecursosFisicos.setForeground(new java.awt.Color(255, 255, 255));
        textoRecursosFisicos.setText("Recursos Fisicos");
        add(textoRecursosFisicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, -1, -1));

        Reportes.setBackground(new java.awt.Color(102, 102, 102));
        Reportes.setForeground(new java.awt.Color(255, 255, 255));
        Reportes.setIcon(new javax.swing.ImageIcon("/Users/ferchs/Desktop/reportes.png")); // NOI18N
        Reportes.setAutoscrolls(true);
        Reportes.setBorderPainted(false);
        Reportes.setOpaque(true);
        Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesActionPerformed(evt);
            }
        });
        add(Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 190, 160));

        textoReportes.setBackground(new java.awt.Color(255, 255, 255));
        textoReportes.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textoReportes.setForeground(new java.awt.Color(255, 255, 255));
        textoReportes.setText("Reportes");
        add(textoReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void estudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudiantesActionPerformed
        // TODO add your handling code here:
        estudiantesPanel= new EstudiantesPanel(ventanaPrincipal);
        ventanaPrincipal.mostarPanel(estudiantesPanel);
    }//GEN-LAST:event_estudiantesActionPerformed

    private void profesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesoresActionPerformed
        // TODO add your handling code here:
        profesoresPanel= new ProfesoresPanel(ventanaPrincipal);
        ventanaPrincipal.mostarPanel(profesoresPanel);
    }//GEN-LAST:event_profesoresActionPerformed

    private void matriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculasActionPerformed
        // TODO add your handling code here:
        matriculasPanel= new MatriculasPanel(ventanaPrincipal);
        ventanaPrincipal.mostarPanel(matriculasPanel);
    }//GEN-LAST:event_matriculasActionPerformed

    private void cursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursosActionPerformed
        // TODO add your handling code here:
        cursosPanel= new CursosPanel(ventanaPrincipal);
        ventanaPrincipal.mostarPanel(cursosPanel);
    }//GEN-LAST:event_cursosActionPerformed

    private void recursosFisicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recursosFisicosActionPerformed
        // TODO add your handling code here:
        recursosFisicosPanel= new RecursosFisicosPanel(ventanaPrincipal);
        ventanaPrincipal.mostarPanel(recursosFisicosPanel);
    }//GEN-LAST:event_recursosFisicosActionPerformed

    private void ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesActionPerformed
        // TODO add your handling code here:
        reportesPanel= new ReportesPanel(ventanaPrincipal);
        ventanaPrincipal.mostarPanel(reportesPanel);
    }//GEN-LAST:event_ReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reportes;
    private javax.swing.JButton cursos;
    private javax.swing.JButton estudiantes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton matriculas;
    private javax.swing.JButton profesores;
    private javax.swing.JButton recursosFisicos;
    private javax.swing.JLabel textoCursos;
    private javax.swing.JLabel textoEstudiantes;
    private javax.swing.JLabel textoMatriculas;
    private javax.swing.JLabel textoProfesores;
    private javax.swing.JLabel textoRecursosFisicos;
    private javax.swing.JLabel textoReportes;
    // End of variables declaration//GEN-END:variables
}
