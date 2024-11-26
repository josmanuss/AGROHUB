package com.josemanuel.agrohub.datos;
import com.josemanuel.agrohub.dominio.Consumidor;
import com.josemanuel.agrohub.dominio.LoginRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;

public interface ApiService {
    @POST("/login_consumidor")
    Call<Consumidor> loginConsumidor(@Body LoginRequest loginRequest);
}
