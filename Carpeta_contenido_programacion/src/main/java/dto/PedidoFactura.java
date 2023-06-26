/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author ciclost
 */
public class PedidoFactura {
    private int codigo;
    private LocalDateTime fechaPedido;
    private TipoEstadoFacturacion estadoFacturacion;
    private Direccion direccion;
    private Cesta cesta;

    public PedidoFactura(int codigo, LocalDateTime fechaPedido, TipoEstadoFacturacion estadoFacturacion, Direccion direccion, Cesta cesta) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.estadoFacturacion = estadoFacturacion;
        this.direccion = direccion;
        this.cesta = cesta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public TipoEstadoFacturacion getEstadoFacturacion() {
        return estadoFacturacion;
    }

    public void setEstadoFacturacion(TipoEstadoFacturacion estadoFacturacion) {
        this.estadoFacturacion = estadoFacturacion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    @Override
    public String toString() {
        return "PedidoFactura{" + "codigo=" + codigo + ", fechaPedido=" + fechaPedido + ", estadoFacturacion=" + estadoFacturacion + ", direccion=" + direccion + ", cesta=" + cesta + '}';
    }
    
    
    
    
}
