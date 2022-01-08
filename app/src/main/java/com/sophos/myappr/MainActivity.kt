package com.sophos.myappr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sophos.myappr.databinding.ActivityMainBinding
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val ciudad1 = findViewById<EditText>(R.id.etCity)

        val btn_1 = findViewById<Button>(R.id.button)
        val btn_2 = findViewById<Button>(R.id.button2)
        val btn_3 = findViewById<Button>(R.id.button3)

        val texto = findViewById<TextView>(R.id.textView2)
        val texto2 = findViewById<TextView>(R.id.textView3)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        btn_1.setOnClickListener {
            val miCiudad: String = ciudad1.text.toString()
            val miPass: String = password.text.toString()
            viewModel.getPostX(miCiudad)
                viewModel.myResponseX.observe(this, Observer {
                    if (it != null) {
                        Log.d(TAG, it.Items[0].Ciudad)
                        Log.d(TAG, it.Items[0].IdOficina.toString())
                        Log.d(TAG, it.Items[0].Latitud.toString())
                        Log.d(TAG, it.Items[0].Longitud.toString())
                        texto.text = miPass
                    } else texto.text = "error de ciudad"
                })
            email.setText("")
            password.setText("")
            ciudad1.setText("")
        }

        btn_2.setOnClickListener {
            //Cambio de Activity
            val intento1 = Intent(this, Opciones::class.java)
            startActivity(intento1)
            //finish()
        }

        btn_3.setOnClickListener {
            val miCorreo: String = email.text.toString()
            texto2.text = miCorreo
            val miPass: String = password.text.toString()
            println(miCorreo)
            if (miCorreo.length>3 && miCorreo.contains('@')) {
                println(miCorreo)
                viewModel.getPostUserQ(miCorreo, "tYGZ6ZdLVJdknjav")
                viewModel.myResponseUserQ.observe(this, Observer {
                    if (it.acceso) {
                        Log.d(TAG, it.nombre.toString())
                        Log.d(TAG, it.apellido.toString())

                        val intento1 = Intent(this, Opciones::class.java)
                        intento1.putExtra("username", it.nombre.toString())
                        intento1.putExtra("correo", miCorreo)
                        startActivity(intento1)
                        } else texto.text = "No existe usuario"
                    })
                texto.text = "No entra "

            }
            else texto.text = "ingrese correo"
            email.setText("")
            password.setText("")
            ciudad1.setText("")
            //texto.setText("")
        }

    }


}

