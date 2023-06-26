/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Cesta;
import dto.Direccion;
import dto.PedidoFactura;
import dto.TipoEstadoFacturacion;
import dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ciclost
 */
public class PedidoFacturaDAO extends TablaDAO<PedidoFactura> {

    public PedidoFacturaDAO() {
        this.tabla = "PROYECTO_PEDIDOYFACTURACION";
    }

    @Override
    public int anyadir(PedidoFactura p) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, p.getCodigo());
        prepared.setTimestamp(2, Timestamp.valueOf(p.getFechaPedido()));
        prepared.setInt(3, p.getDireccion().getNumero());
        prepared.setString(4, p.getDireccion().getCliente().getEmail());
        prepared.setString(5, p.getEstadoFacturacion().name());
        prepared.setString(6, p.getCesta().getNombre());

        int resultado = prepared.executeUpdate();
        return resultado;
    }
    
    public int actualizarFactura(PedidoFactura p) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET estado_facturacion='Facturado' where codigo=? ";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, p.getCodigo());

        int resultado = prepared.executeUpdate();
        return resultado;
    }
    

    @Override
    public PedidoFactura eliminar(PedidoFactura p) throws SQLException {
        if (p == null) {
            return null;
        } else {
            return eliminar(p.getCodigo()) != null ? p : null;
        }
    }

    @Override
    public boolean existe(PedidoFactura pedido) throws SQLException {
        return existe(pedido.getCodigo());
    }

    @Override
    public ArrayList<PedidoFactura> getAll() throws SQLException {
        ArrayList<PedidoFactura> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            LocalDateTime fecha = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Direccion direccion = new DireccionDAO().getByCodigo(resultSet.getInt("numero"));
            TipoEstadoFacturacion tipoEstadoFact = TipoEstadoFacturacion.valueOf(resultSet.getString("estado_facturacion"));
            Cesta cesta = new CestaDAO().getByNombreCesta(resultSet.getString("nombre_cesta"));
            lista.add(new PedidoFactura(codigo, fecha, tipoEstadoFact, direccion, cesta));
        }

        return lista;
    }
    
    public ArrayList<PedidoFactura> getAllDeUsuario(Usuario usuario) throws SQLException {
        ArrayList<PedidoFactura> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " where email=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, usuario.getEmail());
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            LocalDateTime fecha = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Direccion direccion = new DireccionDAO().getByCodigo(resultSet.getInt("numero"));
            TipoEstadoFacturacion tipoEstadoFact = TipoEstadoFacturacion.valueOf(resultSet.getString("estado_facturacion"));
            Cesta cesta = new CestaDAO().getByNombreCesta(resultSet.getString("nombre_cesta"));
            lista.add(new PedidoFactura(codigo, fecha, tipoEstadoFact, direccion, cesta));
        }

        return lista;
    }

    @Override
    public PedidoFactura getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {

            LocalDateTime fecha = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
            Direccion direccion = new DireccionDAO().getByCodigo(resultSet.getInt("numero"));
            TipoEstadoFacturacion tipoEstadoFact = TipoEstadoFacturacion.valueOf(resultSet.getString("estado_facturacion"));
            Cesta cesta = new CestaDAO().getByNombreCesta(resultSet.getString("nombre_cesta"));

            return new PedidoFactura(codigo, fecha, tipoEstadoFact, direccion, cesta);
        }

        return null;
    }

    @Override
    public int actualizar(PedidoFactura objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int siguienteCod() throws SQLException {
        String sentenciaSQL = "select count(*)+1 from proyecto_pedidoyfacturacion;";
        PreparedStatement prepared = getPrepared(sentenciaSQL);

        return Integer.parseInt(sentenciaSQL);
    }

}
