package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private Button btnEstadoMoto, btnMantenimiento, btnInfoMotos, btnKilometraje, btnTipoMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Vincular vistas
        btnEstadoMoto = findViewById(R.id.btnEstadoMoto);
        btnMantenimiento = findViewById(R.id.btnMantenimiento);
        btnInfoMotos = findViewById(R.id.btnInfoMotos);
        btnKilometraje = findViewById(R.id.btnKilometraje);
        btnTipoMoto = findViewById(R.id.btnTipoMoto);

        // Configurar botones para redirigir a actividades específicas
        btnEstadoMoto.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, com.example.myapplication.EstadoMotoActivity.class)));
        btnMantenimiento.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, MantenimientoActivity.class)));
        btnKilometraje.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, com.example.myapplication.KilometrajeActivity.class)));
        btnTipoMoto.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, com.example.myapplication.TipoMotoActivity.class)));
    }
}
