package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MantenimientoActivity extends AppCompatActivity {

    private TextView tvProximoMantenimiento;
    private Button btnDetallesMantenimiento;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_mantenimiento);

        // Vincular vistas
        tvProximoMantenimiento = findViewById(R.id.tvProximoMantenimiento);
        btnDetallesMantenimiento = findViewById(R.id.btnDetallesMantenimiento);

        // Configurar botón de detalles
        btnDetallesMantenimiento.setOnClickListener(v ->
                Toast.makeText(MantenimientoActivity.this, "Revisar filtro de aceite y llantas", Toast.LENGTH_SHORT).show()
        );
    }
}


