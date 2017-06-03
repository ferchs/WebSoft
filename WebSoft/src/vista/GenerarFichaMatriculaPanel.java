/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlBuscarEstudiantePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ferchs
 */
public class GenerarFichaMatriculaPanel extends javax.swing.JPanel  {

    /**
     * Creates new form AgregarEstudiantePanel
     */
    protected ReportesPanel reportesPanel;
    public GenerarFichaMatriculaPanel(ReportesPanel reportesPanel) {
        initComponents();
        jScrollPane1= new JScrollPane();
        controlBuscarEstudiantePanel= new ControlBuscarEstudiantePanel();
        this.reportesPanel=reportesPanel;
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
        buscar = new javax.swing.JButton();
        barraBusqueda = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBusqueda.setBackground(new java.awt.Color(102, 102, 102));
        panelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(101, 166, 148));
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.setBorderPainted(false);
        buscar.setOpaque(true);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        panelBusqueda.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 110, 30));

        barraBusqueda.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        barraBusqueda.setForeground(new java.awt.Color(204, 204, 204));
        barraBusqueda.setText("Buscar estudiante por nombre o número de documento");
        barraBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barraBusquedaMouseClicked(evt);
            }
        });
        panelBusqueda.add(barraBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 630, -1));

        add(panelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void barraBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraBusquedaMouseClicked
        // TODO add your handling code here:
        barraBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        barraBusqueda.setText("");
    }//GEN-LAST:event_barraBusquedaMouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        String itemBusqueda=barraBusqueda.getText().toLowerCase().trim();
        DefaultTableModel modelo=controlBuscarEstudiantePanel.obtenerModeloBusquedaFichaMatricula(itemBusqueda);
        JTable tablaResultados= new JTable();
        tablaResultados=agregarAccionesBotones(tablaResultados);
        mostrarDatosEnTabla(modelo,tablaResultados);
    }//GEN-LAST:event_buscarActionPerformed

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
                    String id=(String)tabla.getModel().getValueAt(fila,0);
                    if(btn.getActionCommand().equals("generar")){
                        generarFichaMatricula(id);
                    }
                }
            }
        });
        return tabla;
    }
    
    public void generarFichaMatricula(String idEstudiante){
        try {
            Map<String, String> datosEstudiante=controlBuscarEstudiantePanel.obtenerDatosEstudiante(idEstudiante);
            datosEstudiante.put("NumeroIdentificacion",datosEstudiante.get("idEstudiante"));
            datosEstudiante.put("TipoDocumento",datosEstudiante.get("tipoDocumentoEstudiante"));
            datosEstudiante.put("PrimerNombre",datosEstudiante.get("primerNombreEstudiante"));
            datosEstudiante.put("SegundoNombre",datosEstudiante.get("segundoNombreEstudiante"));
            datosEstudiante.put("PrimerApellido",datosEstudiante.get("primerApellidoEstudiante"));
            datosEstudiante.put("SegundoApellido",datosEstudiante.get("segundoApellidoEstudiante"));
            datosEstudiante.put("RH",datosEstudiante.get("rhEstudiante"));
            datosEstudiante.put("Estrato",datosEstudiante.get("estratoEstudiante"));
            datosEstudiante.put("Sexo",datosEstudiante.get("sexoEstudiante"));
            String fechaNac=datosEstudiante.get("fechaNacimiento");
            DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.US);
            String fecha="";
            try {
                Date date = (Date) format.parse(fechaNac);
                DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy");
                fecha = df.format(date);
            } catch (ParseException ex) {
                Logger.getLogger(GenerarFichaMatriculaPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            datosEstudiante.put("FechaNacimiento",fecha);
            datosEstudiante.put("LugarNacimiento",datosEstudiante.get("lugarNacimientoEstudiante"));
            datosEstudiante.put("Pais",datosEstudiante.get("paisEstudiante"));
            datosEstudiante.put("Direccion",datosEstudiante.get("direccionEstudiante"));
            datosEstudiante.put("Barrio",datosEstudiante.get("barrioEstudiante"));
            datosEstudiante.put("Correo",datosEstudiante.get("correoEstudiante"));
            datosEstudiante.put("Telefono",datosEstudiante.get("telefonoEstudiante"));
            datosEstudiante.put("Celular",datosEstudiante.get("celularEstudiante"));
            datosEstudiante.put("IdFamiliar",datosEstudiante.get("idFamiliar"));
            datosEstudiante.put("TipoIdFamiliar",datosEstudiante.get("tipoDocumentoFamiliar"));
            datosEstudiante.put("PrimerNombreF",datosEstudiante.get("primerNombreFamiliar"));
            datosEstudiante.put("SegundoNombreF",datosEstudiante.get("segundoNombreFamiliar"));
            datosEstudiante.put("PrimerApellidoF",datosEstudiante.get("primerApellidoFamiliar"));
            datosEstudiante.put("SegundoApellidoF",datosEstudiante.get("segundoApellidoFamiliar"));
            datosEstudiante.put("Parentesco",datosEstudiante.get("parentescoFamiliar"));
            datosEstudiante.put("Profesion",datosEstudiante.get("profesionFamiliar"));
            datosEstudiante.put("TipoEps",datosEstudiante.get("tipoSalud"));
            datosEstudiante.put("NombreEps",datosEstudiante.get("nombreSaludEstudiante"));
            datosEstudiante.put("NivelEps",datosEstudiante.get("nivelSisben"));
//            JasperReport report = JasperCompileManager.compileReport("/Users/ferchs/JaspersoftWorkspace/MyReports/FichaMatricula.jrxml");
            JasperReport report =(JasperReport) JRLoader.loadObject("/Users/ferchs/NetBeansProjects/PruebaReporte/src/pruebareporte/FichaMatricula.jasper");
            JasperPrint print = JasperFillManager.fillReport(report, datosEstudiante, new JREmptyDataSource());
            JasperViewer viewer = new JasperViewer(print, false); //Se crea la vista del reportes
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Se declara con dispose_on_close para que no se cierre el programa cuando se cierre el reporte
            viewer.setVisible(true); //Se vizualiza el reporte
//        String fechaNac=campos.get("fechaNacimiento");
//        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.US);
//        Date date = format.parse(fechaNac);
//        fechaNacimiento.setDate(date);
        } catch (JRException ex) {
            Logger.getLogger(GenerarFichaMatriculaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarEstudiante(String idEstudiante){
//        try {
//        HashMap<String, String> campos=controlBuscarEstudiantePanel.obtenerDatosEstudiante(idEstudiante);
//        EditarEstudiantePanel eep= new EditarEstudiantePanel();
//        eep.llenarCampos(campos);
//        panelEstudiantes.mostarPanel(eep);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
    
    public void eliminarEstudiante(String idEstudiante,int fila){
//        boolean eliminado=controlBuscarEstudiantePanel.eliminarEstudiante(idEstudiante);
//        if(eliminado){
//            DefaultTableModel modelo=(DefaultTableModel) ultimoResultadoBusqueda.getModel();
//            modelo.removeRow(fila);
//            mostrarDatosEnTabla(modelo,ultimoResultadoBusqueda);
//        }
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(10);         
        }
        return tabla;
    }
    
    private DefaultTableModel crearModeloTabla(String [] columnas, Class[] types, Object [][] datos){

        for(int i=0;i<datos.length;i++){
            
        }
         return new javax.swing.table.DefaultTableModel(datos,columnas) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    }
    
//    protected void volver(JPanel panel){
//        panelEstudiantes.mostarPanel(panel);
//    }
    
    private ControlBuscarEstudiantePanel controlBuscarEstudiantePanel;
    private JScrollPane jScrollPane1;
    private JTable ultimoResultadoBusqueda;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraBusqueda;
    private javax.swing.JButton buscar;
    private javax.swing.JPanel panelBusqueda;
    // End of variables declaration//GEN-END:variables
}
