package com.example.luiscaguana.apppruebaretrofitjson.RetrofitUtisl;

import com.example.luiscaguana.apppruebaretrofitjson.model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPokemon {
    public static final String BASE_URL = "https://pokeapi.co/api/v2/";


    @GET ("pokemon/")
    Call<Resultado> obtenerPokemon();




}
