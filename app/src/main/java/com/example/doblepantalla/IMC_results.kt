package com.example.doblepantalla

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMC_results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_results)
        val tvResultadoIMC=findViewById<TextView>(R.id.tvResultadoIMC)
        val tvClasificacion=findViewById<TextView>(R.id.tvClasificacion)
        val btnReg2=findViewById<Button>(R.id.btnReg2)
        val imc = intent.getDoubleExtra("IMC", 0.0)
        val clasificacion=if(imc<18.5){
            "Bajo peso"
        }
        else if (imc<25.0){
            "Peso normal"
        }
        else if (imc<30.0){
            "Sobrepeso"
        }
        else{
            "Obesidad"
        }
        tvResultadoIMC.text=String.format("IMC: %.2f", imc)
        tvClasificacion.text="Clasificación: $clasificacion"
        btnReg2.setOnClickListener {
            finish()
        }
    }
}