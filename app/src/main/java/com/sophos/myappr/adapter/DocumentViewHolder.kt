package com.sophos.myappr.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sophos.myappr.Document
import com.sophos.myappr.R


class DocumentViewHolder(view: View): RecyclerView.ViewHolder(view){

    val fecha = view.findViewById<TextView>(R.id.tvFecha)
    val tipoDoc = view.findViewById<TextView>(R.id.tvTipoDoc)
    val nombreC = view.findViewById<TextView>(R.id.tvNombreC)


    fun render(documentModel: Document) {
        fecha.text = documentModel.Fecha
        tipoDoc.text = documentModel.TipoAdjunto
        nombreC.text = documentModel.Nombre
    }
}