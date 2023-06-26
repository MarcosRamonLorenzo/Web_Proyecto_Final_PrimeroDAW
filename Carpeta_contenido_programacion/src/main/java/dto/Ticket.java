/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Marcos
 */
public class Ticket {
    private int codigo;
    private String asunto;
    private String mensaje;
    private Usuario usuario;

    public Ticket(int codigo, String asunto, String mensaje, Usuario usuario) {
        this.codigo = codigo;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Ticket{" + "codigo=" + codigo + ", asunto=" + asunto + ", mensaje=" + mensaje + ", usuario=" + usuario + '}';
    }
    
    
}
