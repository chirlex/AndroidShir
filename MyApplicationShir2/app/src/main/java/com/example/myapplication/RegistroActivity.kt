package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Inicializar los campos de texto con los ID correspondientes
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        // Configurar el botón de registro
        btnRegister.setOnClickListener {
            // Obtener los valores de los campos de texto
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Validación de los campos
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            } else if (!email.contains("@")) {
                Toast.makeText(this, "Ingrese un correo válido", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí puedes agregar el código para registrar al usuario (por ejemplo, llamando a una API o base de datos)
                // En este ejemplo solo mostramos un mensaje de éxito
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                // Navegar a la actividad de inicio de sesión tras el registro exitoso
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Terminar esta actividad para que no se quede en la pila de actividades
            }
        }
    }
}