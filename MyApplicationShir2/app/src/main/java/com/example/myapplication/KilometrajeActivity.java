package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class KilometrajeActivity extends AppCompatActivity {

    private EditText etKilometraje;
    private Button btnGuardarKilometraje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilometraje);

        // Vincular vistas
        etKilometraje = findViewById(R.id.etKilometraje);
        btnGuardarKilometraje = findViewById(R.id.btnGuardarKilometraje);

        // Configurar botón para guardar
        btnGuardarKilometraje.setOnClickListener(v -> {
            String kilometraje = etKilometraje.getText().toString();

            // Validar si el usuario ingresó un valor
            if (!kilometraje.isEmpty()) {
                // Aquí puedes guardar el kilometraje en una base de datos (opcional)
                Toast.makeText(KilometrajeActivity.this, "Kilometraje guardado: " + kilometraje + " km", Toast.LENGTH_SHORT).show();
                etKilometraje.setText(""); // Limpiar el campo
            } else {
                Toast.makeText(KilometrajeActivity.this, "Por favor, ingresa un valor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
