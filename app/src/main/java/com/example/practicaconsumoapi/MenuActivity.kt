package com.example.practicaconsumoapi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.practicaconsumoapi.vistas.ConsumoApiActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        btnMenu.setOnClickListener { navigateToConsumoApi() }
    }

    private fun navigateToConsumoApi(){
        val intent = Intent(this, ConsumoApiActivity::class.java)
        startActivity(intent)
    }




}