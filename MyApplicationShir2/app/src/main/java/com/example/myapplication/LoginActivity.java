package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnIniciarSesion, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular vistas
        etEmail = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        // Configurar botón de inicio de sesión
        btnIniciarSesion.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (!email.isEmpty() && !password.isEmpty()) {
                // Aquí puedes validar el inicio de sesión con una base de datos o autenticación
                Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity2.class)); // Redirigir al menú principal
            } else {
                Toast.makeText(LoginActivity.this, "Por favor, completa los campos", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar botón de registro
        btnRegistrarse.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class)); // Redirigir a la pantalla de registro
        });
    }
}
