package com.brayan.marcadorvoley

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brayan.marcadorvoley.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding: reemplaza a findViewById
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsiguiente.setOnClickListener { abrirConfiguracion() }
    }

    // Navega a la segunda Activity
    private fun abrirConfiguracion() {
        val intent = Intent(this, Configuracion::class.java)
        startActivity(intent)
    }
}
