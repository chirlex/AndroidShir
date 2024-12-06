package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class TipoMotoActivity extends AppCompatActivity {

    private Spinner spinnerTiposMotos;
    private Button btnGuardarTipoMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_moto);

        // Vincular vistas
        spinnerTiposMotos = findViewById(R.id.spinnerTiposMotos);
        btnGuardarTipoMoto = findViewById(R.id.btnGuardarTipoMoto);

        // Configurar botón para guardar
        btnGuardarTipoMoto.setOnClickListener(v -> {
            String tipoSeleccionado = spinnerTiposMotos.getSelectedItem().toString();

            // Aquí puedes guardar el tipo de moto en una base de datos (opcional)
            Toast.makeText(TipoMotoActivity.this, "Tipo de moto guardado: " + tipoSeleccionado, Toast.LENGTH_SHORT).show();
        });
    }
}
