/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Ticket;
import dto.TipoUsuario;
import dto.Usuario;
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
public class TicketDAO extends TablaDAO<Ticket>{
    
    public TicketDAO() {
        this.tabla = "PROYECTO_TICKET";
    }
        
    @Override
    public int actualizar(Ticket objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Ticket t) throws SQLException {
          String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, t.getCodigo());
        prepared.setString(2,t.getAsunto());
        prepared.setString(3,t.getMensaje());
        prepared.setString(4,t.getUsuario().getEmail());
        
        return prepared.executeUpdate();
    
    }

    @Override
    public Ticket eliminar(Ticket t) throws SQLException {
         if (t == null) {
            return null;
        } else {
            return eliminar(t.getCodigo()) != null ? t : null;
        }
    }

    @Override
    public boolean existe(Ticket t) throws SQLException {
         return existe(t.getCodigo());
    }

    @Override
    public ArrayList<Ticket> getAll() throws SQLException {
ArrayList<Ticket> lista = new ArrayList<>();
        
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo=resultSet.getInt("codigo");
            String asunto = resultSet.getString("asunto");
            String mensaje = resultSet.getString("mensaje");
            Usuario usuario = new UsuarioDAO().getByEmail(resultSet.getString("email"));
            
           
            lista.add(new Ticket(codigo, asunto, mensaje, usuario));
            
        }

        return lista;   
    }

    @Override
    public Ticket getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String asunto = resultSet.getString("asunto");
            String mensaje = resultSet.getString("mensaje");
            Usuario usuario = new UsuarioDAO().getByEmail(resultSet.getString("email"));
            
            return new Ticket(codigo, asunto, mensaje, usuario);
            
            
        }

        return null;
    }

   
    
    
}
