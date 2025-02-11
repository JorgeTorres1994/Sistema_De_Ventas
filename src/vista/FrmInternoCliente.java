package vista;

import controlador.Cliente_Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JOptionPane;
import modelo.Cliente;

public class FrmInternoCliente extends javax.swing.JInternalFrame {

    public FrmInternoCliente() {
        initComponents();
        this.setSize(new Dimension(450, 450));
        this.setTitle("Registrar Nuevo Cliente");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtGuardar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dni:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teléfono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellidos:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombres:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        getContentPane().add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 160, -1));
        getContentPane().add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 160, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 160, -1));

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 160, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 160, -1));

        txtGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar.png"))); // NOI18N
        txtGuardar.setText("Guardar");
        txtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(txtGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 130, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 440, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarActionPerformed
        /*Cliente cliente = new Cliente();
        Cliente_Controller controladorCliente = new Cliente_Controller();

        //Validar campos
        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            txtNombres.setBackground(Color.red);
            txtApellidos.setBackground(Color.red);
            txtDni.setBackground(Color.red);
            txtTelefono.setBackground(Color.red);
            txtDireccion.setBackground(Color.red);
        } else {
            if (!controladorCliente.existeCliente(txtDni.getText().trim())) {
                cliente.setNombre(txtNombres.getText().trim());
                cliente.setApellido(txtApellidos.getText().trim());
                cliente.setDni(txtDni.getText().trim());
                cliente.setTelefono(txtTelefono.getText().trim());
                cliente.setDireccion(txtDireccion.getText().trim());
                cliente.setEstado(1);

                if (controladorCliente.guardar(cliente)) {
                    JOptionPane.showMessageDialog(null, "Se registraron los datos correctamente");
                    txtNombres.setBackground(Color.green);
                    txtApellidos.setBackground(Color.green);
                    txtDni.setBackground(Color.green);
                    txtTelefono.setBackground(Color.green);
                    txtDireccion.setBackground(Color.green);
                } else {
                    JOptionPane.showMessageDialog(null, "!Error al guardar los datos!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El cliente ya existe, registra un cliente diferente");
            }
        }*/

        Cliente cliente = new Cliente();
        Cliente_Controller controladorCliente = new Cliente_Controller();
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String dni = txtDni.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();

// Validar campos
        if (nombres.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
            ColorRojoRegistroFallido();
        } else {
            if (!nombres.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras, espacios y los caracteres '-");
                txtNombres.setBackground(Color.red);
                return;
            }
            if (!apellidos.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\\\s'-]+$")) {
                JOptionPane.showMessageDialog(null, "El apellido solo puede contener letras, espacios y los caracteres '-");
                txtApellidos.setBackground(Color.red);
                return;
            }
            if (!dni.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "El DNI solo puede contener números");
                txtDni.setBackground(Color.red);
                return;
            }
            if (!telefono.matches("[\\d\\s]+")) {
                JOptionPane.showMessageDialog(null, "El teléfono solo puede contener números y espacios");
                txtTelefono.setBackground(Color.red);
                return;
            }
            if (!direccion.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$")) {
                JOptionPane.showMessageDialog(null, "La dirección solo puede contener letras, números y espacios");
                txtDireccion.setBackground(Color.red);
                return;
            }
            //ColorRojoRegistroFallido();

            if (!controladorCliente.existeCliente(dni)) {
                try {
                    cliente.setNombre(nombres);
                    cliente.setApellido(apellidos);
                    cliente.setDni(dni);
                    cliente.setTelefono(telefono);
                    cliente.setDireccion(direccion);
                    cliente.setEstado(1);

                    if (controladorCliente.guardar(cliente)) {
                        JOptionPane.showMessageDialog(null, "Se registraron los datos correctamente");
                        ColorVerdeRegistroExitoso();
                        Limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "!Error al guardar los datos!");
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error en " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El cliente ya existe, registra un cliente diferente");
            }
        }

    }//GEN-LAST:event_txtGuardarActionPerformed

    private void ColorRojoRegistroFallido() {
        txtNombres.setBackground(Color.red);
        txtApellidos.setBackground(Color.red);
        txtDni.setBackground(Color.red);
        txtTelefono.setBackground(Color.red);
        txtDireccion.setBackground(Color.red);
    }

    private void ColorVerdeRegistroExitoso() {
        txtNombres.setBackground(Color.green);
        txtApellidos.setBackground(Color.green);
        txtDni.setBackground(Color.green);
        txtTelefono.setBackground(Color.green);
        txtDireccion.setBackground(Color.green);
    }

    private void Limpiar() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JButton txtGuardar;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
