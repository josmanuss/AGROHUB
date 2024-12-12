package com.josemanuel.agrohub.dominio;

import java.util.List;

public class ProductoResponse {
    private List<ProductoRequest> data;
    private String message;
    private int status;

    public List<ProductoRequest> getData() {
        return data;
    }

    public void setData(List<ProductoRequest> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
