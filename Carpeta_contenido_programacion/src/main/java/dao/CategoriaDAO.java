/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.OptionalInt;
import dto.Categoria;

/**
 *
 * @author ciclost
 */
public class CategoriaDAO extends TablaDAO<Categoria>{

    public CategoriaDAO() {
         this.tabla = "PROYECTO_CATEGORIA";
    }
    
    

    @Override
    public int actualizar(Categoria cat) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Categoria cat) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria eliminar(Categoria cat) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public boolean existe(Categoria cat) throws SQLException {
        return existe(cat.getCodigo()); 
    }
    
    

    @Override
    public ArrayList<Categoria> getAll() throws SQLException {
        
        ArrayList<Categoria> lista = new ArrayList<>();
        
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        
        
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            lista.add(new Categoria(codigo, nombre));
        }
        
        return lista;
    }

    @Override
    public Categoria getByCodigo(int codigo) throws SQLException {
        
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            return new Categoria(codigo, nombre);
        }

        return null;
    }
    
    public Integer getCodigoDe(String nombre) throws SQLException {
        String sentenciaSQL = "SELECT codigo FROM " + tabla + " WHERE nombre= ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombre);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("codigo");
        }
        
        return null;
    }

    public ArrayList<Articulo> getProductoByCodCateg(int codigoCAT) throws SQLException {
        ArrayList<Articulo> articulos = new ArrayList<>();
        String sentenciaSQL = "select codigo_articulo from proyecto_r_articulo_categoria where codigo_categoria=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoCAT);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo_articulo");
            ArticuloDao art = new ArticuloDao();
            articulos.add(art.getByCodigo(codigo));
        }
        return articulos;
    }
    
}
