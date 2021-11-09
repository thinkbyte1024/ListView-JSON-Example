/*
 * Copyright (c) 2021 Muhammad Aditya P. D.
 * You are prohibited to copy this source code without my permission
 * This project is intended for academic purpose only
 */
package com.example.listviewapp

import android.content.Intent
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.File
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengambil data melalui file JSON
        fun AssetManager.readFile(fileName: String) = open(fileName)
            .bufferedReader()
            .use { it.readText() }
        val fileLocation = "landmarks-data.json"

        // Membuat JSON
        val jsonData = this.assets.readFile(fileLocation)

        // Konversi file JSON menjadi GSON
        val sType = object : TypeToken<ArrayList<HashMap<String, String>>>() {}.type
        val landmarkData = Gson().fromJson<ArrayList<HashMap<String, String>>>(jsonData, sType)

        val listViewMain = findViewById<ListView>(R.id.listView_main)
        val mainAdapter = LandmarkAdapter(this, landmarkData)

        // Memasangkan adapter pada ListView
        listViewMain.adapter = mainAdapter

        listViewMain.setOnItemClickListener { parent, view, position, id ->
            val map = landmarkData.get(position)
            intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", map.get("name"))
            intent.putExtra("desc", map.get("desc"))
            intent.putExtra("icon", map.get("icon"))
            startActivity(intent)
        }
    }
}