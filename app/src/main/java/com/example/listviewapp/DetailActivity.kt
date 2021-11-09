// Copyright
package com.example.listviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Variabel View
        val titleText = findViewById<TextView>(R.id.text_title)
        val descText = findViewById<TextView>(R.id.text_desc)
        val imgView = findViewById<ImageView>(R.id.img_Header)

        // Ambil nilai dari activity sebelummnya dan tempatkan pada masing-masing View
        titleText.text = intent.getStringExtra("title")
        descText.text = intent.getStringExtra("desc")
        imgView.setImageResource(this.resources.getIdentifier(intent.getStringExtra("icon"), "drawable", this.packageName))
    }
}