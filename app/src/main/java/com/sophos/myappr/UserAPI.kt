package com.sophos.myappr

import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPI {
    @GET("RS_Oficinas?ciudad=Medellín")
    suspend fun getPost(): City

    @GET("RS_Oficinas")
    suspend fun getPostX(@Query("ciudad") ciudad: String ): City

    @GET("RS_Oficinas")
    suspend fun getPosts(): City

    @GET("RS_Usuarios?idUsuario=jsuarezq1@gmail.com&clave=tYGZ6ZdLVJdknjav")
    suspend fun getPostUser(): Usuario

    @GET("RS_Usuarios")
    suspend fun getPostUserQ(
        @Query("idUsuario") idUsuario: String,
        @Query("clave") clave: String ): Usuario
}