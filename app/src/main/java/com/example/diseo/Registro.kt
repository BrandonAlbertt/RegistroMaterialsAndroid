package com.example.diseo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// LOS IMPORTS DEL SPINNER
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.diseo.dao.DocenteDao
import com.example.diseo.entidad.Docente
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class Registro : AppCompatActivity() {

    // seclaramos el objeto del spinner
    private lateinit var spnGenero: AutoCompleteTextView
    // declaramos el objeto de la clase Button
    private lateinit var btnRegresar: MaterialButton
    private lateinit var btnGuardar: MaterialButton
    // declaramos los objetos de los campos a rellenar
    private lateinit var txiNombre: TextInputEditText
    private lateinit var txiPaterno: TextInputEditText
    private lateinit var txiMaterno: TextInputEditText
    private lateinit var txiSueldo: TextInputEditText
    private lateinit var txiHijos: TextInputEditText






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Asignamos los botones a sus respectivas variables ID
        btnGuardar = findViewById(R.id.btnGuardar)
        btnRegresar = findViewById(R.id.btnRegresar)
        // Asignamos los campos tipo edittext que son TextInputEditText a
        //  sus respectivas variables ID
        txiNombre = findViewById(R.id.edtNombre)
        txiPaterno = findViewById(R.id.edtPaterno)
        txiMaterno = findViewById(R.id.edtMaterno)
        txiSueldo = findViewById(R.id.edtSueldo)
        txiHijos = findViewById(R.id.edtHijos)
        // Asignamos el spinner a su respectiva variable
        spnGenero = findViewById(R.id.spnGenero)

        // Pasar el array de strings al spinner
        val generos = resources.getStringArray(R.array.genero_persona)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, generos)
        spnGenero.setAdapter(adapter)

        // Configurar el botón para regresar a la actividad anterior
        btnRegresar.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // registrar Docente
        btnGuardar.setOnClickListener {
            val nombre = txiNombre.text.toString().trim()
            val paterno = txiPaterno.text.toString().trim()
            val materno = txiMaterno.text.toString().trim()
            val genero = spnGenero.text.toString().trim()
            val sueldo = txiSueldo.text.toString().trim()
            val hijos = txiHijos.text.toString().trim()

            // validacion basica si los campos estan vacios
            if (nombre.isEmpty() || paterno.isEmpty() || materno.isEmpty() || genero.isEmpty() || sueldo.isEmpty() || hijos.isEmpty() ) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val docente = Docente(
                nombreE = nombre,
                paternoE = paterno,
                maternoE = materno,
                generoE = genero,
                sueldoE = sueldo.toDoubleOrNull() ?: 0.0,
                hijosE = hijos.toIntOrNull() ?: 0
            )

            val dao = DocenteDao(this)
            val resultado = dao.insertar(docente)

            if (resultado != -1L) {
                Toast.makeText(this, "Docente registrado con éxito", Toast.LENGTH_SHORT).show()
                // Limpiar campos si deseas
                txiNombre.text?.clear()
                txiPaterno.text?.clear()
                txiMaterno.text?.clear()
                txiSueldo.text?.clear()
                txiHijos.text?.clear()
                spnGenero.setText("")
                val intent = Intent(this, ListaDocentes::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error al registrar docente", Toast.LENGTH_SHORT).show()
            }

        }


    }
}