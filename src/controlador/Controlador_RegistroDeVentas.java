package Controlador;

import Modelo.DetalleDeVentas;
import Modelo.EncabezadoDeVenta;
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Controlador_RegistroDeVentas {

    //para encabezado de venta
    public static int idEncabezadoRegistrado;
    java.math.BigDecimal idColVar;

    //guardar encabezado de venta
    public boolean guardar(EncabezadoDeVenta objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {

            PreparedStatement consult = cn.prepareStatement("insert into encabezado_ventas values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            consult.setInt(1, 0);
            consult.setInt(2, objeto.getIdCliente());
            consult.setDouble(3, objeto.getValorPago());
            consult.setString(4, objeto.getFechaVentas());
            consult.setInt(5, objeto.getEstado());

            if (consult.executeUpdate() > 0) {
                respuesta = true;
            }

            ResultSet rs = consult.getGeneratedKeys();
            while (rs.next()) {
                idColVar = rs.getBigDecimal(1);
                idEncabezadoRegistrado = idColVar.intValue();
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar encabezado: " + e);
        }
        return respuesta;
    }

    //guardar detalle de ventas
    public boolean guardarDetalles(DetalleDeVentas det) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {

            PreparedStatement consult = cn.prepareStatement("insert into detalle_ventas values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            consult.setInt(1, 0);
            consult.setInt(2, idEncabezadoRegistrado);
            consult.setInt(3, det.getIdProducto());
            consult.setInt(4, det.getCantidad());
            consult.setDouble(5, det.getPrecioUnidad());
            consult.setDouble(6, det.getSubTotal());
            consult.setDouble(7, det.getDescuento());
            consult.setDouble(8, det.getIgv());
            consult.setDouble(9, det.getTotalPago());
            consult.setInt(10, det.getEstado());

            if (consult.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de ventas: " + e);
        }
        return respuesta;
    }
    
    public boolean actualizar(EncabezadoDeVenta venta, int idEncabezadoVenta) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {

            PreparedStatement consult = cn.prepareStatement("update encabezado_ventas set idCliente = ?, estado = ? where idEncabezadoVentas ='" + idEncabezadoVenta + "'");
            consult.setInt(1, venta.getIdCliente());
            consult.setInt(2, venta.getEstado());

            if (consult.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar encabezado de venta: " + e);
        }
        return respuesta;
    }

}
