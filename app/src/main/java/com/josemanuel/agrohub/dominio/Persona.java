package com.josemanuel.agrohub.dominio;

public abstract class Persona {
    private int id_persona;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;

    public Persona(int id_persona, String nombre, String email, String direccion, String telefono) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
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
}
