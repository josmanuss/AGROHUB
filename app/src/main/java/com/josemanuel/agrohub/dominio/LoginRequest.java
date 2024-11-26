package com.josemanuel.agrohub.dominio;

public class LoginRequest
{
    private String usuario_email;
    private String contrasenia;


    public LoginRequest(String usuario_email, String contrasenia) {
        this.usuario_email = usuario_email;
        this.contrasenia = contrasenia;
    }


    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}