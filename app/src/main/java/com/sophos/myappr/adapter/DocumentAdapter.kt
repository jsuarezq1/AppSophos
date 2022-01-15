package com.sophos.myappr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sophos.myappr.Document
import com.sophos.myappr.R
import com.sophos.myappr.R.layout.item_documento


class DocumentAdapter(private val documentList: List<Document>): RecyclerView.Adapter<DocumentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DocumentViewHolder(layoutInflater.inflate( item_documento, parent, false))
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        val item = documentList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = documentList.size

}