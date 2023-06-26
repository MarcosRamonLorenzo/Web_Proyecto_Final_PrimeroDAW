/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Marcos
 */
public class LineaPedido {
    
    private int cantidadad; 
    private double precio;
    private Articulo articulo;

    public LineaPedido(int cantidadad, double precio, Articulo articulo) {
        this.cantidadad = cantidadad;
        this.precio = precio;
        this.articulo = articulo;
    }

    public int getCantidadad() {
        return cantidadad;
    }

    public void setCantidadad(int cantidadad) {
        this.cantidadad = cantidadad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "cantidadad=" + cantidadad + ", precio=" + precio + ", articulo=" + articulo + '}';
    }
    
    public double getPrecioTotal(){
        return this.cantidadad*this.precio;
    }
    
    public String estaSelected(int numero){
        if (numero==this.cantidadad) {
            return "selected value=\""+numero+"\"";
        } else {
            return "value=\""+numero+"\"";
        }
    }
}
