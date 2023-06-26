/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.CafeMolido;
import dto.TiposCafe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class CafeMolidoDAO extends TablaDAO<CafeMolido> {
    
    
    public CafeMolidoDAO() {
        this.tabla = "PROYECTO_MOLIDO";
    }

    @Override
    public int actualizar(CafeMolido objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(CafeMolido objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CafeMolido eliminar(CafeMolido objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(CafeMolido c) throws SQLException {
          return existe(c.getCodigo());
    }

    @Override
    public ArrayList<CafeMolido> getAll() throws SQLException {
        ArrayList<CafeMolido> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + "";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            String peso = resultSet.getString("peso");
            TiposCafe tipoCafe = TiposCafe.valueOf(resultSet.getString("tipo"));
            Articulo articulo = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_artic"));
           
      
         lista.add(new CafeMolido(tipoCafe, peso, articulo.getCodigo(), articulo.getPrecio(), articulo.getStock(), articulo.getPVP(), articulo.getDescripcion(), articulo.getFabricacion(), articulo.getFechaCreacion(), articulo.getFechaUltimaModificacion(), articulo.getCateogria(), articulo.getFoto(), articulo.getUsuarioCrea(), articulo.getUsuarioModifica(), articulo.getUnidadDeMedida()));
        }

        return lista;
    }
    @Override
    public CafeMolido getByCodigo(int codigo) throws SQLException {
         String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo_artic=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            
            
            String peso = resultSet.getString("peso");
            TiposCafe tipoCafe = TiposCafe.valueOf(resultSet.getString("tipo"));
            Articulo articulo = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_artic"));
            

             return new CafeMolido(tipoCafe, peso, articulo.getCodigo(), articulo.getPrecio(), articulo.getStock(), articulo.getPVP(), articulo.getDescripcion(), articulo.getFabricacion(), articulo.getFechaCreacion(), articulo.getFechaUltimaModificacion(), articulo.getCateogria(), articulo.getFoto(), articulo.getUsuarioCrea(), articulo.getUsuarioModifica(), articulo.getUnidadDeMedida());
        }

        return null;
    }
        
  
    
    
}
