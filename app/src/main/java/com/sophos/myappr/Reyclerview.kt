package com.sophos.myappr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sophos.myappr.adapter.DocumentAdapter
import com.sophos.myappr.adapter.SuperHeroAdapter
import com.sophos.myappr.adapter.SuperHeroProvider

class Reyclerview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reyclerview)
        initRecyclerView()
    }

    fun initRecyclerView() {
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerDocumento)
        //recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList)
        //recyclerView.adapter = DocumentAdapter(DocumentProvider.documentList)
    }
}