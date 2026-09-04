package com.brayan.marcadorvoley

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.brayan.marcadorvoley.databinding.ActivityPartidoBinding

class Partido : AppCompatActivity() {

    // ViewBinding: reemplaza a findViewById
    private lateinit var binding: ActivityPartidoBinding

    companion object {
        const val PUNTAJE_MINIMO = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibe los datos enviados desde Configuracion
        val equipo1 = intent.getStringExtra(Configuracion.EXTRA_EQUIPO1)
            ?: getString(R.string.sin_dato)
        val equipo2 = intent.getStringExtra(Configuracion.EXTRA_EQUIPO2)
            ?: getString(R.string.sin_dato)

        binding.tvNombreEquipo1.text = equipo1
        binding.tvNombreEquipo2.text = equipo2

        binding.btnSumar1.setOnClickListener { cambiarPuntos(binding.tvMarcador1, 1) }
        binding.btnRestar1.setOnClickListener { cambiarPuntos(binding.tvMarcador1, -1) }
        binding.btnSumar2.setOnClickListener { cambiarPuntos(binding.tvMarcador2, 1) }
        binding.btnRestar2.setOnClickListener { cambiarPuntos(binding.tvMarcador2, -1) }
    }

    // Lee el marcador con toInt, lo opera y lo muestra
    private fun cambiarPuntos(marcador: TextView, cantidad: Int) {
        val actual = marcador.text.toString().toInt()
        val nuevo = calcularPuntaje(actual, cantidad)
        marcador.text = nuevo.toString()
    }

    // Metodo con parametro y valor de retorno
    private fun calcularPuntaje(actual: Int, cantidad: Int): Int {
        val nuevo = actual + cantidad
        return if (nuevo < PUNTAJE_MINIMO) PUNTAJE_MINIMO else nuevo
    }
}
