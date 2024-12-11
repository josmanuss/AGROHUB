package com.josemanuel.agrohub.datos;
import com.josemanuel.agrohub.dominio.Consumidor;
import com.josemanuel.agrohub.dominio.ConsumidorRequest;
import com.josemanuel.agrohub.dominio.ConsumidorResponse;
import com.josemanuel.agrohub.dominio.LoginRequest;
import com.josemanuel.agrohub.dominio.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;

public interface ApiService {
    @POST("login_consumidor")
    Call<LoginResponse> loginConsumidor(@Body LoginRequest request);

    @POST("registrar_consumidor")
    Call<ConsumidorResponse> registrarConsumidor(@Body ConsumidorRequest consumidorRequest);



}
