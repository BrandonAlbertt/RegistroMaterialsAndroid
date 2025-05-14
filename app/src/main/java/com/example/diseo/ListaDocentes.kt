package com.example.diseo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diseo.adaptador.DocenteAdapter
import com.example.diseo.dao.DocenteDao
import com.google.android.material.button.MaterialButton

class ListaDocentes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var docenteAdapter: DocenteAdapter
    // boton para agregar docente
    private lateinit var btnAgregar: MaterialButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_docentes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Asignar el botón para del activity por ID
        btnAgregar = findViewById(R.id.btnGuardar2)


        recyclerView = findViewById(R.id.recyclerViewDocentes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cargar la lista de docentes desde la base de datos
        val docenteDao = DocenteDao(this)
        val docentes = docenteDao.listarDocentes()

        // Configurar el adaptador con la lista de docentes
        docenteAdapter = DocenteAdapter(docentes)
        recyclerView.adapter = docenteAdapter


        btnAgregar.setOnClickListener() {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}