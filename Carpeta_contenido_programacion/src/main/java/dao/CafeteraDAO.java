/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Cafetera;
import dto.TipoCafetera;
import dto.TiposCafe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class CafeteraDAO extends TablaDAO<Cafetera>{
    
     public CafeteraDAO() {
        this.tabla = "PROYECTO_CAFETERA";
    }

    @Override
    public int actualizar(Cafetera objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int anyadir(Cafetera objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cafetera eliminar(Cafetera objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(Cafetera cafetera) throws SQLException {
         return existe(cafetera.getCodigo());
    }

    @Override
    public ArrayList<Cafetera> getAll() throws SQLException {
        ArrayList<Cafetera> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + "";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            String peso = resultSet.getString("peso");
            int  Capacidad_del_deposito_de_capsulas  = resultSet.getInt("Capacidad_del_deposito_de_capsulas");
            TipoCafetera tipoCafetera = TipoCafetera.valueOf(resultSet.getString("tipo"));
            Articulo articulo = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_artic"));
           
      
            
          

            lista.add(new Cafetera(tipoCafetera,Capacidad_del_deposito_de_capsulas,peso,articulo.getCodigo(), articulo.getPrecio(), articulo.getStock(), articulo.getPVP(), articulo.getDescripcion(), articulo.getFabricacion(), articulo.getFechaCreacion(), articulo.getFechaUltimaModificacion(), articulo.getCateogria(), articulo.getFoto(), articulo.getUsuarioCrea(), articulo.getUsuarioModifica(),articulo.getUnidadDeMedida()));
        }

        return lista;
    }

    @Override
    public Cafetera getByCodigo(int codigo) throws SQLException {
         String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo_artic=?";
         PreparedStatement prepared = getPrepared(sentenciaSQL);
         prepared.setInt(1, codigo);
         ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            
           String peso = resultSet.getString("peso");
           int  Capacidad_del_deposito_de_capsulas  = resultSet.getInt("Capacidad_del_deposito_de_capsulas");
            TipoCafetera tipoCafetera = TipoCafetera.valueOf(resultSet.getString("tipo"));
            Articulo articulo = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_artic"));
            
            return new Cafetera(tipoCafetera,Capacidad_del_deposito_de_capsulas,peso,articulo.getCodigo(), articulo.getPrecio(), articulo.getStock(), articulo.getPVP(), articulo.getDescripcion(), articulo.getFabricacion(), articulo.getFechaCreacion(), articulo.getFechaUltimaModificacion(), articulo.getCateogria(), articulo.getFoto(), articulo.getUsuarioCrea(), articulo.getUsuarioModifica(),articulo.getUnidadDeMedida());

        }

        return null;
    }
    
    
    
}
