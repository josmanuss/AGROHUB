package com.josemanuel.agrohub.dominio;

public class LoginResponse {
    private String id_consumidor;
    private String id_persona;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private String nombre_usuario;

    // Getters and Setters
    public String getId_consumidor() {
        return id_consumidor;
    }

    public void setId_consumidor(String id_consumidor) {
        this.id_consumidor = id_consumidor;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
}
