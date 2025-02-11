package vista;

import controlador.Config_Usuario_Controller;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Formulario de Usuario - Sistema de Ventas");
        this.setSize(new Dimension(700, 500));
    }

    /*@Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/ventas.png"));
        return retValue;
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        loginPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        comboRol = new javax.swing.JComboBox<>();
        lblMostrarContraseña = new javax.swing.JLabel();
        lblRecuperar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel1.setBackground(new java.awt.Color(102, 102, 255));
        loginPanel1.setPreferredSize(new java.awt.Dimension(350, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Ventas Profesional");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_alba.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(1080, 487));
        jLabel2.setMinimumSize(new java.awt.Dimension(1080, 487));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("®Jorge Anthony Torres Pastor");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Realizado con las tecnologías");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mysql.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/java.png"))); // NOI18N

        javax.swing.GroupLayout loginPanel1Layout = new javax.swing.GroupLayout(loginPanel1);
        loginPanel1.setLayout(loginPanel1Layout);
        loginPanel1Layout.setHorizontalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(95, 95, 95))
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanel1Layout.setVerticalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(30, 30, 30))
        );

        getContentPane().add(loginPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 500));

        loginPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contraseña:");

        btnIngresar.setBackground(new java.awt.Color(51, 153, 255));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Rol:");

        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));

        lblMostrarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/oculto.png"))); // NOI18N
        lblMostrarContraseña.setText("jLabel11");
        lblMostrarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMostrarContraseñaMouseClicked(evt);
            }
        });

        lblRecuperar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        lblRecuperar.setText("¿Deseas recuperar tu contraseña?");
        lblRecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecuperarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginPanel2Layout = new javax.swing.GroupLayout(loginPanel2);
        loginPanel2.setLayout(loginPanel2Layout);
        loginPanel2Layout.setHorizontalGroup(
            loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(loginPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(loginPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRecuperar)
                    .addGroup(loginPanel2Layout.createSequentialGroup()
                        .addGroup(loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(36, 36, 36)
                        .addGroup(loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboRol, javax.swing.GroupLayout.Alignment.LEADING, 0, 175, Short.MAX_VALUE)
                            .addComponent(txtUsuario))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMostrarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanel2Layout.setVerticalGroup(
            loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(56, 56, 56)
                .addGroup(loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMostrarContraseña))
                .addGap(18, 18, 18)
                .addGroup(loginPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblRecuperar)
                .addGap(31, 31, 31)
                .addComponent(btnIngresar)
                .addGap(43, 43, 43))
        );

        getContentPane().add(loginPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 350, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        this.Login();

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtContraseña.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.Login();
        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void lblMostrarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMostrarContraseñaMouseClicked
        if (txtContraseña != null) {
            if (txtContraseña.getEchoChar() == 0) { // Verifica si se muestra la contraseña actualmente
                txtContraseña.setEchoChar('\u2022'); // Oculta la contraseña
                lblMostrarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/oculto.png"))); // Cambia al ícono de "mostrar contraseña"
            } else {
                txtContraseña.setEchoChar((char) 0); // Muestra la contraseña
                lblMostrarContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojo.png"))); // Cambia al ícono de "ocultar contraseña"
            }
        }
    }//GEN-LAST:event_lblMostrarContraseñaMouseClicked

    private void lblRecuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecuperarMouseClicked
        FrmRecuperarContraseña formRecuperar = new FrmRecuperarContraseña();
        formRecuperar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRecuperarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> comboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblMostrarContraseña;
    private javax.swing.JLabel lblRecuperar;
    private javax.swing.JPanel loginPanel1;
    private javax.swing.JPanel loginPanel2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void Login() {
        String usuario = txtUsuario.getText().trim();
        String contraseña = txtContraseña.getText().trim();
        String rolSeleccionado = comboRol.getSelectedItem().toString();

        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        } else {
            Config_Usuario_Controller controlUsuario = new Config_Usuario_Controller();
            Usuario usuarioValidado = controlUsuario.validarUsuario(usuario, contraseña);

            if (usuarioValidado != null) {
                String rolUsuario = usuarioValidado.getRol();

                if (rolUsuario.equals(rolSeleccionado)) {
                    abrirMenuPrincipal(usuarioValidado);
                } else {
                    JOptionPane.showMessageDialog(null, "Rol incorrecto para el usuario.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
        }
    }

    private void abrirMenuPrincipal(Usuario usuario) {
        FrmMenuPrincipal menuPrincipal = new FrmMenuPrincipal(usuario);
        menuPrincipal.setVisible(true);
        this.dispose();
    }


    /*private void Login() {
        if (!txtUsuario.getText().isEmpty() && !txtContraseña.getText().isEmpty()) {
            Config_Usuario_Controller controlUsuario = new Config_Usuario_Controller();
            Usuario usuario = new Usuario();
            usuario.setUsuario(txtUsuario.getText().trim());
            usuario.setContraseña(txtContraseña.getText().trim());

            String rolSeleccionado = comboRol.getSelectedItem().toString(); // Obtener el rol seleccionado
            String rolUsuario = controlUsuario.obtenerRol(usuario);

            if (rolUsuario.equals(rolSeleccionado)) {
                if (rolSeleccionado.equals("administrador")) {
                    // Acciones específicas para el rol de administrador
                    // Ejemplo: abrir una ventana para el administrador
                    FrmMenuPrincipal principalAdmin = new FrmMenuPrincipal(usuario);
                    principalAdmin.setVisible(true);
                    this.dispose();
                } else if (rolSeleccionado.equals("vendedor")) {
                    // Acciones específicas para el rol de vendedor
                    // Ejemplo: abrir una ventana para el vendedor
                    FrmMenuPrincipal principalVendedor = new FrmMenuPrincipal(usuario);
                    principalVendedor.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Rol incorrecto para el usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rol incorrecto para el usuario");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese usuario y contraseña.");
        }
    }*/
}
