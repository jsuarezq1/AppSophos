package com.sophos.myappr

import retrofit2.http.GET
import retrofit2.http.POST
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

    @GET("RS_Documentos")
    suspend fun getPostDoc(@Query("correo") correo: String ): Documents

    @POST("RS_Documentos")
    suspend fun getPostNewDoc(
        @Query("TipoId")  TipoId: String,
        @Query("Identificacion") Identificacion: String,
        @Query("Nombre") Nombre: String,
        @Query("Apellido") Apellido: String,
        @Query("Ciudad") Ciudad: String,
        @Query("Correo") Correo: String,
        @Query("TipoAdjunto") TipoAdjunto: String,
        @Query("Adjunto") Adjunto: String
    ): NewDocument

}