/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Capsula;
import dto.Categoria;
import dto.TipoUsuario;
import dto.TiposCafe;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class CapsulaDAO extends TablaDAO<Capsula> {

       public CapsulaDAO() {
        this.tabla = "PROYECTO_CAPSULA";
    }
    
    @Override
    public int actualizar(Capsula objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Capsula objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Capsula eliminar(Capsula objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(Capsula capsula) throws SQLException {
        return existe(capsula.getCodigo());
    }

    @Override
    public ArrayList<Capsula> getAll() throws SQLException {
        ArrayList<Capsula> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + "";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            String cantidadPorCapsula = resultSet.getString("cantidad_por_capsula");
            TiposCafe tipoCafe = TiposCafe.valueOf(resultSet.getString("tipo"));
            Articulo articulo = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_artic"));
           
      
            
          

            lista.add(new Capsula(tipoCafe, cantidadPorCapsula, articulo.getCodigo(), articulo.getPrecio(), articulo.getStock(), articulo.getPVP(), articulo.getDescripcion(), articulo.getFabricacion(), articulo.getFechaCreacion(), articulo.getFechaUltimaModificacion(), articulo.getCateogria(), articulo.getFoto(), articulo.getUsuarioCrea(), articulo.getUsuarioModifica(), cantidadPorCapsula));
        }

        return lista;
    }

    @Override
    public Capsula getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo_artic=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            
            
            String cantidadPorCapsula = resultSet.getString("cantidad_por_capsula");
            TiposCafe tipoCafe = TiposCafe.valueOf(resultSet.getString("tipo"));
            Articulo articulo = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_artic"));
            

             return new Capsula(tipoCafe, cantidadPorCapsula, articulo.getCodigo(), articulo.getPrecio(), articulo.getStock(), articulo.getPVP(), articulo.getDescripcion(), articulo.getFabricacion(), articulo.getFechaCreacion(), articulo.getFechaUltimaModificacion(), articulo.getCateogria(), articulo.getFoto(), articulo.getUsuarioCrea(), articulo.getUsuarioModifica(), cantidadPorCapsula);
        }

        return null;
    }
    
    
   
    
}
