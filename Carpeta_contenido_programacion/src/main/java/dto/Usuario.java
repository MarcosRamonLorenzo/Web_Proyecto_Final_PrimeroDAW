/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Marcos
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String email;
    private String contraseña;
    private int telefono;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaUltimaConexion;
    private String foto;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, String apellidos, String email, String contraseña, int telefono, LocalDate fechaNacimiento, LocalDateTime fechaUltimaConexion, String foto, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaUltimaConexion = fechaUltimaConexion;
        this.foto = foto;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaUltimaConexion() {
        return fechaUltimaConexion;
    }

    public void setFechaUltimaConexion(LocalDateTime fechaUltimaConexion) {
        this.fechaUltimaConexion = fechaUltimaConexion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", contrase\u00f1a=" + contraseña + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", fechaUltimaConexion=" + fechaUltimaConexion + ", foto=" + foto + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    
    public boolean isCliente(){
    
        return this.tipoUsuario==TipoUsuario.cliente;
    }
    
    public boolean isAdministrador(){
    
        return this.tipoUsuario==TipoUsuario.administrador;
    }
    

    
    
    
    

}
