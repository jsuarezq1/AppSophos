package com.sophos.myappr

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import javax.security.auth.callback.Callback

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
        @Field ("TipoId")  TipoId: String?,
        @Field("Identificacion") Identificacion: String?,
        @Field("Nombre") Nombre: String?,
        @Field("Apellido") Apellido: String?,
        @Field("Ciudad") Ciudad: String?,
        @Field("Correo") Correo: String?,
        @Field("TipoAdjunto") TipoAdjunto: String?,
        @Field("Adjunto") Adjunto: String?,
        @Field("put") put: Boolean?): NewDocument

    @POST("RS_Documentos")
    suspend fun getNewDoc(@Body userData: NewDocument): NewDocument

    interface TaskService {
        @POST("/tasks")
        fun createTask(@Body task: Task?, cb: Callback)
    }


}