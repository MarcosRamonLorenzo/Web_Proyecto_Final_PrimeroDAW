/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class Articulo {
    private int codigo;
    private double precio;
    private int stock;
    private double PVP;
    private String descripcion;
    private String marca;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaModificacion;
    private ArrayList<Categoria> cateogria;
    private String foto;
    private Usuario usuarioCrea;
    private Usuario usuarioModifica;
    private String unidadDeMedida;

    public Articulo(int codigo, double precio, int stock, double PVP, String descripcion, String marca, LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, ArrayList<Categoria> cateogria, String foto, Usuario usuarioCrea, Usuario usuarioModifica, String unidadDeMedida) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.PVP = PVP;
        this.descripcion = descripcion;
        this.marca = marca;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.cateogria = cateogria;
        this.foto = foto;
        this.usuarioCrea = usuarioCrea;
        this.usuarioModifica = usuarioModifica;
        this.unidadDeMedida = unidadDeMedida;
    }
    

    

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPVP() {
        return PVP;
    }

    public void setPVP(double PVP) {
        this.PVP = PVP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricacion() {
        return marca;
    }

    public void setFabricacion(String marca) {
        this.marca = marca;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public ArrayList<Categoria> getCateogria() {
        return cateogria;
    }

    public void setCateogria(ArrayList<Categoria> cateogria) {
        this.cateogria = cateogria;
    }

    public Usuario getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(Usuario usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Usuario getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(Usuario usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", precio=" + precio + ", stock=" + stock + ", PVP=" + PVP + ", descripcion=" + descripcion + ", marca=" + marca + ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + fechaUltimaModificacion + ", cateogria=" + cateogria + ", foto=" + foto + ", usuarioCrea=" + usuarioCrea + ", usuarioModifica=" + usuarioModifica + ", unidadDeMedida=" + unidadDeMedida + "} \n";
    }


    
    
    
    
}
