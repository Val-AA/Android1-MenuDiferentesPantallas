package com.example.doblepantalla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IMC_calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        val etPeso =findViewById<EditText>(R.id.etPeso)
        val etAltura=findViewById<EditText>(R.id.etAltura)
        val btnIMC=findViewById<Button>(R.id.btnIMC)
        val btnReg=findViewById<Button>(R.id.btnReg)

        btnIMC.setOnClickListener {
            val peso=etPeso.text.toString().toDoubleOrNull()
            val altura=etAltura.text.toString().toDoubleOrNull()

            if(peso==null || altura==null || altura<=0 || peso<=0){
                if(peso==null){
                    etPeso.error="Ingresa un peso válido"
                }
                if(altura==null){
                    etAltura.error="Ingresa una altura válida"
                }
                return@setOnClickListener
            }
            val imc=peso/(altura*altura)
            val intent= Intent(this, IMC_results::class.java)
            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
        btnReg.setOnClickListener {
            finish()
        }
   }
}
