package com.example.diseo

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    // Inicializamos los elementos de la interfaz
    private lateinit var edtUsuario: TextInputEditText
    private lateinit var edtPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var txtTitle: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Asignamos los elementos a sus respectivas variables
        edtUsuario = findViewById(R.id.edtUsuario)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtTitle = findViewById(R.id.txtTitle)

        // Configuramos el botón para realizar la acción de inicio de sesión
        btnLogin.setOnClickListener {
            val usuario = edtUsuario.text.toString()
            val password = edtPassword.text.toString()

            // Puedes validar los campos antes de hacer algo
            if (usuario.isEmpty() || password.isEmpty()) {
                // Muestra un mensaje de error o realiza alguna acción
                txtTitle.text = "Por favor ingresa tus credenciales."
            } else {
                // Aquí pondrías la lógica para procesar el inicio de sesión
                txtTitle.text = "Iniciando sesión.."
            }
        }
    }


}