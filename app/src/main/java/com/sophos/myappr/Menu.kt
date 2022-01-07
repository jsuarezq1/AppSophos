package com.sophos.myappr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sophos.myappr.databinding.ActivityMainBinding

class Menu : AppCompatActivity() {

    private val TAG = "Menu"
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bundle = intent.extras
        val dato = bundle?.getString("miNombre")


        val btn_4 = findViewById<Button>(R.id.button4)
        val btn_5 = findViewById<Button>(R.id.button5)
        val btn_6 = findViewById<Button>(R.id.button6)
        val texto3 = findViewById<TextView>(R.id.textView3)
        val texto4 = findViewById<TextView>(R.id.textView4)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        texto3.text = dato.toString()


        btn_4.setOnClickListener {
            viewModel.getPosts()
            viewModel.myResponseList.observe(this, Observer {
                if (it != null) {
                    for(city in it) {
                        for (i in 0..7) {
                            Log.d(TAG, city.Items[i].IdOficina.toString())
                            Log.d(TAG, city.Items[i].Ciudad.toString())
                            Log.d(TAG, city.Items[i].Latitud)
                            Log.d(TAG, city.Items[i].Longitud)
                            Log.d(TAG, city.Items[i].Nombre.toString())
                        }
                    }
                    texto4.text = "funciona"
                } else texto4.text = "error"
            })
        }

        btn_5.setOnClickListener {
            viewModel.getPostUser()
            viewModel.myResponseUser.observe(this, Observer {
                if (it != null) {
                    texto4.text = it.nombre.toString()
                    Log.d(TAG, it.nombre.toString())
                    Log.d(TAG, it.apellido.toString())
                } else texto4.text = "error"
            })
        }

        btn_6.setOnClickListener {
            viewModel.getPostUserQ( "jsuarezq1@gmail.com", "tYGZ6ZdLVJdknjav")
            viewModel.myResponseUserQ.observe(this, Observer {
                if (it != null) {
                    texto4.text = it.nombre.toString()
                    Log.d(TAG, it.nombre.toString())
                    Log.d(TAG, it.apellido.toString())
                } else texto4.text = "error"
            })
        }

    }
}