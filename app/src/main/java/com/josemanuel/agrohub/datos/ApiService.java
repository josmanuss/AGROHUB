package com.josemanuel.agrohub.datos;
import com.josemanuel.agrohub.dominio.AgricultorRequest;
import com.josemanuel.agrohub.dominio.AgricultorResponse;
import com.josemanuel.agrohub.dominio.ConsumidorRequest;
import com.josemanuel.agrohub.dominio.ConsumidorResponse;
import com.josemanuel.agrohub.dominio.LoginRequest;
import com.josemanuel.agrohub.dominio.LoginResponse;
import com.josemanuel.agrohub.dominio.ProductoResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;

public interface ApiService {
    @POST("login_consumidor")
    Call<LoginResponse> loginConsumidor(@Body LoginRequest requestConsumidor);

    @POST("login_agricultor")
    Call<LoginResponse> loginAgricultor(@Body LoginRequest requestAgricultor);

    @POST("registrar_consumidor")
    Call<ConsumidorResponse> registrarConsumidor(@Body ConsumidorRequest consumidorRequest);

    @POST("registrar_agricultor")
    Call<AgricultorResponse> registrarAgricultor(@Body AgricultorRequest agricultorRequest);

    @GET("listarProductos")
    default Call<ProductoResponse> listarProductos() {
        return null;
    }


}
