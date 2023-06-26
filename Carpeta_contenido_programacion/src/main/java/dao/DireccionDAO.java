/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Direccion;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ciclost
 */
public class DireccionDAO extends TablaDAO<Direccion>{
    
     public DireccionDAO() {
        this.tabla = "PROYECTO_DIRECCION";
    }

    @Override
    public int actualizar(Direccion objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Direccion d) throws SQLException {
         String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, d.getNumero());
        prepared.setString(2, d.getCliente().getEmail());
        prepared.setString(3, d.getTipo());
        prepared.setString(4, d.getDireccion());
        prepared.setString(5, d.getPoblacion());
        prepared.setString(6, d.getProvincia());
        prepared.setInt(7, d.getCodigoPostal());
        return prepared.executeUpdate();
    }

    @Override
    public Direccion eliminar(Direccion d) throws SQLException {
         if (d == null) {
            return null;
        } else {
            return eliminar(d.getNumero()) != null ? d : null;
        }
    }

    @Override
    public boolean existe(Direccion d) throws SQLException {
            return existe(d.getNumero());
    }

    
    
    
    @Override
    public ArrayList<Direccion> getAll() throws SQLException {
        
        ArrayList<Direccion> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY numero";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            int codigo = resultSet.getInt("numero");
            Usuario usuario = new UsuarioDAO().getByEmail(resultSet.getString("email"));
            String tipo = resultSet.getString("tipo");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            int cp = resultSet.getInt("codigo_postal");
            lista.add(new Direccion(codigo, tipo, direccion, poblacion, provincia, codigo, usuario));
        }
        return lista;
    
    }

    @Override
    public Direccion getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE numero=?";;
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
             Usuario usuario = new UsuarioDAO().getByEmail(resultSet.getString("email"));
            String tipo = resultSet.getString("tipo");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            int cp = resultSet.getInt("codigo_postal");
            return new Direccion(codigo, tipo, direccion, poblacion, provincia, codigo, usuario);
        }
        return null;
    }
    
    
    public ArrayList<Direccion> getDireccionesDe(Usuario u) throws SQLException {
        
        ArrayList<Direccion> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE email=? ORDER BY numero";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, u.getEmail());
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            int codigo = resultSet.getInt("numero");
            Usuario usuario = new UsuarioDAO().getByEmail(resultSet.getString("email"));
            String tipo = resultSet.getString("tipo");
            String direccion = resultSet.getString("direccion");
            String poblacion = resultSet.getString("poblacion");
            String provincia = resultSet.getString("provincia");
            int cp = resultSet.getInt("codigo_postal");
            lista.add(new Direccion(codigo, tipo, direccion, poblacion, provincia, codigo, usuario));
        }
        return lista;
    }
    
}
