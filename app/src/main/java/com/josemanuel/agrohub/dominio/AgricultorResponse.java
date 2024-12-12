package com.josemanuel.agrohub.dominio;

public class AgricultorResponse {
    private String message;
    private String status;
    private Data data;

    public static class Data {
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private String nombreUsuario;
        private String certificacion;


        public Data() {}

        // Getters y setters
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

        public String getCertificacion() { return certificacion; }
        public void setCertificacion(String certificacion) { this.certificacion = certificacion; }
    }


    public AgricultorResponse() {}


    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }
}
