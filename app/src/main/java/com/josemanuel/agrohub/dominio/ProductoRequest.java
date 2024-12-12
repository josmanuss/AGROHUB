package com.josemanuel.agrohub.dominio;

public class ProductoRequest {
    private int cantidad_disponible;
    private String descripcion;
    private String fecha_publicacion;
    private int id_agricultor;
    private int id_producto;
    private String imagen;
    private String nombre_producto;
    private float precio;


    public ProductoRequest(int cantidad_disponible, String descripcion, String fecha_publicacion, int id_agricultor, int id_producto, String imagen, String nombre_producto, float precio) {
        this.cantidad_disponible = cantidad_disponible;
        this.descripcion = descripcion;
        this.fecha_publicacion = fecha_publicacion;
        this.id_agricultor = id_agricultor;
        this.id_producto = id_producto;
        this.imagen = imagen;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
    }


    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId_agricultor() {
        return id_agricultor;
    }

    public void setId_agricultor(int id_agricultor) {
        this.id_agricultor = id_agricultor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
