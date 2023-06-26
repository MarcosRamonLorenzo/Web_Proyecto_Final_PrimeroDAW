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
public class CafeMolido extends Articulo{
    
    private TiposCafe tipoCafeMolido;
    private String peso;

    public CafeMolido(TiposCafe tipoCafeMolido, String peso, int codigo, double precio, int stock, double PVP, String descripcion, String fabricacion, LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, ArrayList<Categoria> cateogria, String foto, Usuario usuarioCrea, Usuario usuarioModifica, String unidadDeMedida) {
        super(codigo, precio, stock, PVP, descripcion, fabricacion, fechaCreacion, fechaUltimaModificacion, cateogria, foto, usuarioCrea, usuarioModifica, unidadDeMedida);
        this.tipoCafeMolido = tipoCafeMolido;
        this.peso = peso;
    }

    

   

    
    
    
    public TiposCafe getTipoCafeMolido() {
        return tipoCafeMolido;
    }

    public void setTipoCafeMolido(TiposCafe tipoCafeMolido) {
        this.tipoCafeMolido = tipoCafeMolido;
    }

    
    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "CafeMolido{" + "tipoCafeMolido=" + tipoCafeMolido + ", peso=" + peso + '}';
    }
    
    
    
}
