package vista;

import controlador.CajaRegistradoraController;
import controlador.Config_Usuario_Controller;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.CajaRegistradora;
import modelo.Usuario;

public class FrmInternoAbrirCaja extends javax.swing.JInternalFrame {

    private String rolUsuario;
    private String nombreUsuario;
    
    public FrmInternoAbrirCaja(Usuario usuario) {
        initComponents();
        this.setSize(new Dimension(340, 425));
        this.setTitle("Abrir Caja");

        Config_Usuario_Controller control_config_usuarios = new Config_Usuario_Controller();
        rolUsuario = control_config_usuarios.obtenerRol(usuario);
        nombreUsuario = control_config_usuarios.obtenerNombreApellidoUsuario(usuario);
        lblUsuarioLogueado.setText("sadsadsa");
        
        if ("Administrador".equals(rolUsuario)) {
            lblUsuarioLogueado.setText(nombreUsuario);
        } else {
            lblUsuarioLogueado.setText(nombreUsuario);
        }
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMontoInicio = new javax.swing.JTextField();
        lblUsuarioLogueado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAbrirCaja = new javax.swing.JButton();
        lblFechaApertura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CAJA REGISTRADORA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha Apertura:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
        getContentPane().add(txtMontoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        lblUsuarioLogueado.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioLogueado.setText("nombre");
        getContentPane().add(lblUsuarioLogueado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, 20));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Monto Apertura:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Trabajador:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnAbrirCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnAbrirCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja-registradora.png"))); // NOI18N
        btnAbrirCaja.setText("Abrir Caja");
        btnAbrirCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrirCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        lblFechaApertura.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaApertura.setText("lblFechaApertura");
        getContentPane().add(lblFechaApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 340, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCajaActionPerformed
        // Crear una instancia del controlador de la caja registradora
        CajaRegistradoraController controladorCaja = new CajaRegistradoraController();

        // Obtener los datos del formulario
        double montoApertura = Double.parseDouble(txtMontoInicio.getText());
        String responsableApertura = lblUsuarioLogueado.getText();
        String fechaApertura = obtenerFechaActual(); // Método para obtener la fecha actual, debes implementarlo
        lblFechaApertura.setText(fechaApertura);  
        System.out.println("cambio");
        
        // Crear una instancia del modelo de caja registradora con los datos obtenidos
        CajaRegistradora caja = new CajaRegistradora(montoApertura, responsableApertura, fechaApertura);

        // Llamar al método del controlador para abrir la caja con los datos proporcionados
        if (controladorCaja.abrirCaja(caja)) {
            JOptionPane.showMessageDialog(null, "Caja abierta correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al abrir la caja");
        }
    }//GEN-LAST:event_btnAbrirCajaActionPerformed

    private String obtenerFechaActual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaActual = new Date();
        return formato.format(fechaActual);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblFechaApertura;
    private javax.swing.JLabel lblUsuarioLogueado;
    private javax.swing.JTextField txtMontoInicio;
    // End of variables declaration//GEN-END:variables
}
