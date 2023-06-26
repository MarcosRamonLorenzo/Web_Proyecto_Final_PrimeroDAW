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
public class Capsula extends Articulo{
    private TiposCafe tipoCapsula;
    private String cantidadPorCapsula;

    public Capsula(TiposCafe tipoCapsula, String cantidadPorCapsula, int codigo, double precio, int stock, double PVP, String descripcion, String fabricacion, LocalDateTime fechaCreacion, LocalDateTime fechaUltimaModificacion, ArrayList<Categoria> cateogria, String foto, Usuario usuarioCrea, Usuario usuarioModifica, String unidadDeMedida) {
        super(codigo, precio, stock, PVP, descripcion, fabricacion, fechaCreacion, fechaUltimaModificacion, cateogria, foto, usuarioCrea, usuarioModifica, unidadDeMedida);
        this.tipoCapsula = tipoCapsula;
        this.cantidadPorCapsula = cantidadPorCapsula;
    }
    
    
    

   

    public TiposCafe getTipoCapsula() {
        return tipoCapsula;
    }

    public void setTipoCapsula(TiposCafe tipoCapsula) {
        this.tipoCapsula = tipoCapsula;
    }

    public String getCantidadPorCapsula() {
        return cantidadPorCapsula;
    }

    public void setCantidadPorCapsula(String cantidadPorCapsula) {
        this.cantidadPorCapsula = cantidadPorCapsula;
    }

    @Override
    public String toString() {
        return "Capsula{" + "tipoCapsula=" + tipoCapsula + ", cantidadPorCapsula=" + cantidadPorCapsula + "codigo=" + this.getCodigo() + ", precio=" + this.getPrecio() + ", stock=" + this.getStock() + ", PVP=" + this.getPVP() + ", descripcion=" + this.getDescripcion() + ", marca=" + this.getFabricacion() + ", fechaCreacion=" + this.getFechaCreacion() + ", fechaUltimaModificacion=" + this.getFechaUltimaModificacion() + ", cateogria=" + this.getCateogria() + ", foto=" + this.getFoto() + ", usuarioCrea=" + this.getUsuarioCrea() + ", usuarioModifica=" + this.getUsuarioModifica() + ", unidadDeMedida=" + this.getUsuarioModifica() + "} \n";
    }
    
    
}
