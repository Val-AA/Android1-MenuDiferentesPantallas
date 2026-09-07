package com.example.doblepantalla

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Recomendaciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recomendaciones)

        val etGenero = findViewById<EditText>(R.id.etGenero)
        val btnRecomendar = findViewById<Button>(R.id.btnRecomendar)
        val tvRecomendaciones =
            findViewById<TextView>(R.id.tvRecomendaciones)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnRecomendar.setOnClickListener {

            val genero = etGenero.text.toString().trim().lowercase()

            val recomendaciones = when (genero) {

                "acción", "accion" ->
                    """
                    Recomendaciones de Acción:
                    
                    • John Wick
                    • Mad Max: Fury Road
                    • Gladiador
                    • Misión Imposible
                    • Top Gun: Maverick
                    """.trimIndent()

                "comedia" ->
                    """
                    Recomendaciones de Comedia:
                    
                    • Son como niños
                    • ¿Qué pasó ayer?
                    • Superbad
                    • Una esposa de mentira
                    • Escuela de Rock
                    """.trimIndent()

                "terror" ->
                    """
                    Recomendaciones de Terror:
                    
                    • El Conjuro
                    • It
                    • El Exorcista
                    • Siniestro
                    • La Noche del Demonio
                    """.trimIndent()

                "romance", "romántica", "romantica" ->
                    """
                    Recomendaciones de Romance:
                    
                    • Diario de una pasión
                    • La La Land
                    • Titanic
                    • Yo antes de ti
                    • Cuestión de tiempo
                    """.trimIndent()

                "ciencia ficción",
                "ciencia ficcion",
                "ficción",
                "ficcion" ->
                    """
                    Recomendaciones de Ciencia Ficción:
                    
                    • Interstellar
                    • Matrix
                    • Blade Runner 2049
                    • Dune
                    • Ready Player One
                    """.trimIndent()

                "animación", "animacion" ->
                    """
                    Recomendaciones de Animación:
                    
                    • Toy Story
                    • Shrek
                    • Coco
                    • Spider-Man: Into the Spider-Verse
                    • Cómo entrenar a tu dragón
                    """.trimIndent()

                else ->
                    "Género no encontrado. Intenta con acción, comedia, terror, romance, ciencia ficción o animación."
            }

            tvRecomendaciones.text = recomendaciones
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}