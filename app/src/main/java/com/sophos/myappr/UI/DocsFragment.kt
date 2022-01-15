package com.sophos.myappr.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sophos.myappr.Document
import com.sophos.myappr.MainActivityViewModel
import com.sophos.myappr.adapter.SuperHeroAdapter
import com.sophos.myappr.adapter.SuperHeroProvider
import java.util.ArrayList
import java.util.HashMap
import com.sophos.myappr.SuperHero
import com.sophos.myappr.adapter.DocumentAdapter
import com.sophos.myappr.databinding.FragmentItemList2Binding
import kotlin.collections.mutableListOf as mutableListOf1

/**
 * A fragment representing a list of Items.
 */
class DocsFragment : Fragment() {

    private var _binding: FragmentItemList2Binding? = null
    private val binding get()= _binding!!
    private var columnCount = 1
    lateinit var mRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemList2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        val TAG2 = "Opciones"
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        var listaDoc: MutableList<Document> = mutableListOf1()
        var nombreCompleto : String

        viewModel.getPostDoc("jsuarezq1@gmail.com")
        println("pasa por aqui")
        viewModel.myResponseDoc.observe(this, Observer {
            val m: Int = it.ScannedCount.toInt()
            Log.d(TAG2, it.ScannedCount.toString())
            Log.d(TAG2, it.Count.toString())
            for(i in 0 .. m) {
                println (i)
                Log.d(TAG2, it.Items[i].Nombre.toString())
                Log.d(TAG2, it.Items[i].Apellido.toString())
                Log.d(TAG2, it.Items[i].Fecha.toString())
                Log.d(TAG2, it.Items[i].TipoAdjunto.toString())
                Log.d(TAG2, it.Items[i].IdRegistro.toString())
                nombreCompleto = "${it.Items[i].Nombre.toString()} ${it.Items[i].Apellido.toString()}"
                println(nombreCompleto)
                val mySuper = Document(it.Items[i].IdRegistro,it.Items[i].Fecha, it.Items[i].TipoId,it.Items[i].Identificacion, nombreCompleto,it.Items[i].Apellido,it.Items[i].Ciudad,"","", it.Items[i].Adjunto)
                println(mySuper)
                listaDoc.add(i,mySuper)
                //initRecyclerView(listaDoc)
                initRecyclerView(listaDoc)

            }
            println("va la lista")
            println(listaDoc)

        })
        println("va la lista 2")
        println(listaDoc)
        //

        //initRecyclerView(listaDoc)
    }
    fun initRecyclerView(listax: List<Document>) {

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = DocumentAdapter(listax)
    }

    fun listar():List<SuperHero>{
        val TAG2 = "Opciones"
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        var listaDoc: MutableList<SuperHero> = mutableListOf1()
        var nombreCompleto : String

        viewModel.getPostDoc("jsuarezq1@gmail.com")
        println("pasa por aqui")
        viewModel.myResponseDoc.observe(this, Observer {
            val m: Int = it.ScannedCount.toInt()
            Log.d(TAG2, it.ScannedCount.toString())
            Log.d(TAG2, it.Count.toString())
            for(i in 0 .. m) {
                println (i)
                Log.d(TAG2, it.Items[i].Nombre.toString())
                Log.d(TAG2, it.Items[i].Apellido.toString())
                Log.d(TAG2, it.Items[i].Fecha.toString())
                Log.d(TAG2, it.Items[i].TipoAdjunto.toString())
                Log.d(TAG2, it.Items[i].IdRegistro.toString())
                nombreCompleto = "${it.Items[i].Nombre.toString()} ${it.Items[i].Apellido.toString()}"
                println(nombreCompleto)
                val mySuper = SuperHero(it.Items[i].Nombre, it.Items[i].Apellido,"das","")
                println(mySuper)
                listaDoc.add(i,mySuper)
                println("va la lista")
                println(listaDoc)
                }

            })
        println("va la lista 2")
        println(listaDoc)
        return listaDoc

    }


}