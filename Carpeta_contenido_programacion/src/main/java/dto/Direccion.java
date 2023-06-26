/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.security.PrivateKey;
import java.time.LocalDate;

/**
 *
 * @author Marcos
 */
public class Direccion {
    private int numero;
    private String tipo;
    private String direccion;
    private String poblacion;
    private String provincia;
    private int codigoPostal;
    private Usuario cliente;

    public Direccion(int numero, String tipo, String direccion, String poblacion, String provincia, int codigoPostal, Usuario cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Direccion{" + "numero=" + numero + ", tipo=" + tipo + ", direccion=" + direccion + ", poblacion=" + poblacion + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", cliente=" + cliente + '}';
    }
    
    
}
