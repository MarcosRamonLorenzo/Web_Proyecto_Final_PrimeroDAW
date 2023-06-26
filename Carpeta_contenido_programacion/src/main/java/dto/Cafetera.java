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
public class Cafetera extends Articulo{
    
    private TipoCafetera tipoCafetera;
    private int CapacidadCapsulas;
    private String peso;

    public Cafetera(TipoCafetera tipoCafetera, int CapacidadCapsulas, String peso, int codigo, double precio, int stock, double PVP, String descripcion, String marca, LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, ArrayList<Categoria> cateogria, String foto, Usuario usuarioCrea, Usuario usuarioModifica, String unidadDeMedida) {
        super(codigo, precio, stock, PVP, descripcion, marca, fechaCreacion, fechaUltimaModificacion, cateogria, foto, usuarioCrea, usuarioModifica, unidadDeMedida);
        this.tipoCafetera = tipoCafetera;
        this.CapacidadCapsulas = CapacidadCapsulas;
        this.peso = peso;
    }

    public TipoCafetera getTipoCafetera() {
        return tipoCafetera;
    }

    public void setTipoCafetera(TipoCafetera tipoCafetera) {
        this.tipoCafetera = tipoCafetera;
    }

   

    

    

    public int getCapacidadCapsulas() {
        return CapacidadCapsulas;
    }

    public void setCapacidadCapsulas(int CapacidadCapsulas) {
        this.CapacidadCapsulas = CapacidadCapsulas;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Cafetera{" + "tipoCafetera=" + tipoCafetera + ", CapacidadCapsulas=" + CapacidadCapsulas + ", peso=" + peso + '}';
    }
    
    
    
}
