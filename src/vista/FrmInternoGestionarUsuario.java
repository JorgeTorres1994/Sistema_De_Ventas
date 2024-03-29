package vista;

import conexion.conexion;
import controlador.Usuario_Controller;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

public class FrmInternoGestionarUsuario extends javax.swing.JInternalFrame {

    private int idUsuario;
    //private int idCategoria = 0;
    //int obtenerIdCategoriaCombo = 0;

    public FrmInternoGestionarUsuario() {
        initComponents();
        this.setSize(1090, 490);
        this.setTitle("Gestionar Usuarios");
        this.cargarTablaUsuarios();
        //this.CargarComboCategoria();

        //INSERTAR IMAGEN CON CODIGO
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1070, 490, WIDTH));
        jlabel_wallpaper.setIcon(icono);
        this.repaint();
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
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboRol = new javax.swing.JComboBox<>();
        panelTabla = new javax.swing.JPanel();
        ScrollCategorias = new javax.swing.JScrollPane();
        tablaGestionUsuarios = new javax.swing.JTable();
        jlabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 140, 30));

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 140, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dni:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, 20));

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 160, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 100, 20));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Usuario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 100, 20));

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 160, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Contraseña:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 90, 20));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 160, 30));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Rol");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 90, 20));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 160, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Teléfono:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 90, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Teléfono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 90, 20));

        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccioe Rol:", "Administrador", "Vendedor" }));
        jPanel1.add(comboRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1050, 120));

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaGestionUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollCategorias.setViewportView(tablaGestionUsuarios);

        panelTabla.add(ScrollCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 220));

        getContentPane().add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1050, 240));
        getContentPane().add(jlabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1160, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        /*Usuario usuario = new Usuario();
        Usuario_Controller controlUsuario = new Usuario_Controller();
        String rol = "";
        rol = comboRol.getSelectedItem().toString().trim();

        // Validar campos
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDni.getText().isEmpty() || txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else {
            try {
                usuario.setNombre(txtNombre.getText().trim());
                usuario.setApellido(txtApellido.getText().trim());
                usuario.setDni(txtDni.getText().trim());
                usuario.setUsuario(txtUsuario.getText().trim());
                usuario.setContraseña(txtContraseña.getText().trim());
                usuario.setTelefono(txtTelefono.getText().trim());
                
                if (rol.equalsIgnoreCase("Administrador")) {
                    usuario.setRol("Administrador");
                } else if (rol.equalsIgnoreCase("Vendedor")) {
                    usuario.setRol("Vendedor");
                }

                if (controlUsuario.actualizar(usuario, idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                    //CargarComboCategoria();
                    cargarTablaUsuarios();
                    //this.comboIva.setSelectedItem("Seleccione Iva:");
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el registro");
                }

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error en " + e);
            }
        }*/

        Usuario usuario = new Usuario();
        Usuario_Controller controlUsuario = new Usuario_Controller();
        String rol = comboRol.getSelectedItem().toString().trim();

// Validar campos
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDni.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        } else {
            // Validar y asignar nombre
            if (!txtNombre.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                JOptionPane.showMessageDialog(null, "El campo Nombre solo puede contener letras y espacios");
                txtNombre.setBackground(Color.red);
                return;
            }
            // Validar y asignar apellido
            if (!txtApellido.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                JOptionPane.showMessageDialog(null, "El campo Apellido solo puede contener letras y espacios");
                txtApellido.setBackground(Color.red);
                return;
            }
            // Validar y asignar DNI
            if (!txtDni.getText().matches("^\\d+$")) {
                JOptionPane.showMessageDialog(null, "El campo DNI solo puede contener números");
                txtDni.setBackground(Color.red);
                return;
            }
            // Validar y asignar usuario
            if (!txtUsuario.getText().matches("^[a-zA-Z0-9]+$")) {
                JOptionPane.showMessageDialog(null, "El campo Usuario solo puede contener letras y números");
                txtUsuario.setBackground(Color.red);
                return;
            }
            // Validar y asignar contraseña
            if (txtContraseña.getText().contains(" ")) {
                JOptionPane.showMessageDialog(null, "La contraseña no puede contener espacios en blanco");
                txtContraseña.setBackground(Color.red);
                return;
            }
            // Validar y asignar teléfono
            if (!txtTelefono.getText().matches("^\\d+$")) {
                JOptionPane.showMessageDialog(null, "El campo Teléfono solo puede contener números");
                txtTelefono.setBackground(Color.red);
                return;
            }

            try {
                usuario.setNombre(txtNombre.getText().trim());
                usuario.setApellido(txtApellido.getText().trim());
                usuario.setDni(txtDni.getText().trim());
                usuario.setUsuario(txtUsuario.getText().trim());
                usuario.setContraseña(txtContraseña.getText().trim());
                usuario.setTelefono(txtTelefono.getText().trim());

                if (rol.equalsIgnoreCase("Administrador")) {
                    usuario.setRol("Administrador");
                } else if (rol.equalsIgnoreCase("Vendedor")) {
                    usuario.setRol("Vendedor");
                }

                if (controlUsuario.actualizar(usuario, idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
                    txtNombre.setBackground(Color.green);
                    txtApellido.setBackground(Color.green);
                    txtDni.setBackground(Color.green);
                    txtUsuario.setBackground(Color.green);
                    txtContraseña.setBackground(Color.green);
                    txtTelefono.setBackground(Color.green);
                    cargarTablaUsuarios();
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el registro");
                }

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error en " + e);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Usuario_Controller controlUsuario = new Usuario_Controller();
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        } else {
            if (!controlUsuario.eliminar(idUsuario)) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                this.cargarTablaUsuarios();
                //this.CargarComboCategoria();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JScrollPane ScrollCategorias;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabel_wallpaper;
    private javax.swing.JPanel panelTabla;
    public static javax.swing.JTable tablaGestionUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    //Metodo para Limpiar campos
    private void Limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtTelefono.setText("");
        comboRol.setSelectedItem("");
        //comboIva.setSelectedItem("Seleccione iva:");
        //comboCategoria.setSelectedItem("Seleccione categoria:");
    }

    //Metodo para mostrar todas las clientes registrados
    private void cargarTablaUsuarios() {
        Connection cn = conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT idUsuario, nombre, apellido, dni, usuario, contraseña, telefono, rol, estado FROM usuario ORDER BY idUsuario ASC";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            model.addColumn("#Cliente");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            model.addColumn("Dni");
            model.addColumn("Usuario");
            model.addColumn("Contraseña");
            model.addColumn("Telefono");
            model.addColumn("Rol");
            model.addColumn("Estado");

            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String telefono = rs.getString("telefono");
                String rol = rs.getString("rol");
                String estado = rs.getString("estado");

                Object[] fila = {idUsuario, nombre, apellido, dni, usuario, contraseña, telefono, rol, estado};
                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException ex) {
            System.out.println("Error al llenar la tabla usuario: " + ex);
        }

        tablaGestionUsuarios.setModel(model); // Establecer el modelo de tabla

        // Evento para obtener el campo el cual el usuario ha dado clic y obtener la interfaz que mostrará la información
        tablaGestionUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tablaGestionUsuarios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuarioSeleccionado(idUsuario);
                }
            }
        });
    }

    //METODO PARA ENVIAR DATOS SELECCIONADOS
    private void EnviarDatosUsuarioSeleccionado(int idUsuario) {
        try {
            Connection cn = conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT*FROM usuario WHERE idUsuario = '" + idUsuario + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtDni.setText(rs.getString("dni"));
                txtUsuario.setText(rs.getString("usuario"));
                txtContraseña.setText(rs.getString("contraseña"));
                txtTelefono.setText(rs.getString("telefono"));
                comboRol.setSelectedItem(rs.getString("rol"));

            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar el usuario: " + e);
        }
    }

}
