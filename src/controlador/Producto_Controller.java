package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class Producto_Controller {

    int r;

    public boolean guardar(Producto producto) { //METODO PARA REGISTRAR PRODUCTO
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO producto VALUES (?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, producto.getNombre());
            consulta.setInt(3, producto.getStock());
            consulta.setDouble(4, producto.getPrecio());
            consulta.setString(5, producto.getDescripcion());
            consulta.setInt(6, producto.getIva());
            consulta.setBytes(7, producto.getImagen());
            consulta.setInt(8, producto.getEstado());
            consulta.setInt(9, producto.getIdCategoria());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e);
        }

        return respuesta;
    }

    public boolean existeProducto(String producto) { //METODO PARA MOSTRAR QUE EXISTE LA PRODUCTO
        boolean respuesta = false;
        String sql = "SELECT nombre FROM producto WHERE nombre = '" + producto + "'";
        Statement st;
        try {
            Connection cn = conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el producto: " + e);
        }

        return respuesta;
    }

    public Producto obtenerProducto(int idProducto) {
        Producto producto = null;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            consulta.setInt(1, idProducto);
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setIva(rs.getInt("iva"));
                producto.setImagen(rs.getBytes("imagen"));
                producto.setEstado(rs.getInt("estado"));
                producto.setIdCategoria(rs.getInt("idCategoria"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e);
        }
        return producto;
    }

    public boolean actualizar(Producto producto, int idProducto) { //METODO PARA ACTUALIZAR PRODUCTO
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("SELECT imagen FROM producto WHERE idProducto = ?");
            consulta.setInt(1, idProducto);
            ResultSet rs = consulta.executeQuery();

            byte[] imagenAnterior = null;
            if (rs.next()) {
                imagenAnterior = rs.getBytes("imagen");
            }

            byte[] nuevaImagen = producto.getImagen();

            if (nuevaImagen == null) {
                // Si no se ha seleccionado una nueva imagen, mantener la imagen anterior
                producto.setImagen(imagenAnterior);
            }

            PreparedStatement actualizacion = cn.prepareStatement("UPDATE producto SET nombre=?, stock=?, precio=?, descripcion=?, iva=?, imagen=?, estado=?, idCategoria=? WHERE idProducto=?");
            actualizacion.setString(1, producto.getNombre());
            actualizacion.setInt(2, producto.getStock());
            actualizacion.setDouble(3, producto.getPrecio());
            actualizacion.setString(4, producto.getDescripcion());
            actualizacion.setInt(5, producto.getIva());
            actualizacion.setBytes(6, producto.getImagen());
            actualizacion.setInt(7, producto.getEstado());
            actualizacion.setInt(8, producto.getIdCategoria());
            actualizacion.setInt(9, idProducto);

            if (actualizacion.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos del producto: " + e);
        }

        return respuesta;
    }

    public int actualizarStock(int cantidad, int id_producto) {
        String sql = "UPDATE producto set stock=? WHERE idProducto=?";
        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, id_producto);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock del producto: " + e);
        }
        return r;
    }

    public Producto listarId(int id) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto=?";
        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setStock(rs.getInt(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setDescripcion(rs.getString(5));
                producto.setIva(rs.getInt(6));
                producto.setImagen(rs.getBytes(7));
                producto.setIdCategoria(rs.getInt(8));
                producto.setEstado(rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar el id del producto: " + e);
        }
        return producto;
    }

    public boolean eliminar(int idProducto) { //METODO PARA ELIMINAR CATEGORIA
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM producto WHERE idCategoria='" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos de categoria: " + e);
        }
        return respuesta;
    }

    // Método para actualizar la imagen de un producto en la base de datos
    public boolean actualizarImagen(int idProducto, byte[] imagenBytes) {
        String sql = "UPDATE producto SET imagen = ? WHERE idProducto = ?";
        try (Connection cn = conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setBytes(1, imagenBytes);
            pst.setInt(2, idProducto);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la imagen del producto: " + e);
            return false;
        }
    }

    // Método para actualizar un producto en la base de datos sin modificar la imagen
    public boolean actualizarSinImagen(Producto producto, int idProducto) {
        String sql = "UPDATE producto SET nombre = ?, stock = ?, precio = ?, descripcion = ?, iva = ?, idCategoria = ? WHERE idProducto = ?";
        try (Connection cn = conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, producto.getNombre());
            pst.setInt(2, producto.getStock());
            pst.setDouble(3, producto.getPrecio());
            pst.setString(4, producto.getDescripcion());
            pst.setInt(5, producto.getIva());
            pst.setInt(6, producto.getIdCategoria());
            pst.setInt(7, idProducto);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto sin imagen: " + e);
            return false;
        }
    }

    /*public boolean actualizarStock(Producto producto, int idProducto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareCall("update producto set stock=? where idProducto ='" + idProducto + "'");
            consulta.setInt(1, producto.getStock());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar medicamento: " + e);
        }
        return respuesta;
    }*/
    public List<Producto> obtenerListaProductos() {
        List<Producto> listaProductos = new ArrayList<>();

        Connection cn = conexion.conectar();
        String consulta = "SELECT idProducto, nombre, stock, precio FROM producto"; // Ajusta la consulta según tu base de datos

        try {
            try (PreparedStatement ps = cn.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int idProducto = rs.getInt("idProducto");
                    String nombreProducto = rs.getString("nombre");
                    double precio = rs.getDouble("precio");
                    int stock = rs.getInt("stock");

                    Producto producto = new Producto(idProducto, nombreProducto, (int) precio, stock);
                    listaProductos.add(producto);
                }

            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de productos: " + e);
        }

        return listaProductos;
    }

    public int obtenerIdProductoPorNombre(String nombreProducto) {
        int idProducto = -1;
        Connection cn = conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("SELECT idProducto FROM producto WHERE nombre = ?");
            consulta.setString(1, nombreProducto);

            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                idProducto = resultado.getInt("idProducto");
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto por nombre: " + e);
        }

        return idProducto;
    }

    public Producto obtenerProductoPorId(int idProducto) {
        Producto producto = null;
        Connection cn = conexion.conectar(); // Asumiendo que tienes una clase llamada 'conexion' para gestionar la conexión

        try {
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            consulta.setInt(1, idProducto);

            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("idProducto");
                String nombre = resultado.getString("nombre");
                int stock = resultado.getInt("stock");
                double precio = resultado.getDouble("precio");

                producto = new Producto(id, nombre, stock, precio);
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e);
        }

        return producto;
    }

    public Producto mostrar_por_id(int id) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto=?";
        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps;
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            //ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setStock(rs.getInt(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setDescripcion(rs.getString(5));
                producto.setIva(rs.getInt(6));
                producto.setImagen(rs.getBytes(7));
                producto.setIdCategoria(rs.getInt(8));
                producto.setEstado(rs.getInt(9));
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar el codigo del producto" + e);
        }
        return producto;
    }

}
