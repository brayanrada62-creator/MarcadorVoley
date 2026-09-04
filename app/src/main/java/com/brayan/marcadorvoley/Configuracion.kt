package com.brayan.marcadorvoley

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brayan.marcadorvoley.databinding.ActivityConfiguracionBinding

class Configuracion : AppCompatActivity() {

    // ViewBinding: reemplaza a findViewById
    private lateinit var binding: ActivityConfiguracionBinding

    companion object {
        const val EXTRA_EQUIPO1 = "extra_equipo1"
        const val EXTRA_EQUIPO2 = "extra_equipo2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComenzar.setOnClickListener { procesarEquipos() }
    }

    // Captura el dato, lo valida y lo envia
    private fun procesarEquipos() {
        val equipo1 = binding.etEquipo1.text.toString()
        val equipo2 = binding.etEquipo2.text.toString()

        if (equipo1.isBlank() || equipo2.isBlank()) {
            binding.tvResultado.text = getString(R.string.error_vacio)
            return
        }

        abrirPartido(equipo1, equipo2)
    }

    // Navega a Partido enviando los nombres
    private fun abrirPartido(equipo1: String, equipo2: String) {
        val intent = Intent(this, Partido::class.java)
        intent.putExtra(EXTRA_EQUIPO1, equipo1)
        intent.putExtra(EXTRA_EQUIPO2, equipo2)
        startActivity(intent)
    }
}
