package com.josemanuel.agrohub.dominio;



public class Consumidor extends Persona {

    private int id_consumidor;
    private Usuario usuario;

    public Consumidor(int id_consumidor, Usuario usuario, int id_persona, String nombre, String email, String direccion, String telefono) {
        super(id_persona, nombre, email, direccion, telefono);
        this.id_consumidor=id_consumidor;
        this.usuario = usuario;
    }


    public int getId_consumidor() {
        return id_consumidor;
    }

    public void setId_consumidor(int id_consumidor) {
        this.id_consumidor = id_consumidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
