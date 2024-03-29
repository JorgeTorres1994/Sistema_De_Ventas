package Vista;

import Controlador.Controlador_RegistroDeVentas;
import Controlador.VentaPDF;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.DetalleDeVentas;
import Modelo.EncabezadoDeVenta;
import conexion.conexion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FrmInternoCobrar extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloDatoProducto;
    private Map<String, Integer> productosConStock = new HashMap<>();
    //lista para detalle de venta de medicamentos
    ArrayList<DetalleDeVentas> listProductos = new ArrayList<>();
    private DetalleDeVentas producto;

    private int idCliente = 0;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadMedicamentoBDD = 0;
    private double precioUnidad = 0.0;
    private int porcentajeIgv = 0;

    private int cantidad = 0;
    private double subTotal = 0.0;
    private double descuento = 0.0;
    private double igv = 0.0;
    private double totalPago = 0.0;

    //variables calculos
    private double subTotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double igvGeneral = 0.0;
    private double totalPagoGeneral = 0.0;
    //
    private int auxiliaridDetalle = 1;

    public FrmInternoCobrar() {
        initComponents();

        this.setSize(new Dimension(904, 600));
        this.setTitle("Facturar");

        //carga tablas 
        this.CargarClientes();
        this.CargarProductos();

        this.inicializarTablaProductos();

        jTEfectivo.setEnabled(false);
        btnCalcularCambio.setEnabled(false);

        jTSubTotal.setText("0.0");
        jTIGV.setText("0.0");
        jTDescuento.setText("0.0");
        jTTotal.setText("0.0");

        //se inserta imagen en label
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(904, 600, WIDTH));
        jL_wallpaper.setIcon(icono);
        this.repaint();
    }

    //metodo inicializar tablas
    private void inicializarTablaProductos() {
        modeloDatoProducto = new DefaultTableModel();

        modeloDatoProducto.addColumn("N°");
        modeloDatoProducto.addColumn("Nombre");
        modeloDatoProducto.addColumn("Cantidad");
        modeloDatoProducto.addColumn("P. Unidad");
        modeloDatoProducto.addColumn("Subtotal");
        modeloDatoProducto.addColumn("Descuento");
        modeloDatoProducto.addColumn("IGV");
        modeloDatoProducto.addColumn("Total");
        modeloDatoProducto.addColumn("Accion");

        this.jTable_Productos.setModel(modeloDatoProducto);
    }

    //method mostrar info en tabla
    private void MostrarTablaProductos() {
        this.modeloDatoProducto.setRowCount(listProductos.size());
        for (int i = 0; i < listProductos.size(); i++) {
            this.modeloDatoProducto.setValueAt(i + 1, i, 0);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getNombre(), i, 1);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getCantidad(), i, 2);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getPrecioUnidad(), i, 3);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getSubTotal(), i, 4);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getDescuento(), i, 5);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getIgv(), i, 6);
            this.modeloDatoProducto.setValueAt(listProductos.get(i).getTotalPago(), i, 7);
            this.modeloDatoProducto.setValueAt("Eliminar", i, 8);
        }
        //aniadir al table
        jTable_Productos.setModel(modeloDatoProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboProducto = new javax.swing.JComboBox<>();
        txtDniCliente = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTSubTotal = new javax.swing.JTextField();
        jTDescuento = new javax.swing.JTextField();
        jTIGV = new javax.swing.JTextField();
        jTTotal = new javax.swing.JTextField();
        jTEfectivo = new javax.swing.JTextField();
        jTCambio = new javax.swing.JTextField();
        btnCalcularCambio = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();
        jL_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO - FACTURACIÓN DE VENTAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("o Buscar por Dni");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Producto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cliente:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 70, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Cantidad:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 90, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_alba.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        comboCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboCliente.setForeground(new java.awt.Color(255, 255, 255));
        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 180, 30));

        comboProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboProducto.setForeground(new java.awt.Color(255, 255, 255));
        comboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Medicamento:", "Item 2", "Item 3", "Item 4" }));
        comboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductoActionPerformed(evt);
            }
        });
        getContentPane().add(comboProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 180, 30));

        txtDniCliente.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        getContentPane().add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 100, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 70, -1));

        btnBuscarCliente.setBackground(new java.awt.Color(102, 102, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscarCliente.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 120, 30));

        btnAgregarProducto.setBackground(new java.awt.Color(102, 102, 255));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-producto.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 190, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setText("Subtotal:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setText("IGV:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel8.setText("Total:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jTSubTotal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTSubTotal.setEnabled(false);
        jTSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSubTotalActionPerformed(evt);
            }
        });
        jPanel2.add(jTSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 110, -1));

        jTDescuento.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTDescuento.setEnabled(false);
        jTDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDescuentoActionPerformed(evt);
            }
        });
        jPanel2.add(jTDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, -1));

        jTIGV.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTIGV.setEnabled(false);
        jTIGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIGVActionPerformed(evt);
            }
        });
        jPanel2.add(jTIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 110, -1));

        jTTotal.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTTotal.setEnabled(false);
        jTTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTotalActionPerformed(evt);
            }
        });
        jPanel2.add(jTTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 110, -1));

        jTEfectivo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEfectivoActionPerformed(evt);
            }
        });
        jPanel2.add(jTEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 110, -1));

        jTCambio.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTCambio.setEnabled(false);
        jTCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCambioActionPerformed(evt);
            }
        });
        jPanel2.add(jTCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 110, -1));

        btnCalcularCambio.setBackground(new java.awt.Color(102, 102, 255));
        btnCalcularCambio.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnCalcularCambio.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcularCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/intercambiar.png"))); // NOI18N
        btnCalcularCambio.setText("Cambio");
        btnCalcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularCambioActionPerformed(evt);
            }
        });
        jPanel2.add(btnCalcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 140, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 380, 210));

        btnRegistrarVenta.setBackground(new java.awt.Color(102, 102, 255));
        btnRegistrarVenta.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnRegistrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja-registradora.png"))); // NOI18N
        btnRegistrarVenta.setText("Registrar venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 180, 40));
        getContentPane().add(jL_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSubTotalActionPerformed

    private void jTDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDescuentoActionPerformed

    private void jTIGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIGVActionPerformed

    private void jTTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalActionPerformed

    private void jTEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEfectivoActionPerformed

    private void jTCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCambioActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

        String clientebuscar = txtDniCliente.getText().trim();
        Connection cn = conexion.conectar();
        String sql = "select nombre, apellido from cliente where dni = '" + clientebuscar + "'";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                comboCliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                comboCliente.setSelectedItem("Seleccione Cliente:");
                JOptionPane.showMessageDialog(null, "Dni de cliente incorrecta o no encontrada");
            }
            txtDniCliente.setText("");
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e);

        }


    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        String comb = this.comboProducto.getSelectedItem().toString();
        //validacion de seleccion de producto
        if (comb.equalsIgnoreCase("Seleccione Producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un Producto");
        } else {
            //validacion ingresar cantidad
            if (!txtCantidad.getText().isEmpty()) {
                //validacion de que ingrese caracteres numericos
                boolean validacion = validar(txtCantidad.getText());
                if (validacion == true) {
                    //validacion cantidad mayor a 0
                    if (Integer.parseInt(txtCantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txtCantidad.getText());
                        //ejecutar metodo para obtencion de datos del medicamento
                        this.DatosProductos();
                        //validacion cantidad de medicamentos seleccionado no sea mayor al stock a lo almacenado
                        if (cantidad <= cantidadMedicamentoBDD) {

                            subTotal = precioUnidad * cantidad;
                            totalPago = subTotal + igv + descuento;
                            subTotal = (double) Math.round(subTotal * 100) / 100;
                            igv = (double) Math.round(igv * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPago = (double) Math.round(totalPago * 100) / 100;

                            //creacion nuevo medicamento
                            producto = new DetalleDeVentas(auxiliaridDetalle, 1, idProducto, nombre, Integer.parseInt(txtCantidad.getText()), precioUnidad, subTotal, descuento, igv, totalPago, 1);
                            //agregar a lista
                            listProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto Agregado");
                            auxiliaridDetalle++;
                            txtCantidad.setText("");
                            this.CargarProductos();
                            this.CalcularTotalaPagar();
                            jTEfectivo.setEnabled(true);
                            btnCalcularCambio.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera al stock");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero o negativo");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En el campo cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
            this.MostrarTablaProductos();
        }


    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnCalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularCambioActionPerformed
        if (!jTEfectivo.getText().isEmpty()) {
            boolean validacion = validarDouble(jTEfectivo.getText());
            if (validacion == true) {

                double efe = Double.parseDouble(jTEfectivo.getText().trim());
                double tap = Double.parseDouble(jTTotal.getText().trim());
                if (efe < tap) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente ");
                } else {
                    double cambio = (efe - tap);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    jTCambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se damiten valores no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero para calcular el cambio");

        }
    }//GEN-LAST:event_btnCalcularCambioActionPerformed

    int idArraylist = 0;
    private void jTable_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProductosMouseClicked
        int fila_punto = jTable_Productos.rowAtPoint(evt.getPoint());
        int columna_punto = 0;

        if (fila_punto > -1) {
            idArraylist = (int) modeloDatoProducto.getValueAt(fila_punto, columna_punto);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el producto?");
        //opcion confirm dialog: si=0, no=1, cancelar =2
        switch (opcion) {
            case 0:
                listProductos.remove(idArraylist - 1);
                this.CalcularTotalaPagar();
                this.MostrarTablaProductos();
                break;
            case 1:
                break;
            default: // cualquier otra opcion
                break;
        }


    }//GEN-LAST:event_jTable_ProductosMouseClicked

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed

        EncabezadoDeVenta encabezadoVenta = new EncabezadoDeVenta();
        DetalleDeVentas detalleVenta = new DetalleDeVentas();
        Controlador_RegistroDeVentas controlRegistroVentas = new Controlador_RegistroDeVentas();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!comboCliente.getSelectedItem().equals("Seleccione Cliente:")) {
            if (listProductos.size() > 0) {

                //metodo obtener idCliente
                this.ObtenerIdCliente();
                //registrar encabezado
                encabezadoVenta.setIdEncabezadoVentas(0);
                encabezadoVenta.setIdCliente(idCliente);
                encabezadoVenta.setValorPago(Double.parseDouble(jTTotal.getText()));
                encabezadoVenta.setFechaVentas(fechaActual);
                encabezadoVenta.setEstado(1);

                if (controlRegistroVentas.guardar(encabezadoVenta)) {
                    JOptionPane.showMessageDialog(null, "Venta registrada");

                    VentaPDF PDF = new VentaPDF();
                    PDF.DatosCliente(idCliente);
                    PDF.generarFactura();

                    for (DetalleDeVentas elemento : listProductos) {
                        detalleVenta.setIdDetalleVentas(0);
                        detalleVenta.setIdEncabezadoVentas(0);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecioUnidad(elemento.getPrecioUnidad());
                        detalleVenta.setSubTotal(elemento.getSubTotal());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIgv(elemento.getIgv());
                        detalleVenta.setTotalPago(elemento.getTotalPago());
                        detalleVenta.setEstado(1);

                        if (controlRegistroVentas.guardarDetalles(detalleVenta)) {
                            //System.out.println("Detalle de Venta registrado");

                            jTSubTotal.setText("0.0");
                            jTIGV.setText("0.0");
                            jTDescuento.setText("0.0");
                            jTTotal.setText("0.0");
                            jTEfectivo.setText("0.0");
                            jTCambio.setText("0.0");
                            auxiliaridDetalle = 1;

                            this.CargarClientes();
                            this.RestarStockMedicamentos(elemento.getIdProducto(), elemento.getCantidad());

                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta");
                        }
                    }

                    listProductos.clear();
                    MostrarTablaProductos();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar encabezado de ventas");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        }

    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void comboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCalcularCambio;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JLabel jL_wallpaper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCambio;
    private javax.swing.JTextField jTDescuento;
    private javax.swing.JTextField jTEfectivo;
    private javax.swing.JTextField jTIGV;
    private javax.swing.JTextField jTSubTotal;
    public static javax.swing.JTextField jTTotal;
    public static javax.swing.JTable jTable_Productos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDniCliente;
    // End of variables declaration//GEN-END:variables

    //metodo cargar clientes
    private void CargarClientes() {
        Connection cn = conexion.conectar();
        String sql = "select * from cliente";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboCliente.removeAllItems();
            comboCliente.addItem("Seleccione Cliente:");
            while (rs.next()) {
                comboCliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));

            }

        } catch (SQLException e) {
            System.out.println("Error al cargar cliente: " + e);
        }

    }

    /*private void CargarProductos() {
        Connection cn = conexion.conectar();
        String sql = "select * from producto";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboProducto.removeAllItems();
            comboProducto.addItem("Seleccione producto:");
            while (rs.next()) {
                comboProducto.addItem(rs.getString("nombre"));

            }

        } catch (SQLException e) {
            System.out.println("Error al cargar producto: " + e);
        }
    }*/

    private void CargarProductos() {
        Connection cn = conexion.conectar();
        String sql = "select * from producto";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboProducto.removeAllItems();
            comboProducto.addItem("Seleccione producto:");

            while (rs.next()) {
                String nombreProducto = rs.getString("nombre");
                int stockProducto = rs.getInt("stock");

                comboProducto.addItem(nombreProducto);
                productosConStock.put(nombreProducto, stockProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar producto: " + e);
        }
    }

    //metodo para validacion de ingreso de caracteres no numericos
    private boolean validar(String valor) {
        try {
            int numero = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarDouble(String valor) {
        try {
            double numero = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //mostrar datos del medicamento
    private void DatosProductos() {
        try {
            String sql = "select * from producto where nombre = '" + this.comboProducto.getSelectedItem() + "'";
            Connection cn = conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadMedicamentoBDD = rs.getInt("stock");
                precioUnidad = rs.getDouble("precio");
                porcentajeIgv = rs.getInt("iva");
                this.CalcularIgv(precioUnidad, porcentajeIgv);

            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto: " + e);
        }
    }

    //metodo calcular IGV
    private double CalcularIgv(double precio, int porcentajeIgv) {
        int porcentIGV = porcentajeIgv;
        switch (porcentIGV) {
            case 0:
                igv = 0.0;
                break;
            case 18:
                igv = (precio * cantidad) * 0.18;
                break;
            default:
                break;
        }
        return igv;
    }

    //calculo del total de la lista de medicamentos
    private void CalcularTotalaPagar() {
        subTotalGeneral = 0;
        descuentoGeneral = 0;
        totalPagoGeneral = 0;

        for (DetalleDeVentas elemento : listProductos) {
            subTotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            igvGeneral += elemento.getIgv();
            totalPagoGeneral += elemento.getTotalPago();
        }

        subTotalGeneral = (double) Math.round(subTotalGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        igvGeneral = (double) Math.round(igvGeneral * 100) / 100;
        totalPagoGeneral = (double) Math.round(totalPagoGeneral * 100) / 100;

        //datos a la list
        jTSubTotal.setText(String.valueOf(subTotalGeneral));
        jTIGV.setText(String.valueOf(igvGeneral));
        jTDescuento.setText(String.valueOf(descuentoGeneral));
        jTTotal.setText(String.valueOf(totalPagoGeneral));

    }

    public void ObtenerIdCliente() {
        try {
            String sql = "select * from cliente where concat(nombre,' ', apellido) = '" + this.comboCliente.getSelectedItem() + "'";
            Connection cn = conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el idCliente: " + e);
        }
    }

    //methodo para restar cantidad
    private void RestarStockMedicamentos(int idProducto, int cantidad) {
        int cantidadMedicamentosBD = 0;
        try {
            Connection cn = conexion.conectar();
            String sql = "select idProducto, stock from producto where idProducto ='" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadMedicamentosBD = rs.getInt("stock");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar stock: " + e);
        }
        try {
            Connection cd = conexion.conectar();
            PreparedStatement consult = cd.prepareStatement("update producto set stock=? where idProducto = '" + idProducto + "'");
            int cantidadNueva = cantidadMedicamentosBD - cantidad;
            consult.setInt(1, cantidadNueva);
            if (consult.executeUpdate() > 0) {
//                System.out.println("Todo esta correcto");
            }
            cd.close();

        } catch (SQLException e) {
            System.out.println("Error al restar el stock :" + e);
        }
    }
}
