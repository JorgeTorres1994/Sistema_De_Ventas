package controlador;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Producto;

public class Categoria_Controller {
    private String SQL_AGREGAR = "INSERT INTO imagen (titulo, imagen) VALUES (?,?)";
    private String SQL_CONSULTA = "SELECT * FROM imagen";
    
    public boolean guardar(Categoria categoria){ //METODO PARA REGISTRAR CATEGORIA
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try{
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO categoria VALUES (?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, categoria.getDescripcion());
            consulta.setInt(3, categoria.getEstado());
            if(consulta.executeUpdate() > 0){
                respuesta = true;
            }
            
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al guardar los datos de categoria: " + e);
        }
        
        return respuesta;
    }
    
    public boolean existeCategoria(String categoria){ //METODO PARA MOSTRAR QUE EXISTE LA CATEGORIA
        boolean respuesta = false;
        String sql = "SELECT descripcion FROM categoria WHERE descripcion = '" + categoria + "'";
        Statement st;
        try{
            Connection cn = conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta= true;
            }
        }catch(SQLException e){
            System.out.println("Error al consultar la categoria: " + e);
        }
        
        return respuesta;
    }
    
    public boolean actualizar(Categoria categoria, int idCategoria){ //METODO PARA ACTUALIZAR CATEGORIA
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try{
            PreparedStatement consulta = cn.prepareStatement("UPDATE categoria SET descripcion=? WHERE idCategoria='" + idCategoria + "'");
            consulta.setString(1, categoria.getDescripcion());
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
            }
            
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al actualizar los datos de categoria: " + e);
        }
        
        return respuesta;
    }
    
    public boolean eliminar(int idCategoria){ //METODO PARA ELIMINAR CATEGORIA
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        try{
            PreparedStatement consulta = cn.prepareStatement("DELETE FROM categoria WHERE idCategoria='" + idCategoria + "'");
            consulta.executeUpdate();
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
            }
            
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al eliminar los datos de categoria: " + e);
        }
        
        return respuesta;
    }
}
