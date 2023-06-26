/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Articulo;
import dto.Cesta;
import dto.LineaPedido;
import dto.Usuario;
import java.sql.Date;
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
public class CestaDAO extends TablaDAO<Cesta> {
    
     public CestaDAO() {
        this.tabla = "PROYECTO_CESTA";
    }

     
     
     
      @Override
    public int anyadir(Cesta cesta) throws SQLException {
        String sentenciaSQL = "INSERT INTO "+tabla+" VALUES(?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(3, cesta.getCliente().getEmail());
        prepared.setString(1, cesta.getNombre());
       
         if (cesta.getTipo() == null) {
            prepared.setNull(2, java.sql.Types.VARCHAR);
        } else {
            prepared.setString(2, cesta.getTipo());
        }
       
         int a= prepared.executeUpdate();
         return a;
        
    }
    
     @Override
    public Cesta eliminar(Cesta cesta) throws SQLException {
           if (cesta == null) {
            return null;
        } else {
            String sentenciaSQL = "Delete from "+tabla+" where nombre=?";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setString(1, cesta.getNombre());
            prepared.executeUpdate();
            return cesta;
        }
    }
    
    public void anyadirLineaPedido(Cesta cesta) throws SQLException {
        for (LineaPedido linea: cesta.getLineaPedido()) {
        String sentenciaSQL = "INSERT INTO PROYECTO_LINEAS_PEDIDO(nombre_cesta,codigo_articulo,email,precio,cantidad) VALUES(?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, cesta.getNombre());
        prepared.setInt(2, linea.getArticulo().getCodigo());
        prepared.setString(3, cesta.getCliente().getEmail());
        prepared.setDouble(4, linea.getPrecio());
        prepared.setInt(5, linea.getCantidadad());
        
        prepared.executeUpdate();
        }
        
      
    }
    
    public void anyadirLinPed(LineaPedido ln,Cesta cesta) throws SQLException {
        
        String sentenciaSQL = "INSERT INTO PROYECTO_LINEAS_PEDIDO(nombre_cesta,codigo_articulo,email,precio,cantidad) VALUES(?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, cesta.getNombre());
        prepared.setInt(2, ln.getArticulo().getCodigo());
        prepared.setString(3, cesta.getCliente().getEmail());
        prepared.setDouble(4, ln.getPrecio());
        prepared.setInt(5, ln.getCantidadad());
        
        prepared.executeUpdate();
        
        
      
    }
    
    public void eliminarLinPed(int codigoLinea,Cesta cesta) throws SQLException {
        
        String sentenciaSQL = "delete from proyecto_lineas_pedido where codigo_articulo = ? and nombre_cesta = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(2, cesta.getNombre());
        prepared.setInt(1, codigoLinea);
        
        
        prepared.executeUpdate();
        
        
      
    }
    
    public void actualizarLinPed(int cantidad,int codigoLinea,Cesta cesta) throws SQLException {
        
        String sentenciaSQL = "update proyecto_lineas_pedido set cantidad=? where codigo_articulo=? and email=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, cantidad);
        prepared.setString(3, cesta.getNombre());
        prepared.setInt(2, codigoLinea);
        
        
        prepared.executeUpdate();
        
        
      
    }
    
    
    
    
     

   

  

     public boolean existePorNombreCesta(Cesta c) throws SQLException {
          return c.getNombre() != null;
    }
    
    public boolean existePorNombreCesta(String a) throws SQLException {
         return getByNombreCesta(a) !=null;
    }

    @Override
    public ArrayList<Cesta> getAll() throws SQLException {
         ArrayList<Cesta> lista = new ArrayList<>();
        
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY nombre";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            
            String nombre = resultSet.getString("nombre");
            String tipo = resultSet.getString("tipo");
            Usuario cliente = new UsuarioDAO().getByEmail(resultSet.getString("email_cliente"));
            ArrayList<LineaPedido> lineasPedido = getLineas(nombre);
            
            
            lista.add(new Cesta(nombre, tipo, cliente, lineasPedido));
            
        }

            return lista;
    
    }

    
     public Cesta getByNombreCesta(String nombreCesta) throws SQLException {
          
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE nombre=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreCesta);
        ResultSet resultSet = prepared.executeQuery();
         
        while (resultSet.next()) {
            
            String tipo = resultSet.getString("tipo");
            Usuario cliente = new UsuarioDAO().getByEmail(resultSet.getString("email_cliente"));
           ArrayList<LineaPedido> lineasPedido = getLineas(nombreCesta);
           
           return new Cesta(nombreCesta, tipo, cliente, lineasPedido);
            
        }
        
        return null;
    }
     
     
     
     public ArrayList<LineaPedido> getLineasByNombreCesta(String nombreCesta) throws SQLException {
          
        String sentenciaSQL = "select codigo_articulo,precio,cantidad from proyecto_lineas_pedido where nombre_cesta=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreCesta);
        ResultSet resultSet = prepared.executeQuery();
        ArrayList<LineaPedido> ln = new ArrayList<>();
        while (resultSet.next()) {
            
            int cantidad = resultSet.getInt("cantidad");
            double precio = resultSet.getDouble("precio");
           Articulo a = new ArticuloDao().getByCodigo(resultSet.getInt("codigo_articulo"));
           ln.add(new LineaPedido(cantidad, precio, a));
           
            
        }
        
        return ln;
    }
     
     
     
     
     
    
     
     
     
    @Override
    public Cesta getByCodigo(int codigo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<LineaPedido> getLineas(String nombreCesta) throws SQLException {
        ArticuloDao productoDAO = new ArticuloDao();
        ArrayList<LineaPedido> lineas = new ArrayList<>();
        String sentenciaSQL = "SELECT codigo_articulo, precio,cantidad FROM  PROYECTO_LINEAS_PEDIDO WHERE nombre_cesta = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombreCesta);
        ResultSet resultSet = prepared.executeQuery();
        
        while (resultSet.next()) {
            Articulo articulo = productoDAO.getByCodigo(resultSet.getInt("codigo_articulo"));
            double precio = resultSet.getInt("precio");
            int cantidad = resultSet.getInt("cantidad");
            lineas.add(new LineaPedido(cantidad, precio, articulo));
        }

        return lineas;
    }

    @Override
    public boolean existe(Cesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int actualizar(Cesta objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
