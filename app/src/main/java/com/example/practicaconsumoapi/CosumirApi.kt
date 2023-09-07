package com.example.practicaconsumoapi

import com.example.practicaconsumoapi.Entidades.Persona
import retrofit2.Call
import retrofit2.http.GET


interface ConsumirApi {
    @GET("api")
    fun obtenerPersona(): Call<Persona>

}