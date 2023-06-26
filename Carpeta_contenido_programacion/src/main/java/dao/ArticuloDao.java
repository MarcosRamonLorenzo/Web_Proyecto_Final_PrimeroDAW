/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Categoria;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 *
 * @author ciclost
 */
public class ArticuloDao extends TablaDAO<Articulo>{
    
      public ArticuloDao() {
        this.tabla = "PROYECTO_ARTICULO";
    }


    @Override
    public int actualizar(Articulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(Articulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Articulo eliminar(Articulo objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(Articulo articulo) throws SQLException {
        return existe(articulo.getCodigo());
    }

    @Override
    public ArrayList<Articulo> getAll() throws SQLException {
        ArrayList<Articulo> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String descripcion = resultSet.getString("descripcion");
             String marca = resultSet.getString("marca");
            double precio = resultSet.getDouble("PVP");
            String unidadDeMedida = resultSet.getString("unidad_medida");
            int stock = resultSet.getInt("stock");
            String foto = resultSet.getString("foto");
            Usuario usuarioCrea = new UsuarioDAO().getByEmail(resultSet.getString("usuario_crea"));
            LocalDateTime fechaCreacion = resultSet.getTimestamp("fecha_creacion").toLocalDateTime();
            Usuario usuarioModifica = new UsuarioDAO().getByEmail(resultSet.getString("usuario_modifica"));
            Timestamp fechaModificacionTS = resultSet.getTimestamp("fecha_ultima_modificacion");
            LocalDateTime fechaModificacion = (fechaModificacionTS == null) ? null : fechaModificacionTS.toLocalDateTime();
            ArrayList<Categoria> categorias = getCategoriasByCodProducto(codigo);

            lista.add(new Articulo(codigo, precio, stock, precio, descripcion, marca, fechaCreacion, fechaModificacion, categorias, foto, usuarioCrea, usuarioModifica, unidadDeMedida));
        }

        return lista;
    }

    @Override
    public Articulo getByCodigo(int codigo) throws SQLException {
        
         String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            
            
            String descripcion = resultSet.getString("descripcion");
             String marca = resultSet.getString("marca");
            double precio = resultSet.getDouble("PVP");
            String unidadDeMedida = resultSet.getString("unidad_medida");
            int stock = resultSet.getInt("stock");
            String foto = resultSet.getString("foto");
            Usuario usuarioCrea = new UsuarioDAO().getByEmail(resultSet.getString("usuario_crea"));
            LocalDateTime fechaCreacion = resultSet.getTimestamp("fecha_creacion").toLocalDateTime();
            Usuario usuarioModifica = new UsuarioDAO().getByEmail(resultSet.getString("usuario_modifica"));
            Timestamp fechaModificacionTS = resultSet.getTimestamp("fecha_ultima_modificacion");
            LocalDateTime fechaModificacion = (fechaModificacionTS == null) ? null : fechaModificacionTS.toLocalDateTime();
            ArrayList<Categoria> categorias = getCategoriasByCodProducto(codigo);

            return new Articulo(codigo, precio, stock, precio, descripcion, marca, fechaCreacion, fechaModificacion, categorias, foto, usuarioCrea, usuarioModifica, unidadDeMedida);
        }

        return null;
    }
    
    
    
    
    public ArrayList<Categoria> getCategoriasByCodProducto(int codigoArticulo) throws SQLException {
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sentenciaSQL = "select categ.codigo, categ.nombre from proyecto_r_articulo_categoria prac, proyecto_categoria categ where categ.codigo = prac.codigo_articulo and prac.codigo_articulo = ? order by categ.codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigoArticulo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            categorias.add(new Categoria(codigo, nombre));
        }
        return categorias;
    }
    
    
    
    
    
}
