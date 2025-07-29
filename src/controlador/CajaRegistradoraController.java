package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.CajaRegistradora;

public class CajaRegistradoraController {

    public boolean abrirCaja(CajaRegistradora caja) {
        boolean resultado = false;
        String sql = "INSERT INTO caja_registradora (montoApertura, responsableApertura, fechaAperur) VALUES (?, ?, ?)";
        Connection cn = conexion.conectar();
        
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setDouble(1, caja.getMontoApertura());
            statement.setString(2, caja.getResponsableApertura());
            statement.setString(3, caja.getFechaApertura());
            
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return resultado;
    }
}
