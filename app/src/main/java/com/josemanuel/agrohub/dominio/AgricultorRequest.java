package com.josemanuel.agrohub.dominio;

public class AgricultorRequest {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private String nombreUsuario;
    private String contrasenia;
    private String certificacion;


    public AgricultorRequest(String nombre, String email, String direccion, String telefono,
                             String nombreUsuario, String contrasenia, String certificacion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.certificacion = certificacion;
    }


    public AgricultorRequest() {}


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public String getCertificacion() { return certificacion; }
    public void setCertificacion(String certificacion) { this.certificacion = certificacion; }
}
