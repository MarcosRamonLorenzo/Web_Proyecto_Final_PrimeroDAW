/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.TipoUsuario;
import dto.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.OptionalInt;

/**
 *
 * @author ciclost
 */
public class UsuarioDAO extends TablaDAO<Usuario>{
    
      public UsuarioDAO() {
        this.tabla = "PROYECTO_USUARIO";
    }
    
    @Override
    public int anyadir(Usuario u) throws SQLException {
        String sentenciaSQL = "INSERT INTO "+tabla+" VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, u.getEmail());
        prepared.setString(2, u.getNombre());
        prepared.setString(3, u.getApellidos());
        prepared.setString(4, u.getContraseña());
        prepared.setDate(6, Date.valueOf(u.getFechaNacimiento()));
        prepared.setInt(5, u.getTelefono());
        prepared.setString(9, String.valueOf(u.getTipoUsuario()));
        LocalDateTime ultimaConexion = u.getFechaUltimaConexion();
        if (ultimaConexion == null) {
            prepared.setNull(7, java.sql.Types.TIMESTAMP);
        } else {
            prepared.setTimestamp(7, Timestamp.valueOf(ultimaConexion));
        }
         if (u.getFoto() == null) {
            prepared.setNull(8, java.sql.Types.VARCHAR);
        } else {
            prepared.setString(8, u.getFoto());
        }
        return prepared.executeUpdate();
    }
      
    @Override
    public int actualizar(Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public Usuario eliminar(Usuario usuario) throws SQLException {
         if (usuario == null) {
            return null;
        } else {
           String sentenciaSQL = "Delete from "+tabla+" where email=?";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setString(1, usuario.getEmail());
            prepared.executeUpdate();
            return usuario;
        }
    }

    public boolean existePorEmail(Usuario u) throws SQLException {
          return u.getEmail() != null;
    }
    
    public boolean existePorEmail(String a) throws SQLException {
         return getByEmail(a) !=null;
    }

   

    @Override
    public ArrayList<Usuario> getAll() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();
        
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY email";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            
            String email = resultSet.getString("email");
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String contrasenya = resultSet.getString("contrasenya");
            LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
            int telefono = resultSet.getInt("telefono");
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipoUsuario"));
            Timestamp ultimaConexionTS = resultSet.getTimestamp("fecha_ultima_conexion");
            LocalDateTime ultimaConexion = ultimaConexionTS == null ? null : ultimaConexionTS.toLocalDateTime();
            lista.add(new Usuario(nombre, apellidos, email, contrasenya, telefono, fechaNacimiento, ultimaConexion, nombre, tipoUsuario));
            
        }

        return lista;
    }

   
    
    public Usuario getByEmail(String email) throws SQLException {
       
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE email=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, email);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String contrasenya = resultSet.getString("contrasenya");
            int telefono = resultSet.getInt("telefono");
            LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
            String foto=resultSet.getString("foto");
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipoUsuario"));
            Timestamp ultimaConexionTS = resultSet.getTimestamp("fecha_ultima_conexion");
            LocalDateTime ultimaConexion = ultimaConexionTS == null ? null : ultimaConexionTS.toLocalDateTime();
            return new Usuario(nombre, apellidos, email, contrasenya, telefono, fechaNacimiento, ultimaConexion, foto, tipoUsuario);
            
        }
        
        return null;
        
        
        
    
    }
    
    
     public Usuario getUsuario(String email,String contrasenya) throws SQLException{
         
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE email=? and contrasenya=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, email);
        prepared.setString(2, contrasenya);
        ResultSet resultSet = prepared.executeQuery();
        
         while (resultSet.next()) {
            
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            int telefono = resultSet.getInt("telefono");
            LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
            String foto=resultSet.getString("foto");
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipoUsuario"));
            Timestamp ultimaConexionTS = resultSet.getTimestamp("fecha_ultima_conexion");
            LocalDateTime ultimaConexion = ultimaConexionTS == null ? null : ultimaConexionTS.toLocalDateTime();
            return new Usuario(nombre, apellidos, email, contrasenya, telefono, fechaNacimiento, ultimaConexion, foto, tipoUsuario);
            
        }
        
        return null;
        
       
       } 
    

    @Override
    public boolean existe(Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario getByCodigo(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
                              
    
   
}
