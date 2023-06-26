/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */
public class Cesta {
    

    private  String nombre;
    private String tipo;
    private Usuario cliente;
    private ArrayList<LineaPedido> lineaPedido;

    public Cesta( String nombre, String tipo, Usuario cliente, ArrayList<LineaPedido> lineaPedido) {
       
        this.nombre = nombre;
        this.tipo = tipo;
        this.cliente = cliente;
        this.lineaPedido = lineaPedido;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaPedido> getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(ArrayList<LineaPedido> lineaPedido) {
        this.lineaPedido = lineaPedido;
    }

    @Override
    public String toString() {
        return "Cesta{" + ", nombre=" + nombre + ", tipo=" + tipo + ", cliente=" + cliente + ", lineaPedido=" + lineaPedido + '}';
    }
    
    public double getPrecioCesta(){
        double acum=0;
        for (LineaPedido lineaPedido1 : lineaPedido) {
            acum+=lineaPedido1.getPrecioTotal();
        }
        return acum;
    }
     
}
