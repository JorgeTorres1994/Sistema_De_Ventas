package Vista;

import Controlador.Controlador_RegistroDeVentas;
import Modelo.EncabezadoDeVenta;
import com.itextpdf.text.BaseColor;
import conexion.conexion;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InterGestionVentas extends javax.swing.JInternalFrame {

    private int idCliente = 0;
    private int idVenta;
    private String fechaSeleccionada;

    public InterGestionVentas() {
        initComponents();
        this.setSize(new Dimension(810, 614));
        this.setTitle("Gestion Ventas");

        this.CargarTablaVentas(fechaSeleccionada);
        this.CargarClientes();

        //insertar imagen en el label
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(810, 614, WIDTH));
        jL_wallpaper.setIcon(icono);
        comboCliente.setEnabled(false);
        comboEstado.setEnabled(false);
        this.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jT_total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jT_fecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fechaVenta = new com.toedter.calendar.JDateChooser();
        jL_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 730, 250));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReporte.setBackground(new java.awt.Color(102, 102, 255));
        btnReporte.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 0, 0));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel4.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 180, 70));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jT_total.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jT_total.setEnabled(false);
        jPanel3.add(jT_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Estado:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jT_fecha.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jT_fecha.setEnabled(false);
        jPanel3.add(jT_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cliente:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 80, -1));

        comboCliente.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 210, 20));

        comboEstado.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel3.add(comboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 180, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 730, 100));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha a buscar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        fechaVenta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaVentaPropertyChange(evt);
            }
        });
        getContentPane().add(fechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 180, -1));
        getContentPane().add(jL_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 6, 810, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaVentaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaVentaPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            // Obtiene la fecha seleccionada en el date_chooser
            Date selectedDate = fechaVenta.getDate();

            // Convierte la fecha seleccionada a un formato adecuado, por ejemplo, a String
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fechaSeleccionada = dateFormat.format(selectedDate);

            // Llama al método CargarTablaVentas con la fecha seleccionada como parámetro
            CargarTablaVentas(fechaSeleccionada);
        }
    }//GEN-LAST:event_fechaVentaPropertyChange

    private void generarReportePDF() {
        try {
            Document document = new Document();
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = sdf.format(new Date());
            String pdfFileName = "reporte_ventas_" + timestamp + ".pdf";
            String pdfFilePath = desktopPath + File.separator + pdfFileName;
            PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
            document.open();

            // Agregar una imagen al informe (ajusta la ruta a tu imagen)
            Image img = Image.getInstance("src/imagenes/fondo_del_alba_2.jpg"); // Cambia la ruta de la imagen
            img.setAlignment(Element.ALIGN_CENTER);
            img.scaleToFit(200, 200); // Ajusta el tamaño de la imagen
            document.add(img);

            // Título del informe
            Paragraph title = new Paragraph("Informe de Ventas", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Espacio en blanco
            document.add(new Paragraph("\n"));

            // Crear una tabla para mostrar los datos
            PdfPTable table = new PdfPTable(tablaVentas.getColumnCount());
            table.setWidthPercentage(100); // Ancho de la tabla al 100% de la página

            // Configurar colores de fondo para las celdas de encabezado
            BaseColor headerBackgroundColor = new BaseColor(173, 216, 230); // Color LightBlue
            PdfPCell headerCell = new PdfPCell();

            for (int i = 0; i < tablaVentas.getColumnCount(); i++) {
                String columnName = tablaVentas.getColumnName(i);

                // Configurar celda de encabezado
                headerCell = new PdfPCell(new Phrase(columnName, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.BOLD, BaseColor.WHITE)));
                headerCell.setBackgroundColor(headerBackgroundColor);
                table.addCell(headerCell);
            }

            // Obtener datos de la tabla y agregarlos a la tabla PDF con colores alternados
            boolean alternateColor = false;

            for (int fila = 0; fila < tablaVentas.getRowCount(); fila++) {
                for (int columna = 0; columna < tablaVentas.getColumnCount(); columna++) {
                    String valor = tablaVentas.getValueAt(fila, columna).toString();

                    // Configurar color de fondo para las celdas de datos (alternar colores)
                    BaseColor dataBackgroundColor = alternateColor ? new BaseColor(240, 248, 255) : BaseColor.WHITE;
                    PdfPCell dataCell = new PdfPCell(new Phrase(valor, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12)));
                    dataCell.setBackgroundColor(dataBackgroundColor);
                    table.addCell(dataCell);
                }

                // Alternar colores
                alternateColor = !alternateColor;
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(this, "Informe PDF generado con éxito en el escritorio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Abrir el archivo PDF generado automáticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(pdfFilePath));
            }
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error al generar el informe PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        generarReportePDF();
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboEstado;
    private com.toedter.calendar.JDateChooser fechaVenta;
    private javax.swing.JLabel jL_wallpaper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_fecha;
    private javax.swing.JTextField jT_total;
    public static javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables

    //limpiar entradas
    public void Limpiar() {
        jT_total.setText("");
        jT_fecha.setText("");
        comboCliente.setSelectedItem("Seleccione Cliente:");
        comboEstado.setSelectedItem("Activo");
        idCliente = 0;

    }

    /*private void CargarTablaVentas() {
        Connection con = conexion.conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "select ev.idEncabezadoVentas as id, concat(c.nombre, ' ', c.apellido) as cliente, ev.valorPago as total, ev.fechaVentas as fecha, ev.estado from encabezado_ventas as ev, cliente as c where ev.idCliente = c.idCliente;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionVentas.jT_Ventas = new JTable(modelo);
            InterGestionVentas.jScrollPane1.setViewportView(InterGestionVentas.jT_Ventas);

            modelo.addColumn("N°");
            modelo.addColumn("Cliente");
            modelo.addColumn("Total");
            modelo.addColumn("Fecha Venta");
            modelo.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                modelo.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e);
        }
        //evento para obtencion de campo el cual el usuario da click y obtener la interfaz que muestre la info general

        jT_Ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jT_Ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVenta = (int) modelo.getValueAt(fila_point, columna_point);
                    EnviarDatosVentasSeleccionada(idVenta);//met
                }

            }

        });

    }*/
    private void CargarTablaVentas(String fechaSeleccionada) {
        Connection con = conexion.conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT ev.idEncabezadoVentas AS id, CONCAT(c.nombre, ' ', c.apellido) AS cliente, ev.valorPago AS total, ev.fechaVentas AS fecha, ev.estado FROM encabezado_ventas AS ev, cliente AS c WHERE ev.idCliente = c.idCliente AND ev.fechaVentas = ?";
        PreparedStatement pst;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, fechaSeleccionada);
            ResultSet rs = pst.executeQuery();
            tablaVentas.setModel(modelo);

            modelo.addColumn("N°");
            modelo.addColumn("Cliente");
            modelo.addColumn("Total");
            modelo.addColumn("Fecha Venta");
            modelo.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                modelo.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e);
        }

        // Evento para obtener el valor de la fila seleccionada
        tablaVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tablaVentas.rowAtPoint(e.getPoint());

                if (fila_point > -1) {
                    idVenta = (int) tablaVentas.getValueAt(fila_point, 0);
                    EnviarDatosVentasSeleccionada(idVenta);
                }
            }
        });
    }

    //metodo que envia datos seleccionados
    /*private void EnviarDatosVentasSeleccionada(int idVenta) {
        try {
            Connection con = conexion.conectar();
            PreparedStatement pat = con.prepareStatement("select ev.idEncabezadoVentas, ev.idCliente,  concat(c.nombre, ' ', c.apellido) as cliente, ev.valorPago, ev.fechaVentas, ev.estado from encabezado_ventas as ev, cliente as c  where ev.idEncabezadoVentas = '" + idVenta + "' and ev.idCliente = c.idCliente;");
            ResultSet rs = pat.executeQuery();

            if (rs.next()) {
                jC_Cliente.setSelectedItem(rs.getString("cliente"));
                jT_total.setText(rs.getString("valorPago"));
                jT_fecha.setText(rs.getString("fechaVentas"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    jC_Estado.setSelectedItem("Activo");
                } else {
                    jC_Estado.setSelectedItem("Inactivo");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta:" + e);
        }
    }*/
    // Método EnviarDatosVentasSeleccionada
    // Método EnviarDatosVentasSeleccionada
    private void EnviarDatosVentasSeleccionada(int idVenta) {
        try {
            Connection con = conexion.conectar();
            PreparedStatement pat = con.prepareStatement("select ev.idEncabezadoVentas, ev.idCliente,  concat(c.nombre, ' ', c.apellido) as cliente, ev.valorPago, ev.fechaVentas, ev.estado from encabezado_ventas as ev, cliente as c  where ev.idEncabezadoVentas = '" + idVenta + "' and ev.idCliente = c.idCliente;");
            ResultSet rs = pat.executeQuery();

            if (rs.next()) {
                comboCliente.setSelectedItem(rs.getString("cliente"));
                jT_total.setText(rs.getString("valorPago"));
                jT_fecha.setText(rs.getString("fechaVentas"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    comboEstado.setSelectedItem("Activo");
                } else {
                    comboEstado.setSelectedItem("Inactivo");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta:" + e);
        }
    }

    //metodo cargar clientes
    private void CargarClientes() {
        Connection cn = conexion.conectar();
        String sql = "select * from cliente";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboCliente.removeAllItems();
            comboCliente.addItem("Nombre Cliente:");
            while (rs.next()) {
                comboCliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));

            }

        } catch (SQLException e) {
            System.out.println("Error al cargar cliente: " + e);
        }

    }

}
