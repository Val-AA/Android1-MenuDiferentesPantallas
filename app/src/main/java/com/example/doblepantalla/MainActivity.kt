package com.example.doblepantalla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnArea = findViewById<Button>(R.id.btnArea)
        val btnRecomendaciones = findViewById<Button>(R.id.btnRecomendaciones)
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        val btnFormulario = findViewById<Button>(R.id.btnFormulario)

        btnArea.setOnClickListener {
            val intent = Intent(this, AreaCalculo::class.java)
            startActivity(intent)
        }

        btnRecomendaciones.setOnClickListener {
            val intent = Intent(this, Recomendaciones::class.java)
            startActivity(intent)
        }

        btnIMC.setOnClickListener {
            val intent = Intent(this, IMC_calculator::class.java)
            startActivity(intent)
        }
        btnFormulario.setOnClickListener {
            val intent =
                Intent(this, Activity::class.java)

            startActivity(intent)
        }
    }
}