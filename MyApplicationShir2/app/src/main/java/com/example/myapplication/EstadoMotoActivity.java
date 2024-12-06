package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class EstadoMotoActivity extends AppCompatActivity {

    private TextView tvEstadoGeneral;
    private Button btnActualizarEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_moto);

        // Vincular vistas
        tvEstadoGeneral = findViewById(R.id.tvEstadoGeneral);
        btnActualizarEstado = findViewById(R.id.btnActualizarEstado);

        // Configurar botón para actualizar estado
        btnActualizarEstado.setOnClickListener(v -> {
            // Aquí puedes agregar lógica para verificar sensores o una base de datos
            Toast.makeText(EstadoMotoActivity.this, "Estado actualizado correctamente", Toast.LENGTH_SHORT).show();
            tvEstadoGeneral.setText("Estado General: Bueno"); // Actualizar texto como ejemplo
        });
    }
}
