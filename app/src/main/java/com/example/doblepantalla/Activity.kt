package com.example.doblepantalla

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_)
        // Referencias de los componentes del XML
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spinnerCarrera = findViewById<Spinner>(R.id.spinnerCarrera)
        val rgTurno = findViewById<RadioGroup>(R.id.rgTurno)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvResumen = findViewById<TextView>(R.id.tvResumen)
        val btnVolver = findViewById<Button>(R.id.btnVolverMenuFormulario)

        // Opciones del Spinner
        val carreras = arrayOf(
            "Selecciona una carrera",
            "Sistemas Embebidos",
            "Mecatrónica",
            "Industrial",
            "Diseño Industrial"
        )
        // Adaptador del Spinner
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            carreras
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item

        )
        spinnerCarrera.adapter = adapter

        // Botón Mostrar información
        btnMostrar.setOnClickListener {

            val nombre = etNombre.text.toString().trim()

            // Validar nombre
            if (nombre.isEmpty()) {
                etNombre.error = "Ingresa tu nombre"
                etNombre.requestFocus()
                return@setOnClickListener
            }

            // Validar carrera
            if (spinnerCarrera.selectedItemPosition == 0) {
                Toast.makeText(
                    this,
                    "Selecciona una carrera",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val carrera = spinnerCarrera.selectedItem.toString()

            // Validar turno
            val turnoSeleccionado = rgTurno.checkedRadioButtonId

            if (turnoSeleccionado == -1) {
                Toast.makeText(
                    this,
                    "Selecciona un turno",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            // Obtener el RadioButton seleccionado
            val radioTurno =
                findViewById<RadioButton>(turnoSeleccionado)

            val turno = radioTurno.text.toString()

            // Crear resumen
            val resumen = """
                Información del alumno
                
                Nombre: $nombre
                Carrera: $carrera
                Turno: $turno
            """.trimIndent()

            // Mostrar información en la misma pantalla
            tvResumen.text = resumen
        }

        // Botón para regresar al menú principal
        btnVolver.setOnClickListener {
            finish()
        }
    }
}