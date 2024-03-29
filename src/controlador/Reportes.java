package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Reportes {

    //metodo reportes de clientes
    public void ReportesClientes() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            Image header = Image.getInstance("src/img/head.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("Dni");
            tabla.addCell("Celular");
            tabla.addCell("Direccion");

            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select idCliente, concat(nombre, ' ', apellido) as nombre, cedula, telefono, direccion from tb_cliente");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    //metodo reportes de medicamentes
    public void ReportesMedicamentos() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Productos.pdf"));
            Image header = Image.getInstance("src/imagenes/LOGO_DEL_ALBA.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Medicamentos \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 5, 4, 5, 7, 5, 6};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Cant.");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            tabla.addCell("Por. Igv");
            tabla.addCell("Categoria");

            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select p.idMedicamento, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIgv, c.descripcion as categoria, p.estado from tb_medicamento as p, tb_categoria as c where p.idCategoria = c.idCategoria;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException e) {
            System.out.println("Error 2 en: " + e);
        } catch (IOException e) {
            System.out.println("Error 3 en: " + e);
        }
    }

    // metodo crear reporte de categorias
    public void ReportesCategorias() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Categorias.pdf"));
            Image header = Image.getInstance("src/imagenes/LOGO_DEL_ALBA.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Descripcion");
            tabla.addCell("Estado");

            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from tb_categoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    //metodo reporte de ventas
    public void ReportesVentas() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas.pdf"));
            Image header = Image.getInstance("src/imagenes/LOGO_DEL_ALBA.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 9, 4, 5, 3, 4, 4};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("ID");
            tabla.addCell("Cliente");
            tabla.addCell("Producto");
            tabla.addCell("Fecha Venta");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Total");

            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("SELECT v.id, CONCAT(c.nombre, ' ', c.apellido) AS cliente, p.nombre AS producto, v.fecha_venta, v.cantidad, v.precio_unitario, v.total FROM ventas AS v INNER JOIN cliente AS c ON v.cliente_id = c.idCliente INNER JOIN producto AS p ON v.producto_id = p.idProducto;");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5));
                    tabla.addCell(rs.getString(6));
                    tabla.addCell(rs.getString(7));
                }
                documento.add(tabla);

            } catch (SQLException e) {
                System.out.println("Error en SQL: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error en Documento: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error de IO: " + ex);
        }
    }

    public void generarBoletajeVenta(int idVenta) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Boletaje_Venta_" + idVenta + ".pdf"));
            Image header = Image.getInstance("src/imagenes/LOGO_DEL_ALBA.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Boletaje de Venta \n\n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("Descripción");
            tabla.addCell("Valor");

            try {
                Connection cn = conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("SELECT p.nombre, v.total, v.fecha_venta, c.nombre, c.apellido FROM ventas AS v INNER JOIN producto AS p ON v.producto_id = p.idProducto INNER JOIN cliente AS c ON v.cliente_id = c.idCliente WHERE v.id = ?;");
                pst.setInt(1, idVenta);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    tabla.addCell("Producto: " + rs.getString(1));
                    tabla.addCell("Total: $" + rs.getString(2));
                    tabla.addCell("Fecha Venta: " + rs.getString(3));
                    tabla.addCell("Cliente: " + rs.getString(4) + " " + rs.getString(5));
                }

                documento.add(tabla);

            } catch (SQLException e) {
                System.out.println("Error en SQL: " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Boletaje de venta creado");

        } catch (DocumentException e) {
            System.out.println("Error en Documento: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error de IO: " + ex);
        }
    }

}
