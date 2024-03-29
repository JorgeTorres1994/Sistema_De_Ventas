package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class Config_Usuario_Controller {

    public String obtenerRol(Usuario usuario) {
        String rol = null;
        Connection cn = conexion.conectar();
        try {
            // Prepara la consulta SQL
            String query = "SELECT rol FROM usuario WHERE usuario = ? AND contraseña = ?";
            try (PreparedStatement statement = cn.prepareStatement(query)) {
                statement.setString(1, usuario.getUsuario());
                statement.setString(2, usuario.getContraseña());

                // Ejecuta la consulta y obtiene el resultado
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        rol = resultSet.getString("rol");
                    }
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        return rol;
    }

    public String obtenerUsuario(Usuario usuario) {
        String user = null;
        Connection cn = conexion.conectar();
        try {
            // Prepara la consulta SQL
            String query = "SELECT usuario FROM usuario WHERE usuario = ?";
            try (PreparedStatement statement = cn.prepareStatement(query)) {
                statement.setString(1, usuario.getUsuario());

                // Ejecuta la consulta y obtiene el resultado
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        user = resultSet.getString("usuario");
                    }
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        return user;
    }

    public Usuario validarUsuario(String usuario, String contraseña) {
        Connection cn = conexion.conectar();
        String consulta = "SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Usuario y contraseña coinciden, se crea un objeto Usuario y se devuelve
                Usuario usuarioValidado = new Usuario();
                usuarioValidado.setIdUsuario(rs.getInt("idUsuario"));
                usuarioValidado.setUsuario(rs.getString("usuario"));
                usuarioValidado.setContraseña(rs.getString("contraseña"));
                usuarioValidado.setRol(rs.getString("rol"));
                // Agrega más campos si es necesario

                cn.close();
                return usuarioValidado;
            } else {
                // Usuario o contraseña incorrectos, devuelve null
                cn.close();
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error en SQL: " + e);
            return null;
        }
    }

    public String obtenerIdUsuario(Usuario usuario) {
        String idUsuario = null; // Inicialmente, lo establecemos como null en caso de que no se encuentre ningún resultado.

        String sql = "SELECT idUsuario FROM usuario WHERE usuario = ?";

        try {
            Connection cn = conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre()); // Utilizamos el nombre de usuario del objeto Usuario
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idUsuario = String.valueOf(rs.getInt("idUsuario"));
            }
        } catch (SQLException e) {
            System.out.println("Error en SQL: " + e);
        }

        return idUsuario;
    }

    public String obtenerNombreApellidoUsuario(Usuario usuario) {
        String nombreApellido = "";
        Connection cn = conexion.conectar();
        try {
            // Prepara la consulta SQL
            String query = "SELECT nombre, apellido FROM usuario WHERE usuario = ?";
            try (PreparedStatement statement = cn.prepareStatement(query)) {
                statement.setString(1, usuario.getUsuario());

                // Ejecuta la consulta y obtiene el resultado
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        nombreApellido = nombre + " " + apellido;
                    }
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        return nombreApellido;
    }

    public String obtenerContraseñaUsuario(String usuario) {
        String contraseña = null;
        Connection cn = conexion.conectar();
        try {
            // Prepara la consulta SQL
            String query = "SELECT contraseña FROM usuario WHERE usuario = ?";
            try (PreparedStatement statement = cn.prepareStatement(query)) {
                statement.setString(1, usuario);

                // Ejecuta la consulta y obtiene el resultado
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        contraseña = resultSet.getString("contraseña");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print("Ha ocurrido un error al obtener la contraseña " + e);
        }
        return contraseña;
    }

    public boolean actualizarUsuarioContraseña(String usuario, String nuevoUsuario, String nuevaContraseña) {
        Connection cn = conexion.conectar();
        try {
            // Prepara la consulta SQL para actualizar los datos
            String query = "UPDATE usuario SET usuario = ?, contraseña = ? WHERE usuario = ?";
            try (PreparedStatement statement = cn.prepareStatement(query)) {
                statement.setString(1, nuevoUsuario);
                statement.setString(2, nuevaContraseña);
                statement.setString(3, usuario);

                // Ejecuta la consulta
                int rowsAffected = statement.executeUpdate();

                // Verifica si se actualizó correctamente
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            return false;
        }
    }
}
