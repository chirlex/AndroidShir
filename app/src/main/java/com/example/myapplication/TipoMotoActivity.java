package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class TipoMotoActivity extends AppCompatActivity {

    private Spinner spinnerTiposMotos;
    private Button btnGuardarTipoMoto;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_moto);

        // Vincular vistas
        spinnerTiposMotos = findViewById(R.id.spinnerTiposMotos);
        btnRegresar= findViewById(R.id.Volverinicio);
        btnGuardarTipoMoto = findViewById(R.id.btnGuardarTipoMoto);

        btnRegresar.setOnClickListener(v2 -> {
            startActivity(new Intent(TipoMotoActivity.this, MainActivity2.class));
        });

        // Configurar botón para guardar
        btnGuardarTipoMoto.setOnClickListener(v -> {
            String tipoSeleccionado = spinnerTiposMotos.getSelectedItem().toString();

            // Aquí puedes guardar el tipo de moto en una base de datos (opcional)
            Toast.makeText(TipoMotoActivity.this, "Tipo de moto guardado: " + tipoSeleccionado, Toast.LENGTH_SHORT).show();
        });
    }
}
