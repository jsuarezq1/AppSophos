package com.sophos.myappr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophos.myappr.UserNetwork.retrofit
import kotlinx.coroutines.launch
import retrofit2.Call
import java.lang.Exception
import javax.security.auth.callback.Callback

class MainActivityViewModel: ViewModel() {
    val myResponse: MutableLiveData<City> = MutableLiveData()
    val myResponseX: MutableLiveData<City> = MutableLiveData()
    val myResponseList: MutableLiveData<List<City>> = MutableLiveData()
    val myResponseUser: MutableLiveData<Usuario> = MutableLiveData()
    val myResponseUserQ: MutableLiveData<Usuario> = MutableLiveData()
    val myResponseDoc: MutableLiveData<Documents> = MutableLiveData()
    val myResponseNewDoc: MutableLiveData<NewDocument> = MutableLiveData()
    val myResponseNewDoc2: MutableLiveData<NewDocument> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = retrofit.getPost()
        }
    }
    fun getPostX(ciudad: String) {
        viewModelScope.launch {
            try {
                myResponseX.value = retrofit.getPostX(ciudad)
            } catch (e:Exception) {
                myResponseX.value = null
            }
        }
    }
    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = listOf(retrofit.getPosts())
        }
    }
    fun getPostUser() {
        viewModelScope.launch {
            myResponseUser.value = retrofit.getPostUser()
        }
    }
    fun getPostUserQ(idUsuario:String, clave:String) {
        viewModelScope.launch {
            try {
                myResponseUserQ.value = retrofit.getPostUserQ(idUsuario, clave)
            } catch (e:Exception) {
                myResponseX.value = null
            }
        }
    }
    fun getPostDoc(correo: String) {
        viewModelScope.launch {
            try {
                myResponseDoc.value = retrofit.getPostDoc(correo)
            } catch (e:Exception) {
                myResponseDoc.value = null
            }
        }
    }

    fun getPostNewDoc(Correo: String,TipoAdjunto: String,Nombre: String,Apellido: String,
                      Ciudad: String,TipoId: String, Identificacion:String, Adjunto: String, put: Boolean
                      ) {
        viewModelScope.launch {
            try {
                myResponseNewDoc2.value = retrofit.getPostNewDoc(Correo,TipoAdjunto,Nombre, Apellido, Ciudad, TipoId,Identificacion,Adjunto, put)
            } catch (e:Exception) {
                myResponseNewDoc2.value = null
            }
        }
    }

    fun getNewDoc(userInfo:NewDocument) {
        viewModelScope.launch {
            try {
                myResponseNewDoc.value = UserNetwork.retrofit.getNewDoc(userInfo)
            } catch (e:Exception) {
                myResponseNewDoc.value = null
            }
        }
    }


}