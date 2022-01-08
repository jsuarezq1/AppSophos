package com.sophos.myappr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class Opciones : AppCompatActivity() {
    private val TAG2 = "Opciones"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val btn_7 = findViewById<Button>(R.id.button7)
        val btn_8 = findViewById<Button>(R.id.button8)
        val btn_9 = findViewById<Button>(R.id.button9)
        val texto6 = findViewById<TextView>(R.id.textView6)
        val texto7 = findViewById<TextView>(R.id.textView7)

        val name=intent.getStringExtra("username")
        val correo=intent.getStringExtra("correo")
        println(name)
        println(correo)

        texto6.text = name.toString()

        //Enviar Documento
        btn_7.setOnClickListener {
            texto7.text = correo
            if (correo != null) {
                println("Paso por aca")
                viewModel.getPostNewDoc( "jsuarezq1@gmail.com", "Periodico", "Oscar", "Sanchez", "Pasto", "RC", "12122","adad" )
                println("Paso por aca 2 ")
            }

            viewModel.myResponseNewDoc.observe(this, Observer {
                println("Paso por aca 3")
                if (true) {
                    Log.d(TAG2, it.put.toString())
                    Log.d(TAG2, it.Identificacion.toString())
                    Log.d(TAG2, it.TipoAdjunto.toString())
                    texto7.text = "Enviado Documento"
                } else texto7.text = "error de Envio"
            })

        }

        //Ver Documentos
        btn_8.setOnClickListener {
            texto7.text = correo
            viewModel.getPostDoc("jsuarezq1@gmail.com")
            println("pasa por aqui")
            viewModel.myResponseDoc.observe(this, Observer {
                val m: Int = it.ScannedCount.toInt()
                Log.d(TAG2, it.ScannedCount.toString())
                Log.d(TAG2, it.Count.toString())
                for(i in 0 .. m) {
                    Log.d(TAG2, it.Items[i].Nombre.toString())
                    Log.d(TAG2, it.Items[i].Apellido.toString())
                    Log.d(TAG2, it.Items[i].Fecha.toString())
                    Log.d(TAG2, it.Items[i].TipoAdjunto.toString())
                    Log.d(TAG2, it.Items[i].IdRegistro.toString())
                }
                texto7.text = it.Count.toString()

            })
            //texto7.text = "error de recepcion"
        }

        // Ver mapa
        btn_9.setOnClickListener {

            val oficinas = mutableListOf<String>()

            viewModel.getPosts()
            viewModel.myResponseList.observe(this, Observer {
                if (it != null) {
                    for (city in it) {

                        for (i in 0..7) {
                            Log.d(TAG2, city.Items[i].IdOficina.toString())
                            Log.d(TAG2, city.Items[i].Ciudad.toString())
                            Log.d(TAG2, city.Items[i].Latitud)
                            Log.d(TAG2, city.Items[i].Longitud)
                            Log.d(TAG2, city.Items[i].Nombre.toString())
                            if (!oficinas.contains(city.Items[i].Ciudad.toString())){
                                oficinas.add(city.Items[i].Ciudad.toString())}

                        }
                    }
                    texto7.text = "funciona"
                    println("Entrees: $oficinas")
                } else texto7.text = "error"
            })

            val intento1 = Intent(this, MapsActivity::class.java)
            //intento1.putExtra("username", it.nombre.toString())
            startActivity(intento1)
        }
    }
}