package com.sophos.myappr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel: ViewModel() {
    val myResponse: MutableLiveData<City> = MutableLiveData()
    val myResponseX: MutableLiveData<City> = MutableLiveData()
    val myResponseList: MutableLiveData<List<City>> = MutableLiveData()
    val myResponseUser: MutableLiveData<Usuario> = MutableLiveData()
    val myResponseUserQ: MutableLiveData<Usuario> = MutableLiveData()
    val myResponseDoc: MutableLiveData<Documents> = MutableLiveData()
    val myResponseNewDoc: MutableLiveData<NewDocument> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }
    fun getPostX(ciudad: String) {
        viewModelScope.launch {
            try {
                myResponseX.value = UserNetwork.retrofit.getPostX(ciudad)
            } catch (e:Exception) {
                myResponseX.value = null
            }
        }
    }
    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = listOf(UserNetwork.retrofit.getPosts())
        }
    }
    fun getPostUser() {
        viewModelScope.launch {
            myResponseUser.value = UserNetwork.retrofit.getPostUser()
        }
    }
    fun getPostUserQ(idUsuario:String, clave:String) {
        viewModelScope.launch {
            try {
                myResponseUserQ.value = UserNetwork.retrofit.getPostUserQ(idUsuario, clave)
            } catch (e:Exception) {
                myResponseX.value = null
            }
        }
    }
    fun getPostDoc(correo: String) {
        viewModelScope.launch {
            try {
                //myResponseDoc.value = UserNetwork.retrofit.getPostDoc(correo)
            } catch (e:Exception) {
                myResponseDoc.value = null
            }
        }
    }
    fun getPostNewDoc(correo: String) {
        viewModelScope.launch {
            try {
                //myResponseNewDoc.value = UserNetwork.retrofit.getPostNewDoc(correo)
            } catch (e:Exception) {
                myResponseNewDoc.value = null
            }
        }
    }

}