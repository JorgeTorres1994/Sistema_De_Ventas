package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Usuario;

public class Usuario_Controller {

    public boolean guardar(Usuario usuario) { //METODO PARA REGISTRAR CLIENTE
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, usuario.getNombre());
            consulta.setString(3, usuario.getApellido());
            consulta.setString(4, usuario.getDni());
            consulta.setString(5, usuario.getUsuario());
            consulta.setString(6, usuario.getContraseña());
            consulta.setString(7, usuario.getTelefono());
            consulta.setString(8, usuario.getRol());
            consulta.setInt(9, usuario.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario: " + e);
        }

        return respuesta;
    }

    public boolean existeUsuario(String dni) { //METODO PARA MOSTRAR QUE EXISTE EL USUARIO
        boolean respuesta = false;
        String sql = "SELECT dni FROM usuario WHERE dni = '" + dni + "'";
        Statement st;
        try {
            Connection cn = conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el usuario: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Usuario usuario, int idUsuario) { //METODO PARA ACTUALIZAR USUARIO
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE usuario SET nombre=?,apellido=?,dni=?,usuario=?,contraseña=?,telefono=?,rol=?,estado=? WHERE idUsuario='" + idUsuario + "'");
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getApellido());
            consulta.setString(3, usuario.getDni());
            consulta.setString(4, usuario.getUsuario());
            consulta.setString(5, usuario.getContraseña());
            consulta.setString(6, usuario.getTelefono());
            consulta.setString(7, usuario.getRol());
            consulta.setInt(8, usuario.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos del usuario: " + e);
        }

        return respuesta;
    }

    public boolean eliminar(int idUsuario) { //METODO PARA ELIMINAR CLIENTE
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM usuario WHERE idUsuario='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos del usuario: " + e);
        }
        return respuesta;
    }

    public String obtenerNombreUsuario(int idUsuario) {
        Connection cn = null;
        PreparedStatement consultaUsuarioStmt = null;
        ResultSet usuarioResult = null;
        String nombreUsuario = "";

        try {
            cn = conexion.conectar(); // Asumiendo que tienes una clase llamada 'conexion' para gestionar la conexión
            String consultaUsuario = "SELECT nombre FROM usuario WHERE idUsuario = ?";
            consultaUsuarioStmt = cn.prepareStatement(consultaUsuario);
            consultaUsuarioStmt.setInt(1, idUsuario);
            usuarioResult = consultaUsuarioStmt.executeQuery();

            if (usuarioResult.next()) {
                nombreUsuario = usuarioResult.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del usuario: " + e);
        } finally {
            // Cierra las conexiones y recursos
            try {
                if (usuarioResult != null) {
                    usuarioResult.close();
                }
                if (consultaUsuarioStmt != null) {
                    consultaUsuarioStmt.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiones: " + e);
            }
        }

        return nombreUsuario;
    }
}
