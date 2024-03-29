package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class Cliente_Controller {

    public boolean guardar(Cliente cliente) { //METODO PARA REGISTRAR CLIENTE
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, cliente.getNombre());
            consulta.setString(3, cliente.getApellido());
            consulta.setString(4, cliente.getDni());
            consulta.setString(5, cliente.getTelefono());
            consulta.setString(6, cliente.getDireccion());
            consulta.setInt(7, cliente.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e);
        }

        return respuesta;
    }

    public boolean existeCliente(String dni) { //METODO PARA MOSTRAR QUE EXISTE EL CLIENTE
        boolean respuesta = false;
        String sql = "SELECT dni FROM cliente WHERE dni = '" + dni + "'";
        Statement st;
        try {
            Connection cn = conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el cliente: " + e);
        }

        return respuesta;
    }

    public Cliente mostrar_por_Dni(String dni) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente where dni=?";
        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps;
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setDireccion(rs.getString(6));
                cliente.setEstado(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("Error al encontrar el dni del cliente" + e);
        }
        return cliente;
    }

    public boolean actualizar(Cliente cliente, int idCliente) { //METODO PARA ACTUALIZAR CLIENTE
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE cliente SET nombre=?,apellido=?,dni=?,telefono=?,direccion=?,estado=? WHERE idCliente='" + idCliente + "'");
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getApellido());
            consulta.setString(3, cliente.getDni());
            consulta.setString(4, cliente.getTelefono());
            consulta.setString(5, cliente.getDireccion());
            consulta.setInt(6, cliente.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos del cliente: " + e);
        }

        return respuesta;
    }

    public boolean eliminar(int idCliente) { //METODO PARA ELIMINAR CLIENTE
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM cliente WHERE idCliente='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos del cliente: " + e);
        }
        return respuesta;
    }

    // Método para obtener la lista de nombres de clientes desde la base de datos
    public List<String> obtenerListaClientes() {
        List<String> listaClientes = new ArrayList<>();

        Connection cn = conexion.conectar();
        String consulta = "SELECT nombre,apellido FROM cliente"; // Ajusta la consulta según tu base de datos

        try {
            PreparedStatement ps = cn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreCliente = rs.getString("nombre");
                String apellidoCliente = rs.getString("apellido");
                listaClientes.add(nombreCliente + " " + apellidoCliente);
            }

            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de clientes: " + e);
        }

        return listaClientes;
    }
}
