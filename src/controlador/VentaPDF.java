package Controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import Vista.FrmInternoCobrar;
import conexion.conexion;

public class VentaPDF {

    private String nombreCliente;
    private String dniCliente;
    private String telefonoCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDFV = "";

    public void DatosCliente(int idCliente) {
        Connection cn = conexion.conectar();
        String sql = "select * from cliente where idCliente = '" + idCliente + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                dniCliente = rs.getString("dni");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);

        }
    }

    //metodo generar factura venta
    public void generarFactura() {
        try {
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }
            nombreArchivoPDFV = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            // Ruta para guardar en el escritorio del usuario
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
            String ubicacionDeGuardado = desktopPath + File.separator + nombreArchivoPDFV;

            FileOutputStream archivo;
            //File file = new File("src/PDF/" + nombreArchivoPDFV);
            File file = new File(ubicacionDeGuardado);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image IMG = Image.getInstance("src/imagenes/logo_alba.jpg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GREEN);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar borde de la tabla
            //tamaño de celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(IMG);

            //String ruc = "1254022689151";
            String nombre = "DEL ALBA";
            String telefono = "918464124";
            String direccion = "Los naranjos";
            String razon = "Agua de mesa fresca y pura";

            Encabezado.addCell("");
            //Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell("NOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);//nueva linea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            //tamaño de  celdas
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);

            // Color de fondo azul para las celdas de "Dni/RUC", "Nombre", "Telefono" y "Direccion"
            BaseColor blueBackground = new BaseColor(0, 0, 255); // Color azul
            PdfPCell blueCell = new PdfPCell();
            blueCell.setBackgroundColor(blueBackground);

            PdfPCell cliente1 = new PdfPCell(new Phrase("Dni/RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: ", negrita));
            //sin bordes 
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            // Asignar color de fondo azul a las celdas
            cliente1.setBackgroundColor(blueBackground);
            cliente2.setBackgroundColor(blueBackground);
            cliente3.setBackgroundColor(blueBackground);
            cliente4.setBackgroundColor(blueBackground);

            //add celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(dniCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);
            //agregar al documento
            doc.add(tablaCliente);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS medicamentos
            PdfPTable tablaMedicamento = new PdfPTable(4);
            tablaMedicamento.setWidthPercentage(100);
            tablaMedicamento.getDefaultCell().setBorder(0);
            //tamaño celdas
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaMedicamento.setWidths(ColumnaProducto);
            tablaMedicamento.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell medicamento1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell medicamento2 = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell medicamento3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell medicamento4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
            //quitar bordes
            medicamento1.setBorder(0);
            medicamento2.setBorder(0);
            medicamento3.setBorder(0);
            medicamento4.setBorder(0);
            //agregar color al encabezado del medicamento
            medicamento1.setBackgroundColor(blueBackground);
            medicamento2.setBackgroundColor(blueBackground);
            medicamento3.setBackgroundColor(blueBackground);
            medicamento4.setBackgroundColor(blueBackground);
            //add celda a la tabla
            tablaMedicamento.addCell(medicamento1);
            tablaMedicamento.addCell(medicamento2);
            tablaMedicamento.addCell(medicamento3);
            tablaMedicamento.addCell(medicamento4);

            for (int i = 0; i < FrmInternoCobrar.jTable_Productos.getRowCount(); i++) {
                String medicamento = FrmInternoCobrar.jTable_Productos.getValueAt(i, 1).toString();
                String cantidad = FrmInternoCobrar.jTable_Productos.getValueAt(i, 2).toString();
                String precio = FrmInternoCobrar.jTable_Productos.getValueAt(i, 3).toString();
                String total = FrmInternoCobrar.jTable_Productos.getValueAt(i, 7).toString();

                tablaMedicamento.addCell(cantidad);
                tablaMedicamento.addCell(medicamento);
                tablaMedicamento.addCell(precio);
                tablaMedicamento.addCell(total);
            }

            //agregar al documento
            doc.add(tablaMedicamento);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + FrmInternoCobrar.jTTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por su compra");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //cerrar  documento y  archivo
            doc.close();
            archivo.close();

            //abrir  documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);

        }
    }
}
