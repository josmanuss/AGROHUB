package com.josemanuel.agrohub.datos;
import com.josemanuel.agrohub.dominio.Consumidor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ConsumidorApi {
    @GET("consumidores")
    Call<List<Consumidor>> getConsumidores();
    @POST("consumi---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------dores")
    Call<Void> addConsumidor(@Body Consumidor consumidor);

}
